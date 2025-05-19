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
    /**
     * Propagates the exception up to the view, saying that the call failed and why.
     * @param msg The message to give to the view.
     * @param source The source of the exception.
     */
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
