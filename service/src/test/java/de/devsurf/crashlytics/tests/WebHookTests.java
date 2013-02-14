/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.devsurf.crashlytics.tests;

import javax.ws.rs.core.Response;

import org.junit.Test;

public class WebHookTests extends RestTestBase {
	@Test
	public void testVerification() throws Exception {
		String json = "{" +
					  "\"event\": \"verification\"," +
					  "\"payload_type\": \"none\"" +
					  "}";
		performPost(WEBHOOK_PATH, json, Response.Status.OK);
	}
	
	@Test
	public void testIssue() throws Exception {
		String json = "{" + 
					  "\"event\": \"issue_impact_change\"," +
					  "\"payload_type\": \"issue\"," +
					  "\"payload\": {" +
					  "\"display_id\": 123," +
					  "\"title\": \"Issue Title\" ," +
					  "\"method\": \"methodName of issue\"," +
					  "\"impact_level\": 2," +
					  "\"crashes_count\": 54," +
					  "\"impacted_devices_count\": 16," +
					  "\"url\": \"http://crashlytics.com/full/url/to/issue\"" +
					  "}}";
		performPost(WEBHOOK_PATH, json, Response.Status.OK);
	}
}
