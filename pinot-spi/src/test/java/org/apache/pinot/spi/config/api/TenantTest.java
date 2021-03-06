/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.pinot.spi.config.api;

import java.io.IOException;

import org.apache.pinot.spi.config.tenant.Tenant;
import org.apache.pinot.spi.config.tenant.TenantRole;
import org.apache.pinot.spi.utils.JsonUtils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class TenantTest {

  @Test
  public void testDeserializeFromJson()
      throws IOException {
    Tenant tenant = new Tenant(TenantRole.SERVER, "newTenant", 10, 5, 5);
    tenant = JsonUtils.stringToObject(JsonUtils.objectToString(tenant), Tenant.class);
    assertEquals(tenant.getTenantRole(), TenantRole.SERVER);
    assertEquals(tenant.getTenantName(), "newTenant");
    assertEquals(tenant.getNumberOfInstances(), 10);
    assertEquals(tenant.getOfflineInstances(), 5);
    assertEquals(tenant.getRealtimeInstances(), 5);
  }
}
