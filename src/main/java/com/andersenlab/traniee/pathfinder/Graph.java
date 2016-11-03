package com.andersenlab.traniee.pathfinder;

import java.util.Arrays;
//import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Graph {

	public static final Logger log = Logger.getLogger(Graph.class);
	private static final int block = 999;
	private int n;

	private int[][] graph;

	private int[][] pathpoint;

	public Graph() {

		n = 10;
		setGraph(new int[n][n]);
		pathpoint = new int[n][n];
		createNullMarch();
		createNullgraph();

	}

	public Graph(int n) {

		this.n = n;
		setGraph(new int[n][n]);
		pathpoint = new int[n][n];
		createNullMarch();
		createNullgraph();
	}

	private int[][] createNullMarch() {

		for (int i = 0; i < n; ++i) {

			for (int j = 0; j < n; ++j) {
				pathpoint[i][j] = -1;
			}

		}
		return pathpoint;
	};

	private int[][] createNullgraph() {

		for (int i = 0; i < n; ++i) {

			for (int j = 0; j < n; ++j) {

				if (i == j)
					continue;

				getGraph()[i][j] = block;
			}

		}
		return getGraph();
	};

	public static Graph buildRandomGraph(Graph g) {

		Random r = new Random();

		for (int i = 0; i < g.n; ++i) {

			for (int j = 0; j < g.n; ++j) {

				if (j <= i) {

					continue;
				} else if (r.nextInt(2) > 0) {
					g.getGraph()[i][j] = r.nextInt(50) + 1;
				}
				g.getGraph()[j][i] = g.getGraph()[i][j];

			}
		}
		return g;
	};

	public static Graph buildUsersGraph(Graph g) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < g.n; ++i) {
			
			for (int j = 0; j < g.n; ++j) {

				if (i == j) {
					continue;
				
				} else {
					log.info("Введите расстояние (" + i + ") - (" + j + "): ");
					if (sc.hasNextInt()) {

						g.getGraph()[i][j] = sc.nextInt();

					} else {
						log.info("какой-то текст");
					}

				}
			}
		}

		return g;

	};

	public static void printGraph(Graph g) {

		log.info("Start print graph:");
		for (int i = 0; i < g.n; ++i) {
			log.info(Arrays.toString(g.getGraph()[i]));

		}

	};

	public static void printGraphPp(Graph g) {

		log.info("Start print pathpoint:");
		for (int i = 0; i < g.n; ++i) {
			log.info(Arrays.toString(g.pathpoint[i]));

		}

	};

	public static Graph findShortWay(Graph g) {

		for (int i = 0; i < g.n; ++i) {

			for (int j = 0; j < g.n; ++j) {

				for (int k = 0; k < g.n; ++k) {

					if (g.getGraph()[j][k] > g.getGraph()[j][i] + g.getGraph()[i][k]) {

						g.getGraph()[j][k] = g.getGraph()[j][i] + g.getGraph()[i][k];
						g.pathpoint[j][k] = i;
					}

				}
			}
		}
		return g;
	}

	public int[][] getGraph() {
		return graph;
	}

	public void setGraph(int[][] graph) {
		this.graph = graph;
	};

}