package se.kth.iv1350.possystem.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.possystem.integration.ItemDTO;

/**
 *
 * @author Digit
 */
public class SaleTest {
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of updateSale method, of class Sale.
     */
    @Test
    public void testUpdateSale() {
        System.out.println("updateSale");
        ItemDTO item = new ItemDTO(12345, "Test name", 0.123456789, 9.87654321, 14, "Test description. I am a long string to see if this gets cut off in any way or just to see how it is handled!");
        Sale instance = new Sale(0);
        instance.updateSale(item);
        assertTrue(instance.getSaleDTO().getItemList()[0].getName().equals("Test name"), "The item was inserted into the sale.");
    }

    /**
     * Test of applyDiscounts method, of class Sale.
     */
    @Test
    public void testApplyDiscounts() {
        System.out.println("applyDiscounts");
        boolean pass = true;
        for (double i = 0; i < 100; i += 0.01) {
            Sale instance = new Sale(0);
            instance.applyDiscounts(i);
            if(instance.getSaleDTO().getDiscountSum() != i) {
                pass = false;
            }
        }
        assertTrue(pass, "Checked for a lot of values if the discount value was applied.");
        
    }

    /**
     * Test of getSaleDTO method, of class Sale.
     */
    @Test
    public void testGetSaleDTO() {
        System.out.println("getSaleDTO");
        Sale instance = new Sale(0);
        ItemDTO item = new ItemDTO(12345, "Test name", 0.123456789, 9.87654321, 14, "Test description. I am a long string to see if this gets cut off in any way or just to see how it is handled!");
        instance.updateSale(item);
        assertTrue(instance.getSaleDTO().getItemList()[0].getName().equals("Test name"), "The item was inserted into the sale.");
    }

    /**
     * Test of generateReceipt method, of class Sale.
     */
    @Test
    public void testGenerateReceipt() {
        System.out.println("generateReceipt");
        Sale instance = new Sale(0);
        ItemDTO item = new ItemDTO(12345, "Test name", 0.123456789, 9.87654321, 14, "Test description. I am a long string to see if this gets cut off in any way or just to see how it is handled!");
        instance.updateSale(item);
        
        ReceiptDTO expResult = new ReceiptDTO(0, 0 - instance.getSaleDTO().getTotalPrice(), instance.getSaleDTO());
        ReceiptDTO result = instance.generateReceipt(0);
        
        System.out.println(result.getAmountPaid() + " : " + result.getChange() + " . " + result.getSaleInfo().getTotalPrice());
        System.out.println(expResult.getAmountPaid() + " : " + expResult.getChange());
        assertEquals(expResult.getChange(), result.getChange(), "The simulated receiptDTO calculated change to be the same as the real receiptDTO.");
    }

    /**
     * Test of finalizeSale method, of class Sale.
     */
    @Test
    public void testFinalizeSale() {
        System.out.println("finalizeSale");
        Sale instance = new Sale(0);
        ItemDTO item = new ItemDTO(12345, "Test name", 0.123456789, 9.87654321, 14, "Test description. I am a long string to see if this gets cut off in any way or just to see how it is handled!");
        instance.updateSale(item);
        SaleDTO result = instance.finalizeSale();
        double simulation = instance.getSaleDTO().getTotalPrice();
        assertEquals(result.getTotalPrice(), simulation);
    }
    
}
