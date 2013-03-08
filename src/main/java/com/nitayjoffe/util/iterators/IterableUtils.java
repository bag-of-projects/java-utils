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
package com.nitayjoffe.util.iterators;

import com.google.common.base.Function;

import java.util.Arrays;
import java.util.Iterator;

import static com.google.common.collect.Iterables.transform;

public class IterableUtils {
  public static <E> Iterable<E> interleave(final Iterable<E> ... iterables) {
    return interleave(Arrays.asList(iterables));
  }

  public static <E> Iterable<E> interleave(final Iterable<Iterable<E>> iterables) {
    final Iterable<Iterator<E>> iterators = transform(iterables, IterableUtils.<E>toIterator());
    return new Iterable<E>() {
      @Override public Iterator<E> iterator() {
        return IteratorUtils.interleave(iterators);
      }
    };
  }

  private static <E> Function<Iterable<E>, Iterator<E>> toIterator() {
    return new Function<Iterable<E>, Iterator<E>>() {
      @Override
      public Iterator<E> apply(final Iterable<E> input) {
        return input.iterator();
      }
    };
  }
}
