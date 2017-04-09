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
package com.alehuo.shortestpath.algo;

import com.alehuo.shortestpath.Graph;
import com.alehuo.shortestpath.Node;
import com.alehuo.shortestpath.exception.NegativeWeightException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * An implementation of Dijkstra's algoritm using Java's priority queue to find
 * the shortest distance between nodes.
 *
 * @author alehuo
 */
public class Dijkstra {

    /**
     * Graph
     */
    private final Graph g;

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
     * @throws NegativeWeightException Dijkstra's algorithm doesn't allow
     * negative weights, so throws an exception if one is found.
     */
    public long[][] allShortestDistances() throws NegativeWeightException {
        long[][] distMatrice = new long[g.getN() + 1][g.getN() + 1];
        for (long[] ls : distMatrice) {
            Arrays.fill(ls, Long.MAX_VALUE);
        }
        for (int i = 0; i < distMatrice.length; i++) {
            for (int j = 0; j < distMatrice.length; j++) {
                if (i == j) {
                    distMatrice[i][j] = 0;
                } else {
                    distMatrice[i][j] = shortestDistance(i, j);
                }
            }
        }

        return distMatrice;
    }

    /**
     * Returns the shortest distance between two nodes.
     *
     * Time complexity: O((|V|+|E|)log|V|)
     *
     * @param n1 Starting node
     * @param n2 Ending node
     * @return -1 if the node is unreachable from the starting node, otherwise
     * the shortest distance between nodes n1 and n2.
     * @throws NegativeWeightException Dijkstra's algorithm doesn't allow
     * negative weights, so throws an exception if one is found.
     */
    public long shortestDistance(int n1, int n2) throws NegativeWeightException {
        boolean[] visited = new boolean[g.getN() + 1];
        long[] dist = new long[g.getN() + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[n1] = 0;

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(n1, dist[n1]));

        while (!priorityQueue.isEmpty()) {
            Node n = priorityQueue.poll();
            if (n.getW() < 0) {
                throw new NegativeWeightException();
            }
            ArrayList<Node> connections = g.getConnections(n.k);
            for (Node connection : connections) {
                if (connection.getW() < 0) {
                    throw new NegativeWeightException();
                }
                if (!visited[connection.k]) {
                    if (n.getW() + connection.getW() < dist[connection.k]) {
                        dist[connection.k] = n.getW() + connection.getW();
                        Node tmpNode = new Node(connection.k, n.getW() + connection.getW());
                        priorityQueue.add(tmpNode);
                    }
                }
            }
            visited[n.k] = true;
        }
        return (dist[n2] == Long.MAX_VALUE) ? -1 : dist[n2];
    }

}
