package com.andersenlab.traniee.pathfinder;

import java.util.Arrays;
import java.util.Random;
//import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * @author Overdark Класс реализующий граф
 */
public class Graph {
    /**
     * Логгер
     */
    public static final Logger log = Logger.getLogger(Graph.class);
    /**
     * Переменная расстояния, обозначающая отсутствие прямого пути между точками
     */
    private static final int block = 999;
    /**
     * Количество вершин в графе
     */
    private final int amt;
    /**
     * Массив расстояний между точками в графе
     */
    private final int[][] graph;

    /**
     * @author Overdark Класс для создания объекта класса Graph
     */
    public static class Builder {
        /**
         * Количество вершин в графе
         */
        private int amt;
        /**
         * Массив расстояний между точками в графе
         */
        private int[][] graph;

        /**
         * @param amt
         *            Количество вершин нового графа
         */
        public Builder(int amt) {
            this.amt = amt;
            this.graph = new int[amt][amt];

            for (int i = 0; i < amt; ++i) {

                for (int j = 0; j < amt; ++j) {

                    if (i == j)
                        continue;

                    this.graph[i][j] = block;
                }
            }

        }

        /**
         * Метод позволяет задать расстояние между точками i j
         * 
         * @param i
         *            индекс точки
         * @param j
         *            индекс точки
         * @param s
         *            расстояние между точками i j
         * @return
         */
        public Builder edge(int i, int j, int s) {
            this.graph[i][j] = s;
            return this;
        }

        /**
         * Заполняет граф случайными расстояниями
         * 
         * @return this
         */
        public Builder random() {

            Random r = new Random();

            for (int i = 0; i < amt; ++i) {

                for (int j = 0; j < amt; ++j) {

                    if (j == i || r.nextInt(2) == 0)
                        continue;
                    this.graph[i][j] = r.nextInt(50) + 1;
                }
            }
            return this;
        }

        /**
         * @param Экземпляр
         *            класса Graph, требующий оптимизации
         * @return this для создания оптимизированного экземпляра класса Graph
         */
        public Builder shortWayGraph(Graph g) {

            for (int i = 0; i < g.amt; ++i) {

                for (int j = 0; j < g.amt; ++j) {

                    this.graph[i][j] = g.graph[i][j];
                }
            }
            for (int i = 0; i < g.amt; ++i) {

                for (int j = 0; j < g.amt; ++j) {

                    for (int k = 0; k < g.amt; ++k) {

                        if (this.graph[j][k] > this.graph[j][i] + this.graph[i][k]) {

                            this.graph[j][k] = this.graph[j][i] + this.graph[i][k];
                        }
                    }
                }
            }

            return this;
        }

        /**
         * @return Экземпляр класса Graph
         */
        public Graph build() {
            return new Graph(this);
        }

    }

    /**
     * @param Builder
     */
    public Graph(Builder builder) {
        amt = builder.amt;
        graph = builder.graph;
    }

    /**
     * Вывести на экран таблицу расстояний графа g
     * 
     * @param g
     */
    public static void printGraph(Graph g) {

        log.info("Start print graph:");
        for (int i = 0; i < g.amt; ++i) {
            log.info(Arrays.toString(g.graph[i]));
        }
    }

    /**
     * 
     * @return 2х мерный Массив расстояний graph
     */
    public int[][] getGraph() {
        return graph;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        int result = 11;

        for (int i = 0; i < amt; ++i) {

            for (int j = 0; j < amt; ++j) {

                result = 31 * result + graph[i][j];
            }
        }
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {

        if (!(o instanceof Graph))
            return false;

        if (amt != ((Graph) o).amt)
            return false;

        for (int i = 0; i < amt; ++i) {

            for (int j = 0; j < amt; ++j) {

                if (graph[i][j] != ((Graph) o).graph[i][j])
                    return false;

            }
        }

        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        String str = "Graph:\n";

        for (int i = 0; i < amt; ++i) {
            str += (Arrays.toString(graph[i]) + "\n");
        }

        str += "End\n";
        return str;

    }

}
// Graph g = new Graph.Builder();

// private Graph() {

// n = 10;
// setGraph(new int[n][n]);
// pathpoint = new int[n][n];
// createNullMarch();
// createNullgraph();
// }

// public Graph(int n) {
//
// this.n = n;
// setGraph(new int[n][n]);
// pathpoint = new int[n][n];
// createNullMarch();
// createNullgraph();
// }

// private int[][] createNullMarch() {
//
// for (int i = 0; i < amt; ++i) {
//
// for (int j = 0; j < amt; ++j) {
// pathpoint[i][j] = -1;
// }
// }
// return pathpoint;
// };

// public static Graph buildRandomGraph(Graph g) {
//
// Random r = new Random();
//
// for (int i = 0; i < g.amt; ++i) {
//
// for (int j = 0; j < g.amt; ++j) {
//
// if (j <= i) {
//
// continue;
// } else if (r.nextInt(2) > 0) {
// g.getGraph()[i][j] = r.nextInt(50) + 1;
// }
// g.getGraph()[j][i] = g.getGraph()[i][j];
// }
// }
// return g;
// };

// public static Graph buildUsersGraph(Graph g) {
//
// @SuppressWarnings("resource")
// Scanner sc = new Scanner(System.in);
//
// for (int i = 0; i < g.amt; ++i) {
//
// for (int j = 0; j < g.amt; ++j) {
//
// if (i == j) {
// continue;
//
// } else {
// log.info("Введите расстояние (" + i + ") - (" + j + "): ");
// if (sc.hasNextInt()) {
//
// g.getGraph()[i][j] = sc.nextInt();
//
// } else {
// log.info("какой-то текст");
// }
// }
// }
// }
// return g;
// };

// public static void printGraphPp(Graph g) {
//
// log.info("Start print pathpoint:");
// for (int i = 0; i < g.amt; ++i) {
// log.info(Arrays.toString(g.pathpoint[i]));
// }
// };

// public static Graph findShortWay(Graph g) {
//
// for (int i = 0; i < g.amt; ++i) {
//
// for (int j = 0; j < g.amt; ++j) {
//
// for (int k = 0; k < g.amt; ++k) {
//
// if (g.getGraph()[j][k] > g.getGraph()[j][i] + g.getGraph()[i][k]) {
//
// g.getGraph()[j][k] = g.getGraph()[j][i] + g.getGraph()[i][k];
// g.pathpoint[j][k] = i;
// }
// }
// }
// }
// return g;
// }

//
// public void setGraph(int[][] graph) {
// this.graph = graph;
// };
