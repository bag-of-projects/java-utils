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

public class ImmutableLocation extends AnObject implements Coordinate, Comparable<ImmutableLocation> {
  private final int row;
  private final int column;

  public ImmutableLocation(Coordinate coordinate) {
    this(coordinate.row(), coordinate.column());
  }

  public ImmutableLocation(int row, int column) {
    this.row = row;
    this.column = column;
  }

  @Override
  public int row() {
    return row;
  }

  @Override
  public int column() {
    return column;
  }

  public ImmutableLocation offset(int drow, int dcolumn) {
    return new ImmutableLocation(row + drow, column + dcolumn);
  }

  @Override
  public int compareTo(ImmutableLocation location) {
    return ComparisonChain.start()
        .compare(row, location.row)
        .compare(column, location.column)
        .result();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o instanceof ImmutableLocation) {
      ImmutableLocation other = (ImmutableLocation) o;
      return Objects.equal(row, other.row) &&
          Objects.equal(column, other.column);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(row, column);
  }

  @Override
  public String toString() {
    return row + "," + column;
  }
}
