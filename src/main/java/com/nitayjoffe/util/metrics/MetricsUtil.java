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
package com.nitayjoffe.util.metrics;

import com.yammer.metrics.Metrics;
import com.yammer.metrics.core.MetricPredicate;
import com.yammer.metrics.core.MetricsRegistry;
import com.yammer.metrics.reporting.ConsoleReporter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class MetricsUtil {
  protected MetricsUtil() {}

  public static void dumpToStdout() {
    dumpToStdout(Metrics.defaultRegistry());
  }

  public static void dumpToStdout(MetricsRegistry metrics) {
    dumpToStream(Metrics.defaultRegistry(), System.out);
  }

  public static void dumpToStderr() {
    dumpToStderr(Metrics.defaultRegistry());
  }

  public static void dumpToStderr(MetricsRegistry metrics) {
    dumpToStream(metrics, System.err);
  }

  public static void dumpToStream(MetricsRegistry metrics, PrintStream out) {
    new ConsoleReporter(metrics, out, MetricPredicate.ALL).run();
  }

  public static void dumpToFile(String path) throws FileNotFoundException {
    dumpToFile(Metrics.defaultRegistry(), path);
  }

  public static void dumpToFile(MetricsRegistry metrics, String path)
      throws FileNotFoundException {
    dumpToStream(metrics, new PrintStream(new FileOutputStream(path)));
  }
}
