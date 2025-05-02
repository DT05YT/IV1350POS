package se.kth.iv1350.possystem.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.possystem.integration.ItemDTO;
import se.kth.iv1350.possystem.model.SaleDTO;
import se.kth.iv1350.possystem.model.ReceiptDTO;
import se.kth.iv1350.possystem.integration.DiscountDatabase;
import se.kth.iv1350.possystem.integration.ExternalAccounting;
import se.kth.iv1350.possystem.integration.ExternalInventory;
import se.kth.iv1350.possystem.integration.Printer;
import se.kth.iv1350.possystem.model.Sale;
import se.kth.iv1350.possystem.model.Register;
import java.util.Random;

/**
 *
 * @author Digit
 */
public class ControllerTest {
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of startSale method, of class Controller.
     */
    @Test
    public void testStartSale() {
        System.out.println("startSale");
        int customerID = 192;
        DiscountDatabase disDat = new DiscountDatabase();
        ExternalAccounting extAcc = new ExternalAccounting();
        ExternalInventory extInv = new ExternalInventory();
        Printer printer = new Printer();
        Controller instance = new Controller(extAcc, extInv, disDat, printer);
        instance.startSale(customerID);
        assertTrue(instance.getSaleInfo().getCustomerID() == customerID, "Customer ID successfully passed.");
    }

    /**
     * Test of enterItemID method, of class Controller.
     */
    @Test
    public void testEnterItemID() {
        System.out.println("enterItemID");
        DiscountDatabase disDat = new DiscountDatabase();
        ExternalAccounting extAcc = new ExternalAccounting();
        ExternalInventory extInv = new ExternalInventory();
        Printer printer = new Printer();
        Controller instance = new Controller(extAcc, extInv, disDat, printer);
        instance.startSale(0);
        
        for (int i = 1; i < 1000; i++) {
            ItemDTO result = instance.enterItemID((i%50) + 1, i%73);
            assertFalse(result.getID() == -1, "Invalid ID returned.");
        }
    }

    /**
     * Test of getSaleInfo method, of class Controller.
     */
    @Test
    public void testGetSaleInfo() {
        System.out.println("getSaleInfo");
        DiscountDatabase disDat = new DiscountDatabase();
        ExternalAccounting extAcc = new ExternalAccounting();
        ExternalInventory extInv = new ExternalInventory();
        Printer printer = new Printer();
        Controller instance = new Controller(extAcc, extInv, disDat, printer);
        instance.startSale(0);
        
        instance.enterItemID(-1, 1828220);
        ItemDTO result = instance.getSaleInfo().getItemList()[0];
        ItemDTO expResult = new ItemDTO(-1, "ERR: ID INVALID", 0, 0, 0, "ERR: ID INVALID");
        if (result.getID() == expResult.getID() && 
                result.getAmount() == expResult.getAmount() &&
                result.getDesc().equals(expResult.getDesc()) &&
                result.getName().equals(expResult.getName()) &&
                result.getPrice() == expResult.getPrice()) {
            assertTrue(result.getVAT() == expResult.getVAT(), "Both objects match.");
        }
    }

    /**
     * Test of askForDiscount method, of class Controller.
     */
    @Test
    public void testAskForDiscount() {
        System.out.println("askForDiscount");
        DiscountDatabase disDat = new DiscountDatabase();
        ExternalAccounting extAcc = new ExternalAccounting();
        ExternalInventory extInv = new ExternalInventory();
        Printer printer = new Printer();
        Controller instance = new Controller(extAcc, extInv, disDat, printer);
        instance.startSale(0);
        
        double expResult = 2.5;
        double result = instance.askForDiscount();
        assertEquals(expResult, result, "Discount should be the hard coded value 2.5.");
    }

    /**
     * Test of pay method, of class Controller.
     */
    @Test
    public void testPay() {
        System.out.println("pay");
        DiscountDatabase disDat = new DiscountDatabase();
        ExternalAccounting extAcc = new ExternalAccounting();
        ExternalInventory extInv = new ExternalInventory();
        Printer printer = new Printer();
        Controller instance = new Controller(extAcc, extInv, disDat, printer);
        instance.startSale(0);
        Random r = new Random();
        for (int i = 0; i <= 1000; i++) {
            instance.enterItemID((i%50) + 1, i);
            double total = instance.getSaleInfo().getTotalPrice();
            double payment = r.nextDouble(10000) + (total / r.nextDouble(5));
            double result = instance.pay(payment);
            double expResult = (double) Math.round(100 * (payment - total)) / 100;
            assertFalse(result != expResult, "Calculated change is not same as simulated calculation.");
        }
    }

    /**
     * Test of endSale method, of class Controller.
     */
    @Test
    public void testEndSale() {
        System.out.println("endSale");
        DiscountDatabase disDat = new DiscountDatabase();
        ExternalAccounting extAcc = new ExternalAccounting();
        ExternalInventory extInv = new ExternalInventory();
        Printer printer = new Printer();
        Controller instance = new Controller(extAcc, extInv, disDat, printer);
        instance.startSale(0);
        
        double expResult = 0.0;
        double result = instance.endSale();
        assertEquals(expResult, result, "Should be 0");
    }
    
}
