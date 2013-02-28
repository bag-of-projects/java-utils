package com.nitayjoffe.util.collections;

import java.util.Map;

public class MapUtils {
  protected MapUtils() { }

  public static <K,V> V putIfAbsent(Map<K, V> map, K key, V newValue) {
    V value = map.get(key);
    if (value != null) {
      return value;
    }
    map.put(key, newValue);
    return newValue;
  }
}
