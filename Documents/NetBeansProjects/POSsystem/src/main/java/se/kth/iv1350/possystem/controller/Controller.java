package se.kth.iv1350.possystem.controller;
import se.kth.iv1350.possystem.integration.ItemDTO;
import se.kth.iv1350.possystem.model.SaleDTO;
import se.kth.iv1350.possystem.model.ReceiptDTO;
import se.kth.iv1350.possystem.integration.DiscountDatabase;
import se.kth.iv1350.possystem.integration.ExternalAccounting;
import se.kth.iv1350.possystem.integration.ExternalInventory;
import se.kth.iv1350.possystem.integration.Printer;
import se.kth.iv1350.possystem.model.Sale;
import se.kth.iv1350.possystem.model.Register;
/**
 *
 * @author Digit
 */
public class Controller {
    
    private ExternalAccounting extAcc;
    private ExternalInventory extInv;
    private DiscountDatabase disDat;
    private Sale sale;
    private Printer printer;
    private Register register;
    
    public Controller(ExternalAccounting extAcc, ExternalInventory extInv, DiscountDatabase disDat, Printer printer) {
        this.extAcc = extAcc;
        this.extInv = extInv;
        this.disDat = disDat;
        this.printer = printer;
        this.register = new Register();
    }
    /*
    Initiates the sale by creating the "Sale" object.
    
    @param customerID The ID of the customer.
    */
    public void startSale(int customerID) {
        this.sale = new Sale(customerID);
    }
    /*
    Takes the ID that was scanned (or manually entered) and finds the
    corresponding ItemDTO.

    @param ID The ID of the item that was scanned or entered.
    @param quantity The amount of items scanned or entered.
    @return An ItemDTO that corresponds to the ID entered, with the quantity entered.
    */
    public ItemDTO enterItemID(int ID, int quantity) {
        ItemDTO item = extInv.getItem(ID, quantity);
        sale.updateSale(item);
        return item;
    }
    /*
    Gets a saleDTO and returns it.
    
    @return The current state of the sale.
    */
    public SaleDTO getSaleInfo() {
        return sale.getSaleDTO();
    }
    /*
    Starts the discount search process.
    
    @return The discount sum to be removed.
    */
    public double askForDiscount() {
        SaleDTO saleInfo = getSaleInfo();
        double discountSum = disDat.checkForDiscount(saleInfo);
        sale.applyDiscounts(discountSum);
        return discountSum;
    }
    /*
    Inserts the payment and sends out information about the purchase.

    @param payment The payment given by the customer.
    @return The amount of change.
    */
    public double pay(double payment) {
        ReceiptDTO receiptInfo = sale.generateReceipt(payment);
        SaleDTO saleInfo = receiptInfo.getSaleInfo();
        printer.printReceipt(receiptInfo);
        extInv.updateInventory(saleInfo);
        extAcc.updateAccounting(saleInfo);
        register.updateBalance(saleInfo);
        return receiptInfo.getChange();
    }
    /*
    Ends the payment process.

    @return The amount to be paid.
    */
    public double endSale() {
        SaleDTO saleInfo = sale.finalizeSale();
        double total = saleInfo.getTotalPrice();
        return total;
    }
}
