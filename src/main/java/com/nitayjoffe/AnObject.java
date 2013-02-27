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

import java.util.Arrays;

public class AnObject {
  public static void p(Object ... objects) {
    for (Object object : objects) {
      printObject(object);
    }
  }

  private static void printObject(Object object) {
    if (object instanceof boolean[]) {
      System.out.println(Arrays.toString((boolean[]) object));
    } else if (object instanceof char[]) {
      System.out.println(Arrays.toString((char[]) object));
    } else if (object instanceof byte[]) {
      System.out.println(Arrays.toString((byte[])object));
    } else if (object instanceof short[]) {
      System.out.println(Arrays.toString((short[])object));
    } else if (object instanceof int[]) {
      System.out.println(Arrays.toString((int[])object));
    } else if (object instanceof long[]) {
      System.out.println(Arrays.toString((long[])object));
    } else if (object instanceof float[]) {
      System.out.println(Arrays.toString((float[])object));
    } else if (object instanceof double[]) {
      System.out.println(Arrays.toString((double[])object));
    } else if (object instanceof Object[]) {
      System.out.println(Arrays.deepToString((Object[])object));
    } else {
      System.out.println(String.valueOf(object));
    }
  }
}
