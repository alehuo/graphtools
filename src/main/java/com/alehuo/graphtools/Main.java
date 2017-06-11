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
package com.alehuo.graphtools;

import com.alehuo.graphtools.algo.AlgorithmType;
import com.alehuo.graphtools.comparator.EdgeWeightComparator;
import com.alehuo.graphtools.graph.Graph;
import com.alehuo.graphtools.graph.Node;
import com.alehuo.graphtools.exception.EdgeWeightException;
import com.alehuo.graphtools.exception.UnknownAlgorithmException;
import com.alehuo.graphtools.graph.Edge;
import com.alehuo.graphtools.graph.Graph;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author alehuo
 */
public class Main {

    public static void main(String[] args) throws EdgeWeightException, UnknownAlgorithmException {

        int nodeCount = 4;

        Graph g = new Graph(nodeCount);
        
        g.addTwEdge(1, 2, 3);
        g.addTwEdge(2, 4, 6);
        g.addTwEdge(3, 4, 7);
        g.addTwEdge(1, 3, 4);
        g.addTwEdge(2, 3, 5);
        
        ArrayList<Edge> minimumSpanningTree = g.maximumSpanningTree(AlgorithmType.KRUSKAL);
        for (Edge edge : minimumSpanningTree) {
            System.out.println(edge);
        }
        
        /*
        //Two way edges with custom weights
        g.addTwEdge(new Node(1), new Node(4), 5); //1 <-(5)-> 4
        g.addTwEdge(new Node(1), new Node(2), 2); //1 <-(2)-> 2
        g.addTwEdge(new Node(2), new Node(4), 5); //2 <-(5)-> 4
        g.addTwEdge(new Node(2), new Node(5), 4); //2 <-(4)-> 5
        g.addTwEdge(new Node(2), new Node(3), 14); //2 <-(14)-> 3

        //Two way edge with a basic weight
        g.addTwEdge(new Node(1), new Node(3)); //1 <-(1)-> 3

        //Single way edges with custom weights
        g.addSwEdge(new Node(4), new Node(5), 58); //4 -(58)-> 5
        g.addSwEdge(new Node(3), new Node(5), 34); //3 -(34)-> 5

        //Single way edge with a basic weight
        g.addSwEdge(new Node(6), new Node(7)); //6 -(1)-> 7

        ArrayList<Edge> edges = g.getEdges();
        Collections.sort(edges, new EdgeWeightComparator(true));
        for (Edge edge : edges) {
            System.out.println(edge);
        }

//        for (int i = 1; i <= nodeCount; i++) {
//            for (int j = 1; j <= nodeCount; j++) {
//                System.out.println(i + " -> " + j + " : " + g.shortestDistance(new Node(i), new Node(j), AlgorithmType.DIJKSTRA));
//            }
//        }
          */

    }
}
