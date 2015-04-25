/**
 * 
 */
package com.mycompany.bostonmetro;

import com.mycompany.bostonmetro.model.Station;
import com.mycompany.multigraph.MultiGraph;
import com.mycompany.multigraph.Node;

/**
 * A map of the metro which is internally built from a type of Graph data structure.
 * 'MultiGraph'
 * 
 * This is to be used within the Boston Metro Map application
 * 
 * @author colin
 *
 */
public class MetroMap extends MultiGraph{
	
	/*
	 * (non-Javadoc)
	 * @see com.mycompany.multigraph.MultiGraph#getNode(java.lang.Object)
	 */
	@Override
	public Node getNode(Object id){
		for(Node n : getNodes()){
			Station station = (Station)n;
			if(station.getStationID().equals(id)){
				return station;
			}
		}
		return null;
	}
	
	/**
	 * Gets the station object from the graph based on the 
	 * given object's internal data
	 * 
	 * @param s
	 * @return
	 */
	public Station getStation(Object s){
		return (Station)getNode(s);
	}

}
