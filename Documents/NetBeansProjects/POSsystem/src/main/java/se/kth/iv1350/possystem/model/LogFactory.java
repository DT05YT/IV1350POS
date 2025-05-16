package se.kth.iv1350.possystem.model;

import se.kth.iv1350.possystem.model.Logger;

/**
 *
 * @author Digit
 */
public class LogFactory {
    private static final LogFactory factory = new LogFactory();
    private static final FileLog fileLog = new FileLog();
    private static final ConsoleLog consoleLog = new ConsoleLog();
    
    private LogFactory() {
        
    }
    /**
     * Gives out the created LogFactory so that no more than one is created.
     * @return 
     */
    public static LogFactory getLogFactory() {
        return factory;
    }
    /**
     * Creates a logger.
     * 
     * @param file Wether the logger should output to a file or the system output.
     * @return Logger returns the created logger.
     */
    public Logger createLogger(boolean file) {
        if (file == true) {
            return fileLog;
        }
        else {
            return consoleLog;
        }
    }
}
