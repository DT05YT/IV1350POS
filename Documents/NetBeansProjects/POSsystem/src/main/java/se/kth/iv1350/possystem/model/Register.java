package se.kth.iv1350.possystem.model;

/**
 *
 * @author Digit
 */
public class Register {
    private double balance;
    public Register() {
        this.balance = 0;
    }
    /*
    Updates the balance in the register.
    
    @param saleInfo The sale information.
    */
    public void updateBalance(SaleDTO saleInfo) {
        this.balance += saleInfo.getTotalPrice();
    }
}
