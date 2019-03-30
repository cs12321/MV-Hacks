package org.jmusixmatch;

/**
 * A custom exception for the MusixMatch.
 *
 * @author Sachin Handiekar
 * @version 1.0
 */
@SuppressWarnings("serial")
public class MusixMatchException extends Exception {

    
    public MusixMatchException(String message) {
   
        super(message);
    }

    /**
     * Constructs a new exception with the specified message and wrapped
     * exception.
     *
     * @param message
     *            the reason for the exception
     * @param cause
     *            the internal exception that caused this exception
     */
    public MusixMatchException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public void getError()
    {
    	System.out.println(super.getMessage());
    }
}
