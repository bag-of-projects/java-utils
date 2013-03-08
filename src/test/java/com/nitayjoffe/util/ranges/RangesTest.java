/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.nitayjoffe.util.ranges;

import org.testng.annotations.Test;

import java.util.Iterator;

import static com.google.common.collect.Ranges.closedOpen;
import static com.nitayjoffe.util.ranges.Range2D.range2D;
import static com.nitayjoffe.util.ranges.Range3D.range3D;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RangesTest {
  @Test public void range2d() {
    Range2D r2d = range2D(closedOpen(0, 2), closedOpen(3, 5));
    Iterator<Int2D> i2d = r2d.iterator();
    assertTrue(i2d.hasNext());
    Int2D exp = new Int2D();
    exp.a = 0;
    exp.b = 3;
    assertEquals(i2d.next(), exp);

    assertTrue(i2d.hasNext());
    exp.b = 4;
    assertEquals(i2d.next(), exp);

    assertTrue(i2d.hasNext());
    exp.a = 1;
    exp.b = 3;
    assertEquals(i2d.next(), exp);

    assertTrue(i2d.hasNext());
    exp.b = 4;
    assertEquals(i2d.next(), exp);

    assertFalse(i2d.hasNext());
  }

  @Test public void range3d() {
    Range3D r3d = range3D(closedOpen(0, 2), closedOpen(3, 5), closedOpen(4, 6));
    Iterator<Int3D> i3d = r3d.iterator();
    assertTrue(i3d.hasNext());
    Int3D exp = new Int3D();
    exp.a = 0;
    exp.b = 3;
    exp.c = 4;
    assertEquals(i3d.next(), exp);

    assertTrue(i3d.hasNext());
    exp.c = 5;
    assertEquals(i3d.next(), exp);

    assertTrue(i3d.hasNext());
    exp.b = 4;
    exp.c = 4;
    assertEquals(i3d.next(), exp);

    assertTrue(i3d.hasNext());
    exp.c = 5;
    assertEquals(i3d.next(), exp);

    assertTrue(i3d.hasNext());
    exp.a = 1;
    exp.b = 3;
    exp.c = 4;
    assertEquals(i3d.next(), exp);

    assertTrue(i3d.hasNext());
    exp.c = 5;
    assertEquals(i3d.next(), exp);

    assertTrue(i3d.hasNext());
    exp.b = 4;
    exp.c = 4;
    assertEquals(i3d.next(), exp);

    assertTrue(i3d.hasNext());
    exp.c = 5;
    assertEquals(i3d.next(), exp);

    assertFalse(i3d.hasNext());
  }
}
