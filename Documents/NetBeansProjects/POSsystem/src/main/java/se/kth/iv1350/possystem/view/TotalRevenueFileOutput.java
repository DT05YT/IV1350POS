package se.kth.iv1350.possystem.view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import se.kth.iv1350.possystem.model.RevenueObserver;

/**
 *
 * @author Digit
 */
public class TotalRevenueFileOutput implements RevenueObserver{
    @Override
    public void updateObserversWithRevenue(double revenue) { 
        String path = "revenue.txt";
        boolean append = true;
        PrintWriter writer;
        
        try {
            writer = new PrintWriter(new FileWriter(path, append));
            String[] timeParts = getTimeParts();
            writer.println(timeParts[0] + " " + timeParts[1] + " | Total revenue gained from sale: $" + revenue);
            writer.close();
        }
        catch (IOException IOExc) {
            System.out.println("Could not create filewriter. (" + IOExc.getMessage() + ")");
        }
    }
    
    private String[] getTimeParts() {
        String time = LocalDateTime.now().toString();
        String[] timeParts = time.split("[T\\.]");
        return timeParts;
    }
}
