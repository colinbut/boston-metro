package com.mycompany.bostonmetro.model;

/**
 * Detailed encapsulated data for a tube station.
 * Every station has an id (to uniquely identify it) and a name 
 * (so people can refer to it)
 * 
 * This is a POJO class
 * 
 * @author colin
 *
 */
public class StationInfo {
	
	private String ID;
	private String name;
	
	/**
	 * Constructor
	 */
	public StationInfo(String id, String n){
		ID = id;
		name = n;
	}
	
	/**
	 * Gets the id
	 * 
	 * @return id
	 */
	public String getID(){
		return ID;
	}
	
	/**
	 * Gets the name
	 * 
	 * @return name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Sets the id
	 * 
	 * @param id
	 */
	public void setID(String id){
	   	ID = id;
	}
	
	/**
	 * Sets the name
	 * 
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}

}
