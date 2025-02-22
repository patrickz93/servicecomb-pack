/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.servicecomb.pack.alpha.fsm.channel;

import java.lang.invoke.MethodHandles;
import org.apache.servicecomb.pack.alpha.fsm.event.base.BaseEvent;
import org.apache.servicecomb.pack.alpha.fsm.metrics.MetricsService;
import org.apache.servicecomb.pack.alpha.fsm.sink.ActorEventSink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Queue
 * */

public class ActiveMQActorEventChannel extends AbstractActorEventChannel {
  private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  public ActiveMQActorEventChannel(
      ActorEventSink actorEventSink, MetricsService metricsService) {
    super(actorEventSink, metricsService);
  }

  @Override
  public void sendTo(BaseEvent event){
    throw new UnsupportedOperationException("Doesn't implement yet!");
  }
}
