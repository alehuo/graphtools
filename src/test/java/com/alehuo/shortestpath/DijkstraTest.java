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

        g.addConnection(1, 2, 9, true);
        g.addConnection(1, 3, 3, true);
        g.addConnection(2, 4, 5, true);
        g.addConnection(2, 7, 4, true);
        g.addConnection(3, 7, 4, true);
        g.addConnection(3, 5, 8, true);
        g.addConnection(4, 8, 9, true);
        g.addConnection(5, 8, 2, true);
        g.addConnection(5, 7, 3, true);
        g.addConnection(6, 7, 8, true);

        for (int i = 1; i <= 8; i++) {
            assertEquals("Distance from node 1 to " + i + " should be " + dist[i], dist[i], g.shortestDistance(1, i));
        }

    }

    @Test(expected = NegativeWeightException.class)
    public void negativeWeightsThrowAnException() throws NegativeWeightException {
        Graph g = new Graph(2);
        g.addConnection(1, 2, -1);
        g.shortestDistance(1, 2);
    }

}
