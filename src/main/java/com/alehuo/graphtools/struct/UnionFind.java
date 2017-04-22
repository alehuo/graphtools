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
package com.alehuo.graphtools.struct;

import com.alehuo.graphtools.graph.Node;

/**
 * Union-find data structure.
 *
 * @author alehuo
 */
public class UnionFind {

    /**
     * IDs.
     */
    private final int[] idt;

    /**
     *
     */
    private final int[] sz;

    /**
     * Disjoint components.
     */
    private int numComponents;

    public UnionFind(int n) {
        numComponents = n;
        idt = new int[n + 1];
        sz = new int[n + 1];
        for (int i = 0; i < idt.length; i++) {
            idt[i] = i;
        }
    }

    public int find(int i) {
        while (i != idt[i]) {
            idt[i] = idt[idt[i]];
            i = idt[i];
        }
        return i;
    }

    /**
     * Connects two nodes.
     *
     * @param a Node a
     * @param b Node b
     */
    public void union(Node a, Node b) {
        union(a.getKey(), b.getKey());
    }

    /**
     * Connects two nodes.
     *
     * @param a Node a
     * @param b Node b
     */
    public void union(int a, int b) {
        int i = find(a);
        int j = find(b);
        if (i == j) {
            return;
        }

        numComponents--;

        if (sz[i] < sz[j]) {
            idt[i] = j;
            sz[j] += sz[i];
        } else {
            idt[j] = i;
            sz[i] += sz[j];
        }
    }

    /**
     * Returns if nodes a and b are connected together.
     *
     * @param a Node a
     * @param b Node b
     * @return If nodes a and b are connected together
     */
    public boolean connection(Node a, Node b) {
        return connection(a.getKey(), b.getKey());
    }

    /**
     * Returns if nodes a and b are connected together.
     *
     * @param a Node a
     * @param b Node b
     * @return If nodes a and b are connected together
     */
    public boolean connection(int a, int b) {
        return find(a) == find(b);
    }

    public int getNumComponents() {
        return numComponents;
    }
}
