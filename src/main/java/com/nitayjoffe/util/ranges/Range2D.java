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
package com.nitayjoffe.util.ranges;

import com.google.common.collect.DiscreteDomains;
import com.google.common.collect.Range;
import com.google.common.collect.UnmodifiableIterator;

import java.util.Iterator;
import java.util.Set;

public class Range2D implements Iterable<Int2D> {
  private class ComboIter extends UnmodifiableIterator<Int2D> {
    private final Iterator<Integer> iter1;
    private final Set<Integer> set2;
    private Iterator<Integer> iter2;
    private Int2D value;

    public ComboIter(Set<Integer> set1, Set<Integer> set2) {
      this.iter1 = set1.iterator();
      this.set2 = set2;
      this.iter2 = set2.iterator();
    }

    @Override public boolean hasNext() {
      return iter2.hasNext() || iter1.hasNext();
    }

    @Override public Int2D next() {
      if (value == null) {
        value = new Int2D();
        value.a = iter1.next();
      }
      if (!iter2.hasNext()) {
        value.a = iter1.next();
        iter2 = set2.iterator();
      }
      value.b = iter2.next();
      return value;    }
  }

  private final Set<Integer> set1;
  private final Set<Integer> set2;

  private Range2D(Range<Integer> range1, Range<Integer> range2) {
    set1 = range1.asSet(DiscreteDomains.integers());
    set2 = range2.asSet(DiscreteDomains.integers());
  }

  public static Range2D range2D(Range<Integer> range1, Range<Integer> range2) {
    return new Range2D(range1, range2);
  }

  @Override public Iterator<Int2D> iterator() {
    return new ComboIter(set1, set2);
  }
}
