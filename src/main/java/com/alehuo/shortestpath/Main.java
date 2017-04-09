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

/**
 * @author alehuo
 */
public class Main {

    public static void main(String[] args) throws NegativeWeightException {
        Graph g = new Graph(5);
        g.addConnection(1, 4, 5, true);
        g.addConnection(1, 2, 2, true);
        g.addConnection(2, 4, 5, true);
        g.addConnection(2, 5, 4, true);
        g.addConnection(2, 3, 14, true);
        g.addConnection(4, 5, 58, true);
        g.addConnection(3, 5, 34, true);

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.println(i + " -> " + j + " : " + g.shortestDistance(i, j));
            }
        }

        System.out.println("#############################");

        g = new Graph(5);
        g.addConnection(1, 4, 5, true);
        g.addConnection(1, 2, 2, true);
        g.addConnection(2, 4, 5, true);
        g.addConnection(5, 2, 4, false);
        g.addConnection(2, 3, 14, true);
        g.addConnection(4, 5, 58, true);
        g.addConnection(3, 5, 34, true);

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.println(i + " -> " + j + " : " + g.shortestDistance(i, j));
            }
        }

        System.out.println("#############################");

        g = new Graph(5);
        g.addConnection(1, 4, 5, true);
        g.addConnection(1, 2, 2, true);
        g.addConnection(2, 4, 5, true);
        g.addConnection(5, 2, 4, false);
        g.addConnection(3, 2, 14, false);
        g.addConnection(4, 5, 58, true);
        g.addConnection(3, 5, 34, true);

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.println(i + " -> " + j + " : " + g.shortestDistance(i, j));
            }
        }

        System.out.println("#############################");

        g = new Graph(5);

        g.addConnection(1, 2, 9, true);
        g.addConnection(1, 3, 3, true);
        g.addConnection(2, 3, 4, true);
        g.addConnection(2, 5, 20, true);
        g.addConnection(2, 4, 18, true);
        g.addConnection(3, 5, 15, true);

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.println(i + " -> " + j + " : " + g.shortestDistance(i, j));
            }
        }
    }
}
