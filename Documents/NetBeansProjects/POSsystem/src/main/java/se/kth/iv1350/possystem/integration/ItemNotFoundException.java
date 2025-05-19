package se.kth.iv1350.possystem.integration;

import se.kth.iv1350.possystem.model.LogFactory;
import se.kth.iv1350.possystem.model.Logger;

/**
 * Thrown when searching for an item that is not in the database.
 * 
 * @param ID the problematic ID.
 */
public class ItemNotFoundException extends Exception {
    /**
     * Throws a checked exception that displays that the ID was invalid.
     * @param ID the invalid ID.
     */
    public ItemNotFoundException(int ID) {
        super("Item ID [" + ID + "] could not be found in database.");
        logError("Item ID [" + ID + "] could not be found in database.");
    }
    
    private void logError(String msg) {
        LogFactory logFactory = LogFactory.getLogFactory();
        Logger logger = logFactory.createLogger(true);
        logger.log(msg);
    }
}
