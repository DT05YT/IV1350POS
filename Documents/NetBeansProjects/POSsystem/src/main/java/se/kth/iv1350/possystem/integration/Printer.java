package se.kth.iv1350.possystem.integration;

import se.kth.iv1350.possystem.model.ReceiptDTO;
import se.kth.iv1350.possystem.model.SaleDTO;
import java.time.LocalDateTime;
/**
 *
 * @author Digit
 */
public class Printer {
    /*
    Prints a receipt in the output.
    
    @param receipt A receiptDTO object containing information about the sale.
    */
    public void printReceipt(ReceiptDTO receipt) {
        printReceiptHeader();
        printTime();
        ItemDTO[] itemList = receipt.getSaleInfo().getItemList();
        for (ItemDTO item : itemList) {
            if (item == null) break;
            printProductLine(item.getName(), item.getAmount(), item.getPrice());
        }
        System.out.println("");
        printTotals(receipt);
        printReceiptHeader();
    }
    
    private void printProductLine(String name, int quantity, double price) {
        double total = quantity * price;
        String format = "%-35s (%2d x $%5.2f)%12s$%6.2f%n";
        System.out.printf(format, name, quantity, price, "", total);
    }
    private void printTotals(ReceiptDTO receipt) {
        SaleDTO sale = receipt.getSaleInfo();
        String format = "%-60s $%6.2f%n";
        System.out.printf(format, "Subtotal:", sale.getTotalRaw());
        System.out.printf(format, "Total VAT:", sale.getTotalVat());
        if (sale.getDiscountSum() != 0) {
            double discount = sale.getDiscountSum() * -1;
            System.out.printf(format, "Discount:", discount);
        }
        System.out.printf(format, "Total:", sale.getTotalPrice());
        System.out.printf(format, "Amount Paid:", receipt.getAmountPaid());
        System.out.printf(format, "Change:", receipt.getChange());
    }
    private void printReceiptHeader() {
        String label = "[RECEIPT]";
        int totalWidth = 70;
        int labelLength = label.length();
        int dashCount = (totalWidth - labelLength) / 2;

        String dashes = "-".repeat(dashCount);
        System.out.println(dashes + label + dashes + (totalWidth % 2 == 1 ? "-" : ""));
    }
    private void printTime() {
        String time = LocalDateTime.now().toString();
        String[] timeParts = time.split("[T\\.]");
        System.out.println("Time: " + timeParts[0] + " " + timeParts[1]);
    }
}
