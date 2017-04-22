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
package com.alehuo.graphtools;

import com.alehuo.graphtools.struct.UnionFind;
import java.util.Random;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author alehuo
 */
public class UnionFindTest {

    @Test
    public void algorithmWorksTest1() {
        Random r = new Random();
        for (int j = 0; j < 1000; j++) {
            int n = 6 + r.nextInt(16384);
            UnionFind uF = new UnionFind(n);
            assertEquals(n, uF.getNumComponents());
            for (int i = 1; i < n - 1; i++) {
                uF.union(i, 1 + i);
                assertTrue(uF.connection(i, 1 + i));
                assertEquals(n - i, uF.getNumComponents());
            }
        }

    }
}
