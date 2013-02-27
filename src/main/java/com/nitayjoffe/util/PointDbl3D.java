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

package com.nitayjoffe.util;

import com.google.common.base.Function;
import com.google.common.collect.ComparisonChain;

import java.util.Arrays;

public class PointDbl3D extends AnObject implements Comparable<PointDbl3D> {
  public static final int DIMENSIONS = 3;

  public static final Function<PointDbl3D, double[]> TO_DATA_FUNC =
    new Function<PointDbl3D, double[]>() {
      @Override
      public double[] apply(PointDbl3D input) {
        if (input == null) {
          return null;
        }
        return input.getData();
      }
    };

  private static final int X = 0;
  private static final int Y = 1;
  private static final int Z = 2;

  private double[] data = new double[DIMENSIONS];

  public PointDbl3D() {}

  public PointDbl3D(PointDbl3D p) {
    this(p.data);
  }

  public PointDbl3D(double[] p) {
    assert data.length == p.length;
    data = Arrays.copyOf(p, p.length);
  }

  public PointDbl3D(double x, double y, double z) {
    data[X] = x;
    data[Y] = y;
    data[Z] = z;
  }

  public double x() { return data[X]; }
  public double y() { return data[Y]; }
  public double z() { return data[Z]; }

  public double[] getData() {
    return data;
  }

  public boolean isValid() {
    for (double datum : data) {
      if (Double.isInfinite(datum) || Double.isNaN(datum)) {
        return false;
      }
    }
    return true;
  }

  public double length() {
    return Math.sqrt(x() * x() + y() * y() + z() * z());
  }

  public void add(PointDbl3D o) {
    add(o.data);
  }

  public void add(double[] points) {
    assert data.length == points.length;
    for (int i = 0; i < points.length; ++i) {
      this.data[i] += points[i];
    }
  }

  public void subtract(PointDbl3D o) {
    for (int i = 0; i < data.length; ++i) {
      data[i] -= o.data[i];
    }
  }

  public void multiply(double d) {
    for (int i = 0; i < data.length; ++i) {
      data[i] *= d;
    }
  }

  public void divide(double d) {
    for (int i = 0; i < data.length; ++i) {
      data[i] /= d;
    }
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj instanceof PointDbl3D) {
      PointDbl3D o = (PointDbl3D) obj;
      return Arrays.equals(data, o.data);
    }
    return false;
  }

  @Override public int hashCode() {
    return Arrays.hashCode(data);
  }

  @Override public String toString() {
    return String.format("(%.2f,%.2f,%.2f)", x(), y(), z());
  }

  @Override public int compareTo(PointDbl3D o) {
    return ComparisonChain.start()
        .compare(x(), o.x())
        .compare(y(), o.y())
        .compare(z(), o.z())
        .result();
  }
}
