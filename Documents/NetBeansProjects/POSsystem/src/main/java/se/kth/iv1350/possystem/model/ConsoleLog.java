package se.kth.iv1350.possystem.model;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 *
 * @author Digit
 */
public class ConsoleLog implements Logger{
    
    @Override
    public void log(String msg) {
        System.out.println(msg);
    }
}
