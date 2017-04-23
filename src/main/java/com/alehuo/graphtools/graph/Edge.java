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

import java.util.Objects;

/**
 * Edge class.
 *
 * @author alehuo
 */
public class Edge implements Comparable<Edge> {

    private final Node start;
    private final Node end;
    private final long weight;

    /**
     * Edge class.
     *
     * @param start Starting node
     * @param end Ending node
     * @param weight Weight
     */
    public Edge(Node start, Node end, long weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public long getWeight() {
        return weight;
    }

    public Node getStartingNode() {
        return start;
    }

    public Node getEndingNode() {
        return end;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.start);
        hash = 19 * hash + Objects.hashCode(this.end);
        hash = 19 * hash + (int) (this.weight ^ (this.weight >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Edge other = (Edge) obj;
        if (this.weight != other.weight) {
            return false;
        }
        if (!Objects.equals(this.start, other.start)) {
            return false;
        }
        if (!Objects.equals(this.end, other.end)) {
            return false;
        }
        return true;
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
        return start.getKey() + " --> " + end.getKey() + " (weight: " + weight + ")";
    }

}
