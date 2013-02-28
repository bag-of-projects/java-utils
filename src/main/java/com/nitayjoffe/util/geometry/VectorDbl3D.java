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

package com.nitayjoffe.util.geometry;

import com.google.common.base.Preconditions;
import com.nitayjoffe.util.AnObject;

public class VectorDbl3D extends AnObject implements Comparable<VectorDbl3D> {
  private final PointDbl3D point;

  public VectorDbl3D(VectorDbl3D p) {
    point = new PointDbl3D(p.point);
  }

  public VectorDbl3D(double[] p) {
    point = new PointDbl3D(p);
  }

  /**
   * Constructor for vector pointing from p1 to p2.
   *
   * @param p1
   * @param p2
   */
  public VectorDbl3D(double[] p1, double[] p2) {
    Preconditions.checkArgument(p1.length == p2.length);
    double[] p = new double[p1.length];
    for (int i = 0; i < p1.length; ++i) {
      p[i] = p2[i] - p1[i];
    }
    point = new PointDbl3D(p);
  }

  public VectorDbl3D(double x, double y, double z) {
    point = new PointDbl3D(x, y, z);
  }

  public void add(VectorDbl3D o) {
    point.add(o.point);
  }

  public double[] getData() {
    return point.getData();
  }

  public double y() {
    return point.y();
  }

  public double x() {
    return point.x();
  }

  public double z() {
    return point.z();
  }

  public boolean isValid() {
    return point.isValid();
  }

  public void normalize() {
    divide(length());
  }

  public double dotProduct(VectorDbl3D o) {
    return x() * o.x() + y() * o.y() + z() * o.z();
  }

  public void add(double[] points) {
    point.add(points);
  }

  public double length() {
    return Math.sqrt(dotProduct(this));
  }

  public void divide(long l) {
    point.divide(l);
  }

  public void divide(double d) {
    point.divide(d);
  }

  public void multiply(double d) {
    point.multiply(d);
  }

  public void subtract(VectorDbl3D o) {
    point.subtract(o.point);
  }

  @Override
  public int compareTo(VectorDbl3D o) {
    return point.compareTo(o.point);
  }

  @Override
  public String toString() {
    return String.format("<%.2f,%.2f,%.2f>", x(), y(), z());
  }

  @Override
  public int hashCode() {
    return point.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj instanceof VectorDbl3D) {
      VectorDbl3D v = (VectorDbl3D) obj;
      return point.equals(v.point);
    }
    return false;
  }
}
