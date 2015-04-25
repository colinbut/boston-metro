package com.mycompany.bostonmetro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mycompany.bostonmetro.model.Station;
import com.mycompany.bostonmetro.model.StationInfo;
import com.mycompany.multigraph.ArrayStack;
import com.mycompany.multigraph.Edge;
import com.mycompany.multigraph.MultiGraph;
import com.mycompany.multigraph.Node;
import com.mycompany.multigraph.Stack;

/**
 * Finds the route between two Stations.
 * 
 * It will aim to retrieve the shortest route to travel
 * from source to destination
 * 
 * @author colin
 *
 */
public class RouteFinder {
	
	private MultiGraph graph;
	private List<Node> level = null;
	private List<List<Node>> levelsList = null; 
	private Set<Node> visited = null;
	private Stack paths = null;
		
	/**
	 * Constructor
	 * 
	 * @param g the multigraph
	 */
	public RouteFinder(MultiGraph g){
		this.graph = g;//reference the graph..
		level = new ArrayList<Node>();
		levelsList = new ArrayList<List<Node>>();
		visited = new HashSet<Node>();
		paths = new ArrayStack(500);
	}
	
	/**
	 * Gets the shortest route between start and target
	 * 
	 * @param start, target
	 * @return resultList
	 */
	public String getShortestRoute(Node start, Node target){
		List<Node> startingLevel = new ArrayList<Node>();
		startingLevel.add(start);
		levelsList.add(startingLevel);
		visited.add(start);
		boolean found = search(target); 
		
		String temp = "";
		if(found == true){
			//traverse back in your levels list
			//call backTrack()
			temp = generatePath(backTrack(target));
		}
		return temp;
	}
	
	/*
	 * Uses a BFS (Breadth First Search) algorithm to do the searching.
	 * 
	 * This method does all the actual searching & halts when it reaches it target!
	 * 
	 * @param target The target station to reach for
	 * @return true if path is found, false otherwise
	 */
    private boolean search(Node target){
		List<Node> lastLevel = levelsList.get(levelsList.size() - 1);
		List<Node> newLevel = new ArrayList<Node>();
		 	
		for(Node node : lastLevel){
			if(node.equals(target)){
				return true;
			}
			else{
			   for(Node successor : graph.getSuccessors(node)){ 
				   if(successor.equals(target)){
					   newLevel.add(successor);
					   return true;
				   }
				   else if(!visited.contains(successor)){// 
					   visited.add(successor);
					   newLevel.add(successor);
				   }
			   }
			}
		}
 		//If newLevel has nodes in it we add it to the List of Levels
		if(!newLevel.isEmpty()){
			levelsList.add(newLevel);
			search(target); //Recursively search again
		}
		return false;
	}

    /*
     * Backtracks
     * 
     * @param targetNode
     * @return h
     */
	private Stack backTrack(Node targetNode){
		
		//A stack to hold the shortest path
		Stack stack = new ArrayStack(500);
		
		stack.sPush(targetNode);
		
		for(int i = levelsList.size() - 1; i >= 0; i--){
			level = levelsList.get(i);
			Node last = (Node)stack.sPeek();
			
			for(Node n : level){ //For each nodes in that level
				if(graph.isConnected(last, n)){ //Check if 2 nodes are connected
					stack.sPush(n);
					Edge e = graph.haveEdge(last, n);
					paths.sPush(e.getLabel());
					break; //EXIT the loop early
				}
			}
		}
			
		return stack;//Returns the shortest path
		
	}
	
	/**
	 * Once the shortest route have been found generate a string representation
	 * of it so the calling client can use it for displaying purposes
	 * 
	 * @param s the Stack containing the order of the stations
	 * @return string representation of shortest route
	 */
	protected String generatePath(Stack s){
		Stack path = s;
		String directions = "";
		String label = "";
		
		while(!path.sEmpty()){//while stack is not empty
			//get the node
			Node n = (Node)path.sPop();
			Station station = (Station)n;
			StationInfo content = (StationInfo)station.getElement();
			if(paths.sEmpty()){
				label = "";
			}
			else{
				label = (String)paths.sPop();
			}
			directions = directions + content.getName() + " " +
			            label + "\n";
			
		}
		return directions;
	}

}
