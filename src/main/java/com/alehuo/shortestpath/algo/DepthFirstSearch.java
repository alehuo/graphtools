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

import com.alehuo.shortestpath.exception.EdgeWeightException;
import com.alehuo.shortestpath.graph.Node;

/**
 * Depth-first search algorithm.
 *
 * @author alehuo
 */
public class DepthFirstSearch implements Algorithm {

    @Override
    public long shortestDistance(Node n1, Node n2) throws EdgeWeightException {
        throw new UnsupportedOperationException("Not supported.");
    }

}
