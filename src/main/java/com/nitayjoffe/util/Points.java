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

public class Points extends AnObject {
  protected Points() {}

  public static PointDbl3D average(double[][] points) {
    PointDbl3D result = new PointDbl3D();
    for (double[] p : points) {
      result.add(p);
    }
    result.divide(points.length);
    return result;
  }

  public static PointDbl3D average(PointDbl3D... points) {
    PointDbl3D result = new PointDbl3D();
    for (PointDbl3D p : points) {
      result.add(p);
    }
    result.divide(points.length);
    return result;
  }

  public static double subtract(PointDbl3D a, PointDbl3D b) {
    PointDbl3D p = new PointDbl3D(a);
    p.subtract(b);
    return p.length();
  }
}
