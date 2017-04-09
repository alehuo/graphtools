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

/**
 * @author alehuo
 */
public class Main {

    public static void main(String[] args) throws NegativeWeightException {

        Graph g = new Graph(5);
        g.addConnection(new Node(1), new Node(4), 5, true); //1 <--> 4
        g.addConnection(new Node(1), new Node(2), 2, true); //1 <--> 2
        g.addConnection(new Node(2), new Node(4), 5, true); //2 <--> 4
        g.addConnection(new Node(2), new Node(5), 4, true); //2 <--> 5
        g.addConnection(new Node(2), new Node(3), 14, true); //2 <--> 3
        g.addConnection(new Node(4), new Node(5), 58); //4 --> 5
        g.addConnection(new Node(3), new Node(5), 34, false); //3 --> 5

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.println(i + " -> " + j + " : " + g.shortestDistance(new Node(i), new Node(j)));
            }
        }

    }
}
