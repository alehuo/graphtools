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
package com.alehuo.graphtools.comparator;

import com.alehuo.graphtools.graph.Edge;
import java.util.Comparator;

/**
 * Edge weight comparator.
 *
 * @author alehuo
 */
public class EdgeWeightComparator implements Comparator<Edge> {

    private final boolean descending;

    /**
     * Edge weight compatator
     *
     * @param descending Should the edge list be sorted into a descending order.
     * True for descending, false for ascending.
     */
    public EdgeWeightComparator(boolean descending) {
        this.descending = descending;
    }

    /**
     * Edge weight comparator. Sorts the edge array into an ascending order.
     */
    public EdgeWeightComparator() {
        descending = false;
    }

    @Override
    public int compare(Edge o1, Edge o2) {
        int a = 1;
        if (descending) {
            a = -1;
        }
        if (o1.getWeight() - o2.getWeight() > 0) {
            return a * 1;
        } else if (o1.getWeight() - o2.getWeight() < 0) {
            return -a * 1;
        }
        return 0;
    }

}
