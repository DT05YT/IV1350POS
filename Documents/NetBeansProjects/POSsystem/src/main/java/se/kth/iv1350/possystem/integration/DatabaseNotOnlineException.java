package se.kth.iv1350.possystem.integration;

import se.kth.iv1350.possystem.model.LogFactory;
import se.kth.iv1350.possystem.model.Logger;

/**
 * Thrown when trying to access a database that is offline.
 */
public class DatabaseNotOnlineException extends RuntimeException {
    /**
     * An unchecked exception, that displays that the database is offline.
     */
    public DatabaseNotOnlineException() {
        super("ERROR: Tried to access offline database.");
        logError("ERROR: Tried to access offline database.");
    }
    private void logError(String msg) {
        LogFactory logFactory = LogFactory.getLogFactory();
        Logger logger = logFactory.createLogger(true);
        logger.log(msg);
        logger = logFactory.createLogger(false);
        logger.log(msg);
    }
}
