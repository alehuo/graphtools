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
package com.alehuo.shortestpath;

import com.alehuo.shortestpath.algo.Dijkstra;
import com.alehuo.shortestpath.exception.NegativeWeightException;
import java.util.ArrayList;

/**
 * Graph class.
 *
 * @author alehuo
 */
public class Graph {

    /**
     * Adjacency list.
     */
    private final ArrayList[] adjacencyList;

    /**
     * Number of nodes.
     */
    private final int n;

    public Graph(int n) {
        this.n = n;
        adjacencyList = new ArrayList[n + 1];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList();
        }
    }

    /**
     * Add a connection between nodes.
     *
     * @param n1 Node #1
     * @param n2 Node #2
     * @param weight Weight of the node
     * @param bothWays Is the connection bidirectional
     */
    public void addConnection(int n1, int n2, long weight, boolean bothWays) {
        adjacencyList[n1].add(new Node(n2, weight));
        if (bothWays) {
            adjacencyList[n2].add(new Node(n1, weight));
        }
    }

    /**
     * Add a connection between nodes, from n1 to n2.
     *
     * @param n1 Node #1
     * @param n2 Node #2
     * @param weight Weight of the node
     */
    public void addConnection(int n1, int n2, long weight) {
        adjacencyList[n1].add(new Node(n2, weight));
    }

    /**
     * Add a connection between nodes, from n1 to n2 with a weight of 1.
     *
     * @param n1 Node #1
     * @param n2 Node #2
     */
    public void addConnection(int n1, int n2) {
        adjacencyList[n1].add(new Node(n2, 1));
    }

    public int getN() {
        return n;
    }

    /**
     * Returns the list of connections fron node n.
     *
     * @param n Node
     * @return List of connections fron node n
     */
    public ArrayList<Node> getConnections(int n) {
        return adjacencyList[n];
    }

    /**
     * Prints the adjacency list.
     */
    public void printAdjacencyList() {
        for (int i = 1; i < adjacencyList.length; i++) {
            System.out.println("Connections from node " + i + ":");
            ArrayList<Node> arrayList = adjacencyList[i];
            arrayList.forEach((n) -> {
                System.out.println("--> " + n);
            });
        }
    }

    /**
     * Returns the shortest path between nodes using Dijkstra's algorithm.
     *
     * @param n1 Starting node
     * @param n2 Ending node
     * @return Returns -1 if a path is not found, otherwise returns the shortest
     * path.
     * @throws NegativeWeightException Dijkstra's algorithm doesn't allow
     * negative weights, so throws an exception if one is found.
     */
    public long shortestDistance(int n1, int n2) throws NegativeWeightException {
        Dijkstra d = new Dijkstra(this);
        return d.shortestDistance(n1, n2);
    }

}
