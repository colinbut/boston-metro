package com.mycompany.bostonmetro;

import com.mycompany.bostonmetro.model.Station;
import com.mycompany.bostonmetro.model.StationInfo;
import com.mycompany.multigraph.MultiGraph;

import junit.framework.*;

/**
 * 
 */

/**
 * @author cbut
 *
 */
public class GraphTest extends TestCase {

	private MultiGraph g;
	private Station Glasgow;
	private Station edinburgh;
	private Station stirling;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		g = new MultiGraph();
		Glasgow = new Station(new StationInfo("1", "Glasgow"));
		edinburgh = new Station(new StationInfo("2", "Edinburgh"));
		stirling = new Station(new StationInfo("3", "Stirling"));
		g.addNode(Glasgow);
		g.addNode(edinburgh);
		g.addNode(stirling);
		String label = "Glasgow to Edinburgh";
		String label2 = "Stirling to Edinburgh";
		g.addEdge(Glasgow, edinburgh, label);
		g.addEdge(edinburgh, stirling, label2);
	}
	
	public void testIsConnected(){
		boolean expected = true;
		//This test below is intended to pass
		Assert.assertEquals(expected, g.isConnected(Glasgow, edinburgh));	
		//This test below is intended to fail as no edge has been created between
		//Glasgow and Stirling
		Assert.assertEquals(expected, g.isConnected(Glasgow, stirling));	
	}
	
	

}
