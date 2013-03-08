package com.nitayjoffe.util.ranges;

import com.google.common.collect.DiscreteDomains;
import com.google.common.collect.Range;
import com.google.common.collect.UnmodifiableIterator;

import java.util.Iterator;
import java.util.Set;

public class Range3D implements Iterable<Int3D> {
  private class ComboIter extends UnmodifiableIterator<Int3D> {
    private final Iterator<Integer> iter1;
    private final Set<Integer> set2;
    private Iterator<Integer> iter2;
    private final Set<Integer> set3;
    private Iterator<Integer> iter3;
    private Int3D value;

    public ComboIter(Set<Integer> set1, Set<Integer> set2, Set<Integer> set3) {
      this.iter1 = set1.iterator();
      this.set2 = set2;
      this.iter2 = set2.iterator();
      this.set3 = set3;
      this.iter3 = set3.iterator();
    }

    @Override public boolean hasNext() {
      return iter3.hasNext() || iter2.hasNext() || iter1.hasNext();
    }

    @Override public Int3D next() {
      if (value == null) {
        value = new Int3D();
        value.a = iter1.next();
        value.b = iter2.next();
      }
      if (!iter3.hasNext()) {
        if (!iter2.hasNext()) {
          iter2 = set2.iterator();
          value.a = iter1.next();
        }
        iter3 = set3.iterator();
        value.b = iter2.next();
      }
      value.c = iter3.next();
      return value;
    }
  }

  private final Set<Integer> set1;
  private final Set<Integer> set2;
  private final Set<Integer> set3;

  private Range3D(Range<Integer> range1, Range<Integer> range2,
                  Range<Integer> range3) {
    set1 = range1.asSet(DiscreteDomains.integers());
    set2 = range2.asSet(DiscreteDomains.integers());
    set3 = range3.asSet(DiscreteDomains.integers());
  }

  public static Range3D range3D(Range<Integer> range1, Range<Integer> range2,
                                Range<Integer> range3) {
    return new Range3D(range1, range2, range3);
  }

  @Override public Iterator<Int3D> iterator() {
    return new ComboIter(set1, set2, set3);
  }
}
