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
package com.alehuo.shortestpath.graph;

import com.alehuo.shortestpath.algo.AlgorithmType;
import com.alehuo.shortestpath.algo.BreadthFirstSearch;
import com.alehuo.shortestpath.algo.Dijkstra;
import com.alehuo.shortestpath.exception.EdgeWeightException;
import com.alehuo.shortestpath.exception.UnknownAlgorithmException;
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
        //Initialize adjacency list
        adjacencyList = new ArrayList[n + 1];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList();
        }
    }

    /**
     * Add a single-way edge between nodes (n1 => n2) with a custom weight.
     *
     * @param n1 Node #1
     * @param n2 Node #2
     * @param weight Weight of the node
     */
    public void addSwEdge(Node n1, Node n2, long weight) {
        adjacencyList[n1.getKey()].add(new Edge(n2, weight));
    }

    /**
     * Add a two-way edge between nodes (n1 <=> n2) with a custom weight.
     *
     * @param n1 Node #1
     * @param n2 Node #2
     * @param weight Weight of the node
     */
    public void addTwEdge(Node n1, Node n2, long weight) {
        addSwEdge(n1, n2, weight);
        addSwEdge(n2, n1, weight);
    }

    /**
     * Add a single-way edge between two nodes, (n1 => n2) with a weight of 1.
     *
     * @param n1 Node #1
     * @param n2 Node #2
     */
    public void addSwEdge(Node n1, Node n2) {
        addSwEdge(n1, n2, 1);
    }

    /**
     * Add a two-way edge between nodes (n1 <=> n2) with a weight of 1.
     *
     * @param n1 Node #1
     * @param n2 Node #2
     */
    public void addTwEdge(Node n1, Node n2) {
        addTwEdge(n1, n2, 1);
    }

    public int getN() {
        return n;
    }

    /**
     * Returns the list of outcoming edges fron node n.
     *
     * @param n Node
     * @return List of outcoming edges fron node n
     */
    public ArrayList<Edge> getEdgesFrom(Node n) {
        return adjacencyList[n.getKey()];
    }

    /**
     * Prints the adjacency list.
     */
    public void printAdjacencyList() {
        for (int i = 1; i < adjacencyList.length; i++) {
            System.out.println("Connections from node " + i + ":");
            ArrayList<Edge> arrayList = adjacencyList[i];
            arrayList.forEach((n) -> {
                System.out.println("--> " + n);
            });
        }
    }

    /**
     * Returns the shortest path between nodes using the selected algorithm.
     *
     * @param n1 Starting node
     * @param n2 Ending node
     * @param type Algorithm type.
     * @return Returns -1 if a path is not found, otherwise returns the shortest
     * path between nodes n1 and n2
     * @throws EdgeWeightException Dijkstra's algorithm doesn't allow negative
     * weights, so throws an exception if one is found.
     * @throws com.alehuo.shortestpath.exception.UnknownAlgorithmException
     * UnknownAlgorithmException if a suitable algorithm is not found.
     */
    public long shortestDistance(Node n1, Node n2, AlgorithmType type) throws EdgeWeightException, UnknownAlgorithmException {
        if (null == type) {
            throw new UnknownAlgorithmException("Unknown algorithm type.");
        } else {
            switch (type) {
                case DIJKSTRA:
                    Dijkstra d = new Dijkstra(this);
                    return d.shortestDistance(n1, n2);
                case BFS:
                    BreadthFirstSearch bfs = new BreadthFirstSearch(this);
                    return bfs.shortestDistance(n1, n2);
                default:
                    throw new UnknownAlgorithmException("Unknown algorithm type.");
            }
        }

    }

}
