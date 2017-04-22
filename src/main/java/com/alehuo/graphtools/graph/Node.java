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
 * Node class.
 *
 * @author alehuo
 */
public class Node {

    private final int key;

    public Node(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.key;
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
        final Node other = (Node) obj;
        if (this.key != other.key) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Key: " + key;
    }

}
