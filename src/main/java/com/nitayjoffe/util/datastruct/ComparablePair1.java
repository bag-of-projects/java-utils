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

package com.nitayjoffe.util.datastruct;

import com.google.common.collect.ComparisonChain;
import com.nitayjoffe.util.AnObject;

import java.util.Iterator;

public class ComparablePair1<T extends Comparable> extends AnObject
    implements Comparable<ComparablePair1<T>>, Iterable<T> {
  private final Pair1<T> pair;

  public ComparablePair1() {
    pair = new Pair1<T>();
  }

  public ComparablePair1(T first, T second) {
    pair = new Pair1<T>(first, second);
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
  public int compareTo(final ComparablePair1<T> o) {
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
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj instanceof ComparablePair1) {
      ComparablePair1 cp = (ComparablePair1) obj;
      return pair.equals(cp.pair);
    }
    return false;
  }

  @Override
  public String toString() {
    return pair.toString();
  }
}
