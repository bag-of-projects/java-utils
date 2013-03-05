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

import com.yammer.metrics.core.MetricName;
import com.yammer.metrics.core.MetricsRegistry;
import com.yammer.metrics.core.Timer;

import java.util.concurrent.TimeUnit;

/**
 * Description for Timers.
 */
public class TimerDesc {
  /** Name of timer */
  private final MetricName name;
  /** Duration unit for timer */
  private final TimeUnit durationUnit;
  /** Time unit for timer */
  private final TimeUnit rateUnit;

  /**
   * Constructor
   * @param name String name of timer
   * @param durationUnit Duration unit of timer
   * @param rateUnit Time unit of timer
   */
  public TimerDesc(MetricName name, TimeUnit durationUnit, TimeUnit rateUnit) {
    this.name = name;
    this.durationUnit = durationUnit;
    this.rateUnit = rateUnit;
  }

  /**
   * Constructor
   * @param klass Class for metric name
   * @param name String name of timer
   * @param durationUnit Duration unit of timer
   * @param rateUnit Time unit of timer
   */
  public TimerDesc(Class<?> klass, String name, TimeUnit durationUnit, TimeUnit rateUnit) {
    this.name = new MetricName(klass, name);
    this.durationUnit = durationUnit;
    this.rateUnit = rateUnit;
  }

  /**
   * Get duration unit of timer
   * @return TimeUnit
   */
  public final TimeUnit getDurationUnit() {
    return durationUnit;
  }

  /**
   * Get name of timer
   * @return String name
   */
  public final MetricName getName() {
    return name;
  }

  /**
   * Get time unit of timer
   * @return TimeUnit of timer
   */
  public final TimeUnit getRateUnit() {
    return rateUnit;
  }

  /**
   * Create Timer from this description
   * @param metrics MetricsRegistry to use
   * @return Timer
   */
  public final Timer newTimer(MetricsRegistry metrics) {
    return metrics.newTimer(name, durationUnit, rateUnit);
  }
}
