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

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Queue;

public class IteratorUtils {
  public static <E> Iterator<E> interleave(final Iterator<E> ... iterators) {
    return interleave(Arrays.asList(iterators));
  }

  public static <E> Iterator<E> interleave(final Iterable<Iterator<E>> iterators) {
    return new AbstractIterator<E>() {
      private Queue<Iterator<E>> queue = Lists.newLinkedList(iterators);
      @Override
      protected E computeNext() {
        while (!queue.isEmpty()) {
          Iterator<E> topIter = queue.poll();
          if (topIter.hasNext()) {
            E result = topIter.next();
            queue.offer(topIter);
            return result;
          }
        }
        return endOfData();
      }
    };
  }
}
