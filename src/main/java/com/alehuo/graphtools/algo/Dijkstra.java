/*
 * Copyright (C) 2017 alehuo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.alehuo.graphtools.algo;

import com.alehuo.graphtools.graph.Edge;
import com.alehuo.graphtools.graph.Node;
import com.alehuo.graphtools.exception.EdgeWeightException;
import com.alehuo.graphtools.graph.Edge;
import com.alehuo.graphtools.graph.Graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * A Java implementation of Dijkstra's algoritm using priority queue to find the
 * shortest distance between nodes.
 *
 * @author alehuo
 */
public class Dijkstra {

    /**
     * Graph.
     */
    private final Graph g;

    /**
     * Dijkstra's algorithm.
     *
     * @param g Graph
     */
    public Dijkstra(Graph g) {
        this.g = g;
    }

    /**
     * Calculates every shortest distance from every node to every node.
     *
     * Note: With extremely large graphs, make sure that your stack size is set
     * large enough.
     *
     * @return Two-dimensional matrice of every shortest distance.
     * @throws EdgeWeightException Dijkstra's algorithm doesn't allow negative
     * weights, so throws an exception if one is found.
     */
    public long[][] allShortestDistances() throws EdgeWeightException {
        long[][] dist = new long[g.getN() + 1][g.getN() + 1];
        for (long[] ls : dist) {
            Arrays.fill(ls, Long.MAX_VALUE);
        }
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = shortestDistance(new Node(i), new Node(j));
                }
            }
        }

        return dist;
    }

    /**
     * Returns the shortest distance between two nodes.
     *
     * @param n1 Starting node
     * @param n2 Ending node
     * @return -1 if the node is unreachable from the starting node, otherwise
     * the shortest distance between nodes n1 and n2.
     * @throws EdgeWeightException Dijkstra's algorithm doesn't allow negative
     * weights, so throws an exception if one is found.
     */
    public long shortestDistance(Node n1, Node n2) throws EdgeWeightException {
        boolean[] visited = new boolean[g.getN() + 1];
        long[] dist = new long[g.getN() + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[n1.getKey()] = 0;

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();

        //Add the starting node to the queue
        priorityQueue.add(new Edge(n1, null, dist[n1.getKey()]));

        while (!priorityQueue.isEmpty()) {
            //Selects tne edge with the smallest weight to the starting node n1
            Edge n = priorityQueue.poll();
            if (n.getWeight() < 0) {
                throw new EdgeWeightException("Edge weight must not be negative.");
            }
            ArrayList<Edge> connections = g.getEdgesFrom(n.getStartingNode());
            for (Edge connection : connections) {
                if (connection.getWeight() < 0) {
                    throw new EdgeWeightException("Edge weight must not be negative.");
                }
                if (!visited[connection.getEndingNode().getKey()]) {
                    //Relax operation
                    if (n.getWeight() + connection.getWeight() < dist[connection.getEndingNode().getKey()]) {
                        dist[connection.getEndingNode().getKey()] = n.getWeight() + connection.getWeight();
                        Edge tmpNode = new Edge(connection.getEndingNode(), null, n.getWeight() + connection.getWeight());
                        priorityQueue.add(tmpNode);
                    }
                }
            }
            visited[n.getStartingNode().getKey()] = true;
        }
        return (dist[n2.getKey()] == Long.MAX_VALUE) ? -1 : dist[n2.getKey()];
    }

    /**
     * Returns the shortest distance between two nodes.
     *
     * @param n1 Starting node
     * @param n2 Ending node
     * @return -1 if the node is unreachable from the starting node, otherwise
     * the shortest distance between nodes n1 and n2.
     * @throws EdgeWeightException Dijkstra's algorithm doesn't allow negative
     * weights, so throws an exception if one is found.
     */
    public long shortestDistance(int n1, int n2) throws EdgeWeightException {
        return this.shortestDistance(new Node(n1), new Node(n2));
    }

}
