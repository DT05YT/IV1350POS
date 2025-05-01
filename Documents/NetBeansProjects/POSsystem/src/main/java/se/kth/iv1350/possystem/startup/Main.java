package se.kth.iv1350.possystem.startup;
import se.kth.iv1350.possystem.controller.Controller;
import se.kth.iv1350.possystem.view.View;
import se.kth.iv1350.possystem.integration.Printer;
import se.kth.iv1350.possystem.integration.DiscountDatabase;
import se.kth.iv1350.possystem.integration.ExternalAccounting;
import se.kth.iv1350.possystem.integration.ExternalInventory;
/**
 *
 * @author Digit
 */
public class Main {
    public static void main(String[] args) {
        DiscountDatabase disDat = new DiscountDatabase();
        ExternalAccounting extAcc = new ExternalAccounting();
        ExternalInventory extInv = new ExternalInventory();
        Printer printer = new Printer();
        Controller controller = new Controller(extAcc, extInv, disDat, printer);
        View view = new View(controller);
        view.simulatedShoppingExperience();
    }
}
