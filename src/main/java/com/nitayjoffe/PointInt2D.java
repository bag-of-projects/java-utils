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

package com.nitayjoffe;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

public class PointInt2D extends AnObject implements Comparable<PointInt2D> {
  private int x;
  private int y;

  public PointInt2D() {}

  public PointInt2D(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void offset(int dx, int dy) {
    x += dx;
    y += dy;
  }

  @Override
  public int compareTo(PointInt2D o) {
    return ComparisonChain.start()
        .compare(x, o.x)
        .compare(y, o.y)
        .result();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o instanceof PointInt2D) {
      PointInt2D l = (PointInt2D) o;
      return Objects.equal(x, l.x) && Objects.equal(y, l.y);
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
