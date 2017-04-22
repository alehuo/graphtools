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
import com.alehuo.graphtools.exception.EdgeWeightException;
import com.alehuo.graphtools.exception.UnknownAlgorithmException;
import com.alehuo.graphtools.graph.Graph;
import com.alehuo.graphtools.graph.Node;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alehuo
 */
public class BfsTest {

    @Test
    public void algorithmWorks() throws EdgeWeightException, UnknownAlgorithmException {
        Graph g = new Graph(8);
        g.addTwEdge(new Node(1), new Node(2));
        g.addTwEdge(new Node(2), new Node(3));
        g.addTwEdge(new Node(3), new Node(4));
        g.addTwEdge(new Node(1), new Node(5));
        g.addTwEdge(new Node(1), new Node(6));
        g.addTwEdge(new Node(2), new Node(6));
        g.addTwEdge(new Node(3), new Node(7));
        g.addTwEdge(new Node(4), new Node(7));
        g.addTwEdge(new Node(4), new Node(8));

        long[] dist1 = {Long.MAX_VALUE, 0, 1, 2, 3, 1, 1, 3, 4};
        for (int i = 1; i < dist1.length; i++) {
            assertEquals(dist1[i], g.shortestDistance(new Node(1), new Node(i), AlgorithmType.BFS));
        }

        long[] dist2 = {Long.MAX_VALUE, 1, 0, 1, 2, 2, 1, 2, 3};
        for (int i = 1; i < dist2.length; i++) {
            assertEquals(dist2[i], g.shortestDistance(new Node(2), new Node(i), AlgorithmType.BFS));
        }

        long[] dist3 = {Long.MAX_VALUE, 4, 3, 2, 1, 5, 4, 2, 0};
        for (int i = 1; i < dist3.length; i++) {
            assertEquals(dist3[i], g.shortestDistance(new Node(8), new Node(i), AlgorithmType.BFS));
        }

    }

    @Test(expected = EdgeWeightException.class)
    public void throwsException() throws EdgeWeightException, UnknownAlgorithmException {
        Graph g = new Graph(2);
        g.addTwEdge(new Node(1), new Node(2), 22);
        g.shortestDistance(new Node(1), new Node(2), AlgorithmType.BFS);
    }
}
