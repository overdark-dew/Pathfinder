package com.andersenlab.traniee.pathfinder;

//import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.log4j.Logger;

/**
 * @author Overdark
 * Принимает граф и две точки между которыми следует проложить маршрут
 */
class Path {
    
    /**
     * Логгер
     */
    public static final Logger log = Logger.getLogger(Path.class);
    

    /**
     * Собирает маршрут из точек
     */
    private LinkedList<Point> path;// = new LinkedList[amt][amt];

    /**
     * Общая длина пути
     */
    private int allPath;
   
    public int getAllPath() {
        int allPath = this.allPath;
        return allPath;
    }

    /**
     * @author Overdark
     * Отрезок маршрута, содержит две точки и расстояние между ними
     */
    private final class Point {
        private int start; // Начальная точка
        private int finish; // конечная точка
        private int lenght; // Расстояние

        /* (non-Javadoc)
         * @see java.lang.Object#toString()
         */
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
        int[][] graph = new int[g.getAmt()][g.getAmt()];

        for (int i = 0; i < g.getAmt(); ++i) {

            for (int j = 0; j < g.getAmt(); ++j) {

                graph[i][j] = g.getLenght(i, j);

            }
        }
        
        for (int i = 0; i < g.getAmt(); ++i) {

            for (int j = 0; j < g.getAmt(); ++j) {

                pathpoint[i][j] = -1;

            }
        }

        
        
        this.path = new LinkedList<Point>();

        for (int i = 0; i < g.getAmt(); ++i) {

            for (int j = 0; j < g.getAmt(); ++j) {
                //System.out.println();

                for (int k = 0; k < g.getAmt(); ++k) {

                    // if (g.getLenght(j, k) > g.getLenght(j, i) +
                    // g.getLenght(i, k)) {
                    if (graph[j][k] > graph[j][i] + graph[i][k]) {

                        graph[j][k] = graph[j][i] + graph[i][k];
                        pathpoint[j][k] = i;
                        
                    } 
                    //System.out.print(pathpoint[j][k] + " ");
                }
                
            }
        }

        // Point point = new Point(s, f, g.getLenght(s, f)

        this.allPath = graph[s][f];
        
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

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String str = "You path: \n";
        
        
        Iterator<Point> iter = path.iterator();
        while (iter.hasNext()) {
            str = str + iter.next().toString();
        }
        str = str + "All Path lenght - " + allPath;
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
