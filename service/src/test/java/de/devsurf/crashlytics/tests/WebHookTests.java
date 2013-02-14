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
