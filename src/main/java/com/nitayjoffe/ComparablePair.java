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

import com.google.common.collect.ComparisonChain;

import java.util.Iterator;

public class ComparablePair<T extends Comparable> extends AnObject
    implements Comparable<ComparablePair<T>>, Iterable<T> {
  private final Pair<T> pair;

  public ComparablePair() {
    pair = new Pair<T>();
  }

  public ComparablePair(T first, T second) {
    pair = new Pair<T>(first, second);
  }

  public boolean contains(T x) {
    return pair.contains(x);
  }

  public T getFirst() {
    return pair.getFirst();
  }

  public void setFirst(T first) {
    pair.setFirst(first);
  }

  public T getSecond() {
    return pair.getSecond();
  }

  public void setSecond(T second) {
    pair.setSecond(second);
  }

  @Override
  public Iterator<T> iterator() {
    return pair.iterator();
  }

  @Override
  public int compareTo(ComparablePair<T> o) {
    if (this == o) {
      return 0;
    }
    return ComparisonChain.start()
        .compare(pair.getFirst(), o.pair.getFirst())
        .compare(pair.getSecond(), o.pair.getSecond())
        .result();
  }

  @Override
  public int hashCode() {
    return pair.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj instanceof ComparablePair) {
      ComparablePair cp = (ComparablePair) obj;
      return pair.equals(cp.pair);
    }
    return false;
  }

  @Override
  public String toString() {
    return pair.toString();
  }
}
