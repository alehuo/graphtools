/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
