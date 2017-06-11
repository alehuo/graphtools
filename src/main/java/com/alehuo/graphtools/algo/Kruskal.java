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

import com.alehuo.graphtools.comparator.EdgeWeightComparator;
import com.alehuo.graphtools.graph.Edge;
import com.alehuo.graphtools.graph.Graph;
import com.alehuo.graphtools.struct.UnionFind;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Kruskal's algorithm.
 *
 * @author ahuotala
 */
public class Kruskal {

    /**
     * Graph.
     */
    private final Graph g;

    /**
     * Kruskal's algorithm
     * @param g Graph Graph to be used with Kruskal's algorithm.
     */
    public Kruskal(Graph g) {
        this.g = g;
    }

    /**
     * Returns the minimum or maximum spanning tree.
     * @param maximum Calculate the maximum spanning tree. If set to false, will calculate the minimum spanning tree.
     * @return Minimum or maximum spanning tree
     */
    public ArrayList<Edge> spanningTree(boolean maximum) {
        //Get edges from the graph
        ArrayList<Edge> edges = this.g.getEdges();
        
        //Initialize the spanning tree list
        ArrayList<Edge> tree = new ArrayList<>();
        EdgeWeightComparator edgeWeightComparator = new EdgeWeightComparator(maximum);
        
        //Sort the edges in ascending or descending order.
        Collections.sort(edges, edgeWeightComparator);
        
        //We use Union find data structure to link nodes together.
        UnionFind un = new UnionFind(this.g.getN());
        
        //Loop through each edges
        edges.stream().filter((edge) -> (un.find(edge.getStartingNode().getKey()) != un.find(edge.getEndingNode().getKey()))).forEachOrdered((edge) -> {
            un.union(edge.getStartingNode(), edge.getEndingNode());
            tree.add(edge);
        });
        
        return tree;
    }

}
