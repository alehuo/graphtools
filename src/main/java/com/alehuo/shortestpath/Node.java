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

/**
 * Node class.
 *
 * @author alehuo
 */
public class Node implements Comparable<Node> {

    public int k;
    private long w;

    /**
     * Node class.
     *
     * @param k Node
     * @param w Weight
     */
    public Node(int k, long w) {
        this.k = k;
        this.w = w;
    }

    public long getW() {
        return w;
    }

    public void setW(long w) {
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        if (o.getW() - this.getW() > 0) {
            return -1;
        } else if (o.getW() - this.getW() < 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return k + " (w: " + w + ")";
    }

}
