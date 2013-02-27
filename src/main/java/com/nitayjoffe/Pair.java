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

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Pair<T> extends AnObject implements Iterable<T> {
  private T first;
  private T second;

  public Pair() {}

  public Pair(T first, T second) {
    this.first = first;
    this.second = second;
  }

  public boolean contains(T x) {
    return Objects.equal(first, x) || Objects.equal(second, x);
  }

  public T getFirst() {
    return first;
  }

  public void setFirst(T first) {
    this.first = first;
  }

  public T getSecond() {
    return second;
  }

  public void setSecond(T second) {
    this.second = second;
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(this)
        .add("first", first)
        .add("second", second)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(first, second);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj instanceof Pair) {
      Pair<T> other = Casts.cast(obj);
      return Objects.equal(first, other.first) &&
          Objects.equal(second, other.second);
    }
    return false;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private int index = 0;

      @Override
      public boolean hasNext() {
        return index < 2;
      }

      @Override
      public T next() {
        switch (index++) {
          case 0: return first;
          case 1: return second;
          default: throw new NoSuchElementException();
        }
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }
}
