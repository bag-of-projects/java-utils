package com.nitayjoffe.util.numbers;

public class Numbers {
  protected Numbers() { }

  public static boolean equal(byte a, byte b) {
    return a == b;
  }

  public static boolean equal(short a, short b) {
    return a == b;
  }

  public static boolean equal(int a, int b) {
    return a == b;
  }

  public static boolean equal(long a, long b) {
    return a == b;
  }

  public static boolean equal(float a, float b) {
    return Float.compare(a, b) == 0;
  }

  public static boolean equal(double a, double b) {
    return Double.compare(a, b) == 0;
  }
}
