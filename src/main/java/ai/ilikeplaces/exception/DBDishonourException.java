package ai.ilikeplaces.exception;

import ai.ilikeplaces.doc.License;

/**
 * Throw this exception if the DB is being dishonored by callers
 *
 * @author Ravindranath Akila
 */

@License(content = "This code is licensed under GNU AFFERO GENERAL PUBLIC LICENSE Version 3")
final public class DBDishonourException extends RuntimeException {

    final static private String MSG = "SORRY! I ENCOUNTERED AN OPERATION WHICH LOGICALLY DISHONORS THE STATE OF THE DB. THE SOURCES SHOULD REFLECT THIS WHERE THE EXCEPTION WAS THROWN. SEE BELOW FOR MORE DETAILS.\n";

    final static public DBDishonourException ADDING_AN_EXISTING_VALUE = new DBDishonourException("Adding an existing record to database.");
    final static public DBDishonourException REMOVING_A_NON_EXISTING_VALUE = new DBDishonourException("Removing a non existing record from database.");

    /**
     * @param message
     */
    public DBDishonourException(final String message) {
        super(MSG + message);
    }
}