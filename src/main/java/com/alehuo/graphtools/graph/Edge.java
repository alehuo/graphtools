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
package com.alehuo.graphtools.graph;

/**
 * Edge class.
 *
 * @author alehuo
 */
public class Edge implements Comparable<Edge> {

    private final Node node;
    private final long weight;

    /**
     * Edge class.
     *
     * @param node Node
     * @param weight Weight
     */
    public Edge(Node node, long weight) {
        this.node = node;
        this.weight = weight;
    }

    public long getWeight() {
        return weight;
    }

    public Node getNode() {
        return node;
    }

    @Override
    public int compareTo(Edge o) {
        if (o.getWeight() - this.getWeight() > 0) {
            return -1;
        } else if (o.getWeight() - this.getWeight() < 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return node.getKey() + " (weight: " + weight + ")";
    }

}
