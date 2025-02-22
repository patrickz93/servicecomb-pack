/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.servicecomb.pack.omega.transaction;

import org.apache.servicecomb.pack.omega.context.OmegaContext;
import org.apache.servicecomb.pack.omega.transaction.annotations.Compensable;
import org.apache.servicecomb.pack.omega.transaction.wrapper.RecoveryPolicyTimeoutWrapper;
import org.aspectj.lang.ProceedingJoinPoint;

public abstract class AbstractRecoveryPolicy implements RecoveryPolicy {

  public abstract Object applyTo(ProceedingJoinPoint joinPoint, Compensable compensable,
      CompensableInterceptor interceptor, OmegaContext context, String parentTxId, int retries)
      throws Throwable;

  @Override
  public Object apply(ProceedingJoinPoint joinPoint, Compensable compensable,
      CompensableInterceptor interceptor, OmegaContext context, String parentTxId, int retries)
      throws Throwable {
    if(compensable.timeout()>0){
      RecoveryPolicyTimeoutWrapper wrapper = new RecoveryPolicyTimeoutWrapper(this);
      return wrapper.applyTo(joinPoint, compensable, interceptor, context, parentTxId, retries);
    }else{
      return this.applyTo(joinPoint, compensable, interceptor, context, parentTxId, retries);
    }
  }
}
