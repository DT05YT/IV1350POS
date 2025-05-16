package se.kth.iv1350.possystem.controller;

import se.kth.iv1350.possystem.model.LogFactory;
import se.kth.iv1350.possystem.model.Logger;

/**
 * Thrown when trying to call on a function, that returned an exception.
 * 
 * @param msg A string message that explains the error.
 * @param source The original exception.
 */
public class CallFailedException extends Exception {
    public CallFailedException(String msg, Exception source) {
        super("Call failed: " + msg + " | " + source.getMessage());
        logError(msg + " | " + source.getMessage());
    }
    
    private void logError(String msg) {
        LogFactory logFactory = LogFactory.getLogFactory();
        Logger logger = logFactory.createLogger(true);
        logger.log(msg);
    }
}
