package se.kth.iv1350.possystem.model;

import se.kth.iv1350.possystem.integration.ItemDTO;

/**
 *
 * @author Digit
 */
public class SaleDTO {
    private final ItemDTO[] itemList;
    private final double totalPrice;
    private final double totalRaw;
    private final double totalVAT;
    private final int customerID;
    private final double discountSum;
    
    /*
    Makes a SaleDTO for transfer to other layers.
    
    @return Returns the sale description as a DTO.
    */
    public SaleDTO(ItemDTO[] itemList, double totalPrice, double totalRaw, double totalVAT, int customerID, double discountSum) {
        this.itemList = itemList;
        this.totalPrice = totalPrice;
        this.totalRaw = totalRaw;
        this.totalVAT = totalVAT;
        this.customerID = customerID;
        this.discountSum = discountSum;
    }
    
    public ItemDTO[] getItemList() {
        return this.itemList;
    }
    
    public double getTotalPrice() {
        return this.totalPrice;
    }
    
    public double getTotalRaw() {
        return this.totalRaw;
    }
    
    public double getTotalVat() {
        return this.totalVAT;
    }
    
    public int getCustomerID() {
        return this.customerID;
    }
    
    public double getDiscountSum() {
        return this.discountSum;
    }
}
