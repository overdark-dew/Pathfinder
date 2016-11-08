package com.andersenlab.traniee.pathfinder;

import org.apache.log4j.Logger;

/**
 * @author Overdark
 *
 */
public class Pathpoint {

    public static final Logger log = Logger.getLogger(Pathpoint.class);
    // private static final int block = 999;

    private int amt;
    private int[][] pathpoint;

    public Pathpoint(int amt) {
        this.amt = amt;
        this.pathpoint = new int[amt][amt];
        createNullPath();

    }

    private int[][] createNullPath() {

        for (int i = 0; i < amt; ++i) {

            for (int j = 0; j < amt; ++j) {
                pathpoint[i][j] = -1;
            }
        }
        return pathpoint;
    };

}
