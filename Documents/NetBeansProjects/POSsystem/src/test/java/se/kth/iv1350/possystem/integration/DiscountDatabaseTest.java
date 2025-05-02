package se.kth.iv1350.possystem.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.possystem.model.SaleDTO;

/**
 *
 * @author Digit
 */
public class DiscountDatabaseTest {
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of checkForDiscount method, of class DiscountDatabase.
     */
    @Test
    public void testCheckForDiscount() {
        System.out.println("checkForDiscount");
        SaleDTO sale = null;
        DiscountDatabase instance = new DiscountDatabase();
        double result = instance.checkForDiscount(sale);
        assertEquals(result, 2.5);
    }
    
}
