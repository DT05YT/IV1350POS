package se.kth.iv1350.possystem.view;

import se.kth.iv1350.possystem.controller.Controller;
import se.kth.iv1350.possystem.integration.ItemDTO;
import se.kth.iv1350.possystem.model.SaleDTO;
import java.util.Random;
/**
 *
 * @author Digit
 */
public class View {
    private Controller controller;
    
    public View(Controller controller) {
        this.controller = controller;
    }
    /*
    Simulates a shopping experience with fake values.
    */
    public void simulatedShoppingExperience() {
        Random r = new Random();
        controller.startSale(2823);
        for (int i = 0; i < r.nextInt(20) + 1; i++) {
            //adding some random amount of random stuff
            int a = r.nextInt(50) + 1;
            int b = r.nextInt(10) + 1;
            ItemDTO item = controller.enterItemID(a, b);
            System.out.println("| " + item.getAmount() + "x of \"" + item.getName() + "\" (ID: " + item.getID() + ") was added to basket. ($" + (double) Math.round(100 *(item.getAmount() * (item.getPrice() * (item.getVAT() + 1))))/100 + ")");
            SaleDTO sale = controller.getSaleInfo();
            System.out.println("| Running total: $" + sale.getTotalPrice());
        }
        //end sale
        System.out.println("Asking for discount!");
        System.out.println("Discounted amount: $" + controller.askForDiscount());
        System.out.println("Ending sale...");
        double total = controller.endSale();
        System.out.println("Total price to pay: $" + total);
        double payment = (double) Math.round((total + r.nextDouble(20) + 5) / 10) * 10; //A simulated cash value.
        double change = controller.pay(payment);
    }
}
