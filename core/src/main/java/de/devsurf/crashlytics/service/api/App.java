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
package de.devsurf.crashlytics.service.api;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class App {
	@JsonProperty
	private String name;
	@JsonProperty("bundle_identifier")
	private String bundleIdentifier;

	protected App() {
	}

	public final String getName() {
		return name;
	}

	public final String getBundleIdentifier() {
		return bundleIdentifier;
	}

	protected final void setName(String name) {
		this.name = name;
	}

	protected final void setBundleIdentifier(String bundleIdentifier) {
		this.bundleIdentifier = bundleIdentifier;
	}

	@Override
	public String toString() {
		return "App ["
				+ (name != null ? "name=" + name + ", " : "")
				+ (bundleIdentifier != null ? "bundleIdentifier="
						+ bundleIdentifier : "") + "]";
	}
}