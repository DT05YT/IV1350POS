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
public class ExternalInventoryTest {
    
    public ExternalInventoryTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of updateInventory method is not needed, as it is not handled.
     */
    @Test
    public void testUpdateInventory() {
    }

    /**
     * Test of getItem method, of class ExternalInventory.
     */
    @Test
    public void testGetItem() {
        for (int i = 1; i <= 50; i++) { //Tested between 1 and 50, as those are the valid ID's made.
            int quantity = i + 10292824;
            ExternalInventory instance = new ExternalInventory();
            try {
                ItemDTO result = instance.getItem(i, quantity);
            }
            catch (ItemNotFoundException INFExc) {
                assertFalse(true, "Valid ID threw INFExc.");
            }
        }
        ExternalInventory instance = new ExternalInventory();
        try {
            ItemDTO result = instance.getItem(0, 0);
        }
        catch (ItemNotFoundException INFExc) {
            assertTrue(true, "Invalid ID did not throw INFExc.");
        }        
    }
    
}
