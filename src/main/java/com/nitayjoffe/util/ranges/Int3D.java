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
