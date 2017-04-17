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

import com.alehuo.shortestpath.color.NColor;
import com.alehuo.shortestpath.exception.EdgeWeightException;
import com.alehuo.shortestpath.graph.Edge;
import com.alehuo.shortestpath.graph.Graph;
import com.alehuo.shortestpath.graph.Node;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Breadth-first search algorithm.
 *
 * @author alehuo
 */
public class BreadthFirstSearch implements Algorithm {

    /**
     * Graph.
     */
    private final Graph g;

    /**
     * Distances.
     */
    private long[] dist;

    /**
     * Colors.
     */
    private NColor[] colors;

    /**
     * Tree.
     */
    private Node[] tree;

    /**
     * Breadth-first search algorithm.
     *
     * @param g
     */
    public BreadthFirstSearch(Graph g) {
        this.g = g;
    }

    /**
     * Breadth-first search -algorithm.
     *
     * @param root
     * @throws com.alehuo.shortestpath.exception.EdgeWeightException
     */
    private void bfs(Node root) throws EdgeWeightException {
        ArrayDeque<Node> que = new ArrayDeque();

        dist = new long[g.getN() + 1];
        colors = new NColor[g.getN() + 1];
        tree = new Node[g.getN() + 1];

        this.reset();

        colors[root.getKey()] = NColor.GRAY;
        dist[root.getKey()] = 0;
        que.push(root);

        while (!que.isEmpty()) {

            Node curr = que.poll();

            ArrayList<Edge> adjacentNodes = g.getEdgesFrom(curr);
            for (Edge edge : adjacentNodes) {
                if (edge.getWeight() != 1) {
                    throw new EdgeWeightException("The graph must be an unweighted graph.");
                }
                if (colors[edge.getNode().getKey()] == NColor.WHITE) {
                    colors[edge.getNode().getKey()] = NColor.GRAY;
                    dist[edge.getNode().getKey()] = dist[curr.getKey()] + 1;
                    tree[edge.getNode().getKey()] = curr;
                    que.push(edge.getNode());
                }
            }
            colors[curr.getKey()] = NColor.BLACK;
        }
    }

    private void reset() {
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(colors, NColor.WHITE);
        Arrays.fill(tree, null);
    }

    public Node[] getTree() {
        return tree;
    }

    public long[] getDist() {
        return dist;
    }

    public NColor[] getColors() {
        return colors;
    }

    /**
     * Prints the shortest path.
     *
     * @param start Starting node
     * @param end Ending node
     * @throws EdgeWeightException Edge weight exception if the graph is
     * weighted.
     */
    public void printShortestPath(Node start, Node end) throws EdgeWeightException {
        Stack<Node> stack = new Stack();
        bfs(start);

        Node u = tree[end.getKey()];
        while (u.getKey() != start.getKey()) {
            stack.push(u);
            u = tree[u.getKey()];
        }
        System.out.println("Shortest path from node " + start.getKey() + " to node " + end.getKey());
        System.out.print(start.getKey() + " ");
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            System.out.print(n.getKey() + " ");
        }
        System.out.print(end.getKey() + " ");
        System.out.println("");
    }

    /**
     * Returns the shortest distance between nodes.
     *
     * @param n1 Starting node
     * @param n2 Ending node
     * @return Shortest distance between nodes
     * @throws EdgeWeightException Edge weight exception if the graph is
     * weighted.
     */
    @Override
    public long shortestDistance(Node n1, Node n2) throws EdgeWeightException {
        bfs(n1);
        return dist[n2.getKey()];
    }
}
