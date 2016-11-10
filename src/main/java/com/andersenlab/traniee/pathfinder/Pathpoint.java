package com.andersenlab.traniee.pathfinder;

import java.util.Arrays;
import java.util.LinkedList;

import org.apache.log4j.Logger;

/**
 * @author Overdark
 *
 */
class Pathpoint {

    public static final Logger log = Logger.getLogger(Pathpoint.class);
    // private static final int block = 999;

    private int amt;
  

   LinkedList<Integer> pathpoint [][];// = new LinkedList[amt][amt];

  
    @SuppressWarnings("unchecked")
    public Pathpoint(int amt) {
        this.amt = amt;
        this.pathpoint = new LinkedList[amt][amt];
        //this.pathpoint = new int[amt][amt];
        //this.LinkedList<Integer> pathpoint = new LinkedList[amt][amt];
      //  createNullPath();

    }

//    private int[][] createNullPath() {
//
//        for (int i = 0; i < amt; ++i) {
//
//            for (int j = 0; j < amt; ++j) {
//                pathpoint[i][j] = -1;
//            }
//        }
//        return pathpoint;
//    };
    
    public String toString() {

        String str = "Path:\n";

        for (int i = 0; i < amt; ++i) {
            str += (Arrays.toString(pathpoint[i]) + "\n");
        }

        str += "End\n";
        return str;

    }

}
