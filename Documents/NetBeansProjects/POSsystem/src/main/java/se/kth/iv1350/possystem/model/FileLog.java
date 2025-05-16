package se.kth.iv1350.possystem.model;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 *
 * @author Digit
 */
public class FileLog implements Logger{
    private final String path = "log.txt";
    private boolean append = true;
    private PrintWriter writer;
    
    public FileLog() {
        try {
            this.writer = new PrintWriter(new FileWriter(this.path, this.append));
        }
        catch (IOException IOExc) {
            String[] timeParts = getTimeParts();
            System.out.println(timeParts[0] + " " + timeParts[1] + " | Could not create filewriter. (" + IOExc.getMessage() + ")");
        }
    }
    
    @Override
    public void log(String msg) {
        String[] timeParts = getTimeParts();
        writer.println(timeParts[0] + " " + timeParts[1] + " | " + msg);
        writer.flush();
    }
    
    private String[] getTimeParts() {
        String time = LocalDateTime.now().toString();
        String[] timeParts = time.split("[T\\.]");
        return timeParts;
    }
}
