package com.andersenlab.traniee.pathfinder;

import com.andersenlab.traniee.pathfinder.Graph;

public class Main {

	public static void main(String[] args) {
		 //TODO Auto-generated method stub
		Graph random = new Graph(20);
//		Graph manual = new Graph(4);
		
		Graph.buildRandomGraph(random);
		Graph.printGraph(random);
		Graph.findShortWay(random);
		Graph.printGraph(random);
		Graph.printGraphPp(random);
		
//		Graph.buildUsersGraph(manual.graph);
//		Graph.printGraph(manual.graph);
//		Graph.findShortWay(manual.graph);
//		Graph.printGraph(manual.graph);
	}

}
