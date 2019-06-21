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

package org.apache.servicecomb.pack.alpha.fsm.event;

import org.apache.servicecomb.pack.alpha.fsm.event.base.TxEvent;

public class TxComponsitedEvent extends TxEvent {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {

    private TxComponsitedEvent txComponsitedEvent;

    private Builder() {
      txComponsitedEvent = new TxComponsitedEvent();
    }

    public Builder parentTxId(String parentTxId) {
      txComponsitedEvent.setParentTxId(parentTxId);
      return this;
    }

    public Builder localTxId(String localTxId) {
      txComponsitedEvent.setLocalTxId(localTxId);
      return this;
    }

    public Builder globalTxId(String globalTxId) {
      txComponsitedEvent.setGlobalTxId(globalTxId);
      return this;
    }

    public TxComponsitedEvent build() {
      return txComponsitedEvent;
    }
  }
}
