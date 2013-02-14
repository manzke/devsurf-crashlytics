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

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.spi.resource.Singleton;

import de.devsurf.crashlytics.service.api.WebHookEvent;

@Singleton
public class WebHookResource {
	@Context
	protected UriInfo uriInfo;

	@Context
	protected HttpServletRequest request;

	protected static final Logger LOGGER = LoggerFactory.getLogger(WebHookResource.class);

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void call(WebHookEvent event) {
		LOGGER.info("Received following event by crashlytics: "+event);
	}
}
