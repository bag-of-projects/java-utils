package com.nitayjoffe.util.ranges;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

import static com.nitayjoffe.util.numbers.Numbers.equal;

public class Int2D implements Comparable<Int2D> {
  int a;
  int b;

  @Override public int compareTo(Int2D o) {
    return ComparisonChain.start().compare(a, o.a).compare(b, o.b).result();
  }

  @Override public String toString() {
    return a + "," + b;
  }

  @Override public int hashCode() {
    return Objects.hashCode(a, b);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj instanceof Int2D) {
      Int2D other = (Int2D) obj;
      return equal(a, other.a) && equal(b, other.b);
    }
    return false;
  }
}
