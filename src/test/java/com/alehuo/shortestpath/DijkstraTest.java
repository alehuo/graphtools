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

import com.alehuo.shortestpath.graph.Graph;
import com.alehuo.shortestpath.graph.Node;
import com.alehuo.shortestpath.exception.NegativeWeightException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class used to test Dijkstra's algorithm.
 *
 * @author alehuo
 */
public class DijkstraTest {

    @Test
    public void algorithmWorks() throws NegativeWeightException {

        //Distances from starting node to other nodes
        long[] dist = {Long.MAX_VALUE, 0, 9, 3, 14, 10, 15, 7, 12};

        Graph g = new Graph(8);

        g.addTwEdge(new Node(1), new Node(2), 9);
        g.addTwEdge(new Node(1), new Node(3), 3);
        g.addTwEdge(new Node(2), new Node(4), 5);
        g.addTwEdge(new Node(2), new Node(7), 4);
        g.addTwEdge(new Node(3), new Node(7), 4);
        g.addTwEdge(new Node(3), new Node(5), 8);
        g.addTwEdge(new Node(4), new Node(8), 9);
        g.addTwEdge(new Node(5), new Node(8), 2);
        g.addTwEdge(new Node(5), new Node(7), 3);
        g.addTwEdge(new Node(6), new Node(7), 8);

        for (int i = 1; i <= 8; i++) {
            assertEquals("Distance from node 1 to " + i + " should be " + dist[i], dist[i], g.shortestDistance(new Node(1), new Node(i)));
        }

    }

    @Test(expected = NegativeWeightException.class)
    public void negativeWeightsThrowAnException() throws NegativeWeightException {
        Graph g = new Graph(2);
        g.addTwEdge(new Node(1), new Node(2), -1);
        g.shortestDistance(new Node(1), new Node(2));
    }

}
