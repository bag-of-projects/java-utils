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

import com.nitayjoffe.util.AnObject;

import java.util.Iterator;

public class LocationIterable extends AnObject {
  public static Iterable<Coordinate> make(final int rowLength,
                                          final int columnLength) {
    return make(0, rowLength, 0, columnLength);
  }

  public static Iterable<Coordinate> make(final int rowStart,
      final int rowEnd, final int columnStart, final int columnEnd) {
    return new Iterable<Coordinate>() {
      @Override public Iterator<Coordinate> iterator() {
        return new LocationIterator(rowStart, rowEnd, columnStart, columnEnd);
      }
    };
  }
}
