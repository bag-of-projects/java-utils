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

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

import static com.nitayjoffe.util.numbers.Numbers.equal;

public class Int3D implements Comparable<Int3D> {
  int a;
  int b;
  int c;

  @Override public int compareTo(Int3D o) {
    return ComparisonChain.start()
        .compare(a, o.a)
        .compare(b, o.b)
        .compare(c, o.c)
        .result();
  }

  @Override public String toString() {
    return a + "," + b + "," + c;
  }

  @Override public int hashCode() {
    return Objects.hashCode(a, b, c);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj instanceof Int3D) {
      Int3D other = (Int3D) obj;
      return equal(a, other.a) && equal(b, other.b) && equal(c, other.c);
    }
    return false;
  }
}
