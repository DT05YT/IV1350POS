package se.kth.iv1350.possystem.model;

/**
 *
 * @author Digit
 */
public class ReceiptDTO {
    private final double amountPaid;
    private final double change;
    private final SaleDTO saleInfo;
    
    public ReceiptDTO(double amountPaid, double change, SaleDTO saleInfo) {
        this.amountPaid = amountPaid;
        this.change = change;
        this.saleInfo = saleInfo;
    }
    
    public double getAmountPaid() {
        return this.amountPaid;
    }
    public double getChange() {
        return this.change;
    }
    public SaleDTO getSaleInfo() {
        return this.saleInfo;
    }
}
