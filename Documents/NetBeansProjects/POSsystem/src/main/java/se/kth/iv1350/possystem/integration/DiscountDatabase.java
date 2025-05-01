package se.kth.iv1350.possystem.integration;
import se.kth.iv1350.possystem.model.SaleDTO;
/**
 *
 * @author Digit
 */
public class DiscountDatabase {
    public DiscountDatabase() {
        
    };
    /*
    Checks ID and the sale information against a database to find discounts, however
    this is not handled and just returns a hardcoded value to reduce (as instructed)
    
    @param saleInfo The current state of the sale.
    @return The amount to remove from the total.
    */
    public double checkForDiscount(SaleDTO sale) {
        return 2.50;
    }
}
