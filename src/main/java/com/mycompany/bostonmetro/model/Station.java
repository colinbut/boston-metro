package com.mycompany.bostonmetro.model;

import com.mycompany.multigraph.MultiGraphNode;;

/**
 * A "node" class representing a tube station which 
 * encapsulates specific station model data.
 * 
 * This class is to be used by the internal 'Multigraph'
 * 
 * @author colin
 *
 */
public class Station extends MultiGraphNode{

	private StationInfo stationInfo;
	
	/**
	 * Constructor
	 * 
	 * @param element
	 */
	public Station(StationInfo element) {
		super(element);
		stationInfo = element;
	}
	
	/**
	 * Constructor
	 */
	public Station(){
		super(null);
	}
	
	/**
	 * Returns the id of the station
	 * 
	 * @return station id
	 */
	public String getStationID(){
		return stationInfo.getID();
	}
	
	/**
	 * Returns the name of the station
	 * 
	 * @return station name
	 */
	public String getStationName(){
		return stationInfo.getName();
	}
	
	
}
