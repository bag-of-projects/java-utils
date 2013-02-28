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

package com.nitayjoffe.util.arrays;

import com.google.common.collect.UnmodifiableIterator;

public class LocationIterator extends UnmodifiableIterator<Coordinate> {
  private final int rowEnd;
  private final int columnEnd;

  private int row;
  private int column;

  public LocationIterator(int rowLength, int columnLength) {
    this(0, rowLength, 0, columnLength);
  }

  public LocationIterator(int rowStart, int rowEnd,
                          int columnStart, int columnEnd) {
    this.row = rowStart;
    this.column = columnStart;
    this.rowEnd = rowEnd;
    this.columnEnd = columnEnd;
  }

  @Override
  public boolean hasNext() {
    return row < rowEnd && column < columnEnd;
  }

  @Override
  public ImmutableLocation next() {
    ImmutableLocation location = new ImmutableLocation(row, column);

    ++column;
    if (column == columnEnd) {
      column = 0;
      ++row;
    }

    return location;
  }
}
