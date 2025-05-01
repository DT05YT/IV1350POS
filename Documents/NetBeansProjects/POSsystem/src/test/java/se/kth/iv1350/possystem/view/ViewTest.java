package se.kth.iv1350.possystem.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.possystem.controller.Controller;

/**
 *
 * @author Digit
 */
public class ViewTest {
    private View instance;
    
    @BeforeEach
    public void setUp() {
        //instance = new View()
        //Controller ctrl = new Controller(null, null, null);
    }
    
    @AfterEach
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of simulatedShoppingExperience method, of class View.
     */
    @Test
    public void testSimulatedShoppingExperience() {
        System.out.println("simulatedShoppingExperience");
        View instance = null;
        instance.simulatedShoppingExperience();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
