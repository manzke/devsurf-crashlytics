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
package de.devsurf.crashlytics.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.core.ResourceContext;

/** The main entry point for this REST interface. */
@Path("/")
public class WelcomeResources {

	@Context
	ResourceContext rc;

	/**
	 * Shows a welcome message as String with all possible endpoints.
	 *
	 * @return a welcome message as String with all possible endpoints.
	 */
	@GET
	@Produces({MediaType.TEXT_PLAIN, MediaType.TEXT_HTML, MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String welcome() {
		return "Welcome to the crashlytics webhook application.";
	}

	@Path("/webhook")
	public WebHookResource getWebHook() {
		return rc.getResource(WebHookResource.class);
	}
}
