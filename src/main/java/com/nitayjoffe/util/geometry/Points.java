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

import com.nitayjoffe.util.AnObject;

public class Points extends AnObject {
  protected Points() {}

  public static PointDbl3D average(double[][] points) {
    PointDbl3D result = PointDbl3D.origin();
    for (double[] p : points) {
      result.add(p);
    }
    result.divide(points.length);
    return result;
  }

  public static PointDbl3D average(PointDbl3D... points) {
    PointDbl3D result = PointDbl3D.origin();
    for (PointDbl3D p : points) {
      result.add(p);
    }
    result.divide(points.length);
    return result;
  }

  private static double length(double x, double y, double z) {
    return Math.sqrt(x * x + y * y + z * z);
  }

  public static double length(PointDbl3D point) {
    return length(point.x(), point.y(), point.z());
  }

  public static double subtract(PointDbl3D a, PointDbl3D b) {
    return length(a.x() - b.x(), a.y() - b.y(), a.z() - b.z());
  }
}
