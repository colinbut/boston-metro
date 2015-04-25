/**
 * 
 */
package com.mycompany.bostonmetro.exception;

/**
 * @author colin
 *
 */
public class MetroMapParsingException extends BadFileException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * 
	 * @param errMessage
	 */
	public MetroMapParsingException(String errMessage) {
		super(errMessage);
		
	}

}
