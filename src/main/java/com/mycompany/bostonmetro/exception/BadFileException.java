package com.mycompany.bostonmetro.exception;

/**
 * @author colin
 *
 */
public class BadFileException extends Exception {
	
	private static final long serialVersionUID = -688780272978957724L;
	
	private String message;
	
	/**
	 * Constructor
	 * 
	 * @param errMessage
	 */
	public BadFileException(String errMessage){
		/*
		message = "Bad File Exception: " + 
		           "There is a problem with the format of the file" + 
		           "Unrecognised Format!!!!";*/
		message = errMessage;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage(){
		return message;
	}

}
