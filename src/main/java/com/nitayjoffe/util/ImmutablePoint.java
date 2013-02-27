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

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

public class ImmutablePoint extends AnObject implements Comparable<ImmutablePoint> {
  private final int x;
  private final int y;

  public ImmutablePoint(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public ImmutablePoint(PointInt2D p) {
    this.x = p.getX();
    this.y = p.getY();
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public ImmutablePoint offset(int dx, int dy) {
    return new ImmutablePoint(x + dx, y + dy);
  }

  public ImmutablePointF offset(float dx, float dy) {
    return new ImmutablePointF(x + dx, y + dy);
  }

  @Override
  public int compareTo(ImmutablePoint point) {
    return ComparisonChain.start()
        .compare(x, point.x)
        .compare(y, point.y)
        .result();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o instanceof ImmutablePoint) {
      ImmutablePoint other = (ImmutablePoint) o;
      return Objects.equal(x, other.x) && Objects.equal(y, other.y);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(x, y);
  }

  @Override
  public String toString() {
    return x + "," + y;
  }
}
