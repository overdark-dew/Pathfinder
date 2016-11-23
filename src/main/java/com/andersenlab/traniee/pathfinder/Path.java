package com.andersenlab.traniee.pathfinder;

//import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.log4j.Logger;

/**
 * @author Overdark
 *
 */
class Path {

    // class Graph;
    public static final Logger log = Logger.getLogger(Path.class);
    // private static final int block = 999;

    // private int amt;

    private LinkedList<Point> path;// = new LinkedList[amt][amt];

    class Point {
        private int start; // Начальная точка
        private int finish; // конечная точка
        private int lenght; // Расстояние

        @Override
        public String toString() {

            String str = new String();
            str = "From point (" + start + ") to point (" + finish + ") leght = " + lenght + "\n";
            return str;
        }

        public Point(int s, int f, int l) {
            start = s;
            finish = f;
            lenght = l;
        }
    }

    public Path(Graph g, int s, int f) {

        int[][] pathpoint = new int[g.getAmt()][g.getAmt()];

        this.path = new LinkedList<Point>();

        for (int i = 0; i < g.getAmt(); ++i) {

            for (int j = 0; j < g.getAmt(); ++j) {

                for (int k = 0; k < g.getAmt(); ++k) {

                    if (g.getLenght(j, k) > g.getLenght(j, i) + g.getLenght(i, k)) {

                        // this.graph[j][k] = this.graph[j][i] +
                        // this.graph[i][k];
                        pathpoint[j][k] = i;
                    } else {
                        pathpoint[j][k] = -1;
                    }
                }
            }
        }

        // Point point = new Point(s, f, g.getLenght(s, f)

        for (int end = f;;) {

            if (pathpoint[s][f] == -1) {
                Point point = new Point(s, f, g.getLenght(s, f));
                path.add(point);
                s = f;
                f = end;
            } else {
                f = pathpoint[s][f];
            }

            if (s == end) {
                break;
            }

        }
    }

    @Override
    public String toString() {
        String str = new String();

        Iterator<Point> iter = path.iterator();
        while (iter.hasNext()) {
            str = str + iter.next().toString();
        }
        return str;

    }

    // public class Builder {
    // }

    // private int[][] createNullPath() {
    //
    // for (int i = 0; i < amt; ++i) {
    //
    // for (int j = 0; j < amt; ++j) {
    // pathpoint[i][j] = -1;
    // }
    // }
    // return pathpoint;
    // };

    // public String toString() {
    //
    // String str = "Path:\n";
    //
    // for (int i = 0; i < amt; ++i) {
    // str += (Arrays.toString() + "\n");
    // }
    //
    // str += "End\n";
    // return str;
    //
    // }

}
