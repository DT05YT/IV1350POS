package se.kth.iv1350.possystem.model;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.possystem.integration.ItemDTO;
/**
 *
 * @author Digit
 */
public class Sale {
    private ItemDTO[] itemList;
    private int amountOfItems;
    private int currentMax;
    private double totalPrice;
    private double totalRawPrice;
    private double totalVAT;
    private final int customerID;
    private double discountSum;
    
    private List<RevenueObserver> revenueObservers;
    
    /*
    Creates a Sale object.
    */
    public Sale(int customerID) {
        this.itemList = new ItemDTO[100];
        this.amountOfItems = 0;
        this.currentMax = 100;
        this.totalPrice = 0;
        this.totalRawPrice = 0;
        this.totalVAT = 0;
        this.customerID = customerID;
        this.discountSum = 0;
        this.revenueObservers = new ArrayList<>();
    }
    /*
    Updates the current sale.
    
    @param item The item(s) to add to the current sale.    
    */
    public void updateSale(ItemDTO item) {
        if (this.amountOfItems == currentMax) {
            this.itemList = this.increaseBasketMax(itemList, this.currentMax);
            this.currentMax = this.currentMax * 2;
        }
        this.itemList[this.amountOfItems] = item;
        this.totalRawPrice += item.getPrice() * item.getAmount();
        this.totalPrice += (item.getPrice() * (1 + item.getVAT())) * item.getAmount();
        this.totalVAT = this.totalPrice - this.totalRawPrice;
        this.totalPrice = (double) Math.round(this.totalPrice * 100) / 100;
        this.totalRawPrice = (double) Math.round(this.totalRawPrice * 100) / 100;
        this.totalVAT = (double) Math.round(this.totalVAT * 100) / 100;
        this.amountOfItems++;
    }
    /*
    Adds a discountSum to the total discount counter, to be removed later.
    
    @param discountSum The discount amount to add.
    */
    public void applyDiscounts(double discountSum) {
        this.discountSum += discountSum;
    }
    /*
    Gets the sale DTO.
    
    @return The sale information as a DTO.
    */
    public SaleDTO getSaleDTO() {
        return new SaleDTO(this.itemList, this.totalPrice, this.totalRawPrice, this.totalVAT, this.customerID, this.discountSum);
    }
    /*
    Makes a ReceiptDTO
    
    @param amountPaid The paid amount by the customer.
    @return The receipt DTO that was generated.
    */
    public ReceiptDTO generateReceipt(double amountPaid) {
        double change = (double) Math.round((amountPaid - (this.totalPrice)) * 100) / 100;
        SaleDTO saleInfo = getSaleDTO();
        return new ReceiptDTO(amountPaid, change, saleInfo);
    }
    
    /*
    Ends the sale and returns the current sale information, and recalculates the final price.
    
    @return The final state of the sale.
    */
    public SaleDTO finalizeSale() {
        this.totalPrice = (double) Math.round(100 * (this.totalVAT + this.totalRawPrice - this.discountSum)) / 100;
        for (RevenueObserver revObs : this.revenueObservers) {
            revObs.updateObserversWithRevenue(this.totalPrice);
        }
        return getSaleDTO();
    }
    
    private ItemDTO[] increaseBasketMax(ItemDTO[] itemList, int max) {
        ItemDTO[] newList = new ItemDTO[max * 2];
        System.arraycopy(itemList, 0, newList, 0, max);
        return newList;
    }
    
    public void addRevenueObserver(RevenueObserver revObs) {
        this.revenueObservers.add(revObs);
    }
}
