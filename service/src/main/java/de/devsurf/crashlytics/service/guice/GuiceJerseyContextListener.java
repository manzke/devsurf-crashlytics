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
package de.devsurf.crashlytics.service.guice;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

import de.devsurf.crashlytics.service.Constants;

/**
 * This context listener wires the Google Guice and Jersey frameworks together. As a result, both
 * injection methods can be used.
 */
public class GuiceJerseyContextListener extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new JerseyServletModule() {

			@Override
			protected void configureServlets() {
				// Use jersey class path scanning
				Map<String, String> params = new HashMap<String, String>();
				params.put(PackagesResourceConfig.PROPERTY_PACKAGES, Constants.REST_PACKAGE);
				
				// jersey request filters
				StringBuilder requestFilters = new StringBuilder();
				requestFilters
							.append("com.sun.jersey.api.container.filter.LoggingFilter");

				params.put(ResourceConfig.PROPERTY_CONTAINER_REQUEST_FILTERS,
						requestFilters.toString());
				
				params.put("com.sun.jersey.config.feature.logging.DisableEntitylogging",
						Boolean.toString(false));

				// json mapping via jackson
				params.put(JSONConfiguration.FEATURE_POJO_MAPPING, "true");

				serve("/*").with(GuiceContainer.class, params);
			}
		});
	}
}
