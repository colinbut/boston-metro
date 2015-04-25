package com.mycompany.bostonmetro;

import java.io.IOException;

import com.mycompany.bostonmetro.model.Station;
import com.mycompany.bostonmetro.util.MetroMapParser;


/**
 * The Boston Metro application
 * 
 * @author Colin
 *
 */
public class BostonMetro {

	public static void getQuickestRoute(String[] args) throws Exception{
		
		if(args.length == 0){
			System.err.println("No program arguments supplied");
			printUsage();
			return;
		}
		
		if(args.length != 3){
			System.err.println("Incorrect number of program arguments supplied");
			printUsage();
			return;
		}
		
		String filename = args[0];
		String startStation = args[1];
		String endStation = args[2];
		
		MetroMapParser mmp = new MetroMapParser(filename);
    	mmp.buildMetroMap();
		
    	Station s1 = (Station)mmp.getMetroMap().getNode(startStation);
	 	Station s2 = (Station)mmp.getMetroMap().getNode(endStation);
 	    
	 	if(s1 == null){
	 		System.out.println("Station: " + "1" +
	 				 " doesnt exist");
	 		return;
	 	}
	 	else if(s2 == null){
	 		System.out.println("Station: " + "3" + 
	 				" doesnt exist");
	 		return;
	 	}
	 	
 	    RouteFinder routeFinder = new RouteFinder(mmp.getMetroMap());
 	     			 		
 		System.out.println(routeFinder.getShortestRoute(s1, s2));
		
	}
	
	/*
	 * Prints usage description
	 * 
	 * Every Command Line program should have one - best practice
	 */
	private static void printUsage(){
		System.out.println("Usage:\n");
		System.out.println("java -jar boston-metro.jar [filename] [station-start] [station-end]");
		System.out.println("\n");
		System.out.println("where:\n");
		System.out.println("filename - name of file containing formatted data of stations");
		System.out.println("station-start - the station you wish to travel from");
		System.out.println("station-end - the station you wish to travel to");
	}
	
	
	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		try{
	    	
			MetroMapParser mmp = new MetroMapParser("bostonmetro.txt");
        	mmp.buildMetroMap();
                    
	        Station s1 = (Station)mmp.getMetroMap().getNode("1");
			 	Station s2 = (Station)mmp.getMetroMap().getNode("3");
		 	    
			 	if(s1 == null){
			 		System.out.println("Station: " + "1" +
			 				 " doesnt exist");
			 		System.exit(0);
			 	}
			 	else if(s2 == null){
			 		System.out.println("Station: " + "3" + 
			 				" doesnt exist");
			 		System.exit(0);
			 	}
			 	
		 	    RouteFinder routeFinder = new RouteFinder(mmp.getMetroMap());
		 		
		 	    String shortestPath = "";
		 		shortestPath = routeFinder.getShortestRoute(s1, s2);
		 		 			 		
		 		System.out.println(shortestPath);
	 		
	 		//**********************************//
	 		/*
	 		if(args.length != 3)
			{
			    mmp.usage();
			    System.exit(0);
			}
	 		else{
	 			String startStation = args[1];
	 			String targetStation = args[2];
	 			 			
	 			station s1 = (station)mmp.getGraph().getNameNode(startStation);
			 	station s2 = (station)mmp.getGraph().getNameNode(targetStation);
		 	    
			 	if(s1 == null){
			 		System.out.println("Station: " + startStation +
			 				 " doesnt exist");
			 		System.exit(0);
			 	}
			 	else if(s2 == null){
			 		System.out.println("Station: " + targetStation + 
			 				" doesnt exist");
			 		System.exit(0);
			 	}
			 	
		 	    Findroute routeFinder = new Findroute(mmp.getGraph());
		 		
		 	    String shortestPath = "";
		 		shortestPath = routeFinder.getShortestRoute(s1, s2);
		 		 			 		
		 		System.out.println(shortestPath);
	 		}*/
	 	}
    	catch(Exception ev){
    	    System.out.println(ev.getMessage());
    	}
	}

}
