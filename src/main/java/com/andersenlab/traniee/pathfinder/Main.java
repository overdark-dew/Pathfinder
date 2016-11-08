package com.andersenlab.traniee.pathfinder;

//import org.apache.log4j.Logger;

import com.andersenlab.traniee.pathfinder.Graph;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Graph random = new Graph.Builder(20).random().edge(1, 2, 5).build();
        Graph optimal = new Graph.Builder(20).shortWayGraph(random).build();

        Graph eq1 = new Graph.Builder(20).edge(1, 2, 20).build();
        Graph eq2 = new Graph.Builder(20).edge(1, 2, 20).build();

        Graph.log.info(random);
        Graph.log.info(optimal);

        Graph.log.info(random.hashCode());
        Graph.log.info(optimal.hashCode());

        Graph.log.info(eq1.equals(eq1));
        Graph.log.info(eq1.equals(eq2));
        Graph.log.info(eq1.equals(optimal));

        // Graph.log.info(optimal);
        // Graph.log.info(optimal);
    }

}
