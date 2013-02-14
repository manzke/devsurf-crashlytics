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

import java.net.URL;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Payload {
	@JsonProperty("display_id")
	private String displayId;
	@JsonProperty
	private String library;
	@JsonProperty
	private String title;
	@JsonProperty("impact_level")
	private int impactLevel;
	@JsonProperty
	private String method;
	@JsonProperty("crashes_count")
	private long crashesCount;
	@JsonProperty("impacted_devices_count")
	private long impactedDevicesCount; 
	@JsonProperty("app")
	private App app;
	@JsonProperty("url")
	private URL link;

	protected Payload() {
	}

	public final String getDisplayId() {
		return displayId;
	}

	public final String getTitle() {
		return title;
	}

	public final String getMethod() {
		return method;
	}

	public final int getImpactLevel() {
		return impactLevel;
	}

	public final long getCrashesCount() {
		return crashesCount;
	}

	public final long getImpactedDevicesCount() {
		return impactedDevicesCount;
	}
	
	public App getApp() {
		return app;
	}
	
	public String getLibrary() {
		return library;
	}

	public final URL getLink() {
		return link;
	}

	protected final void setDisplayId(String displayId) {
		this.displayId = displayId;
	}

	protected final void setTitle(String title) {
		this.title = title;
	}

	protected final void setMethod(String method) {
		this.method = method;
	}

	protected final void setImpactLevel(int impactLevel) {
		this.impactLevel = impactLevel;
	}

	protected final void setCrashesCount(long crashesCount) {
		this.crashesCount = crashesCount;
	}

	protected final void setImpactedDevicesCount(long impactedDevicesCount) {
		this.impactedDevicesCount = impactedDevicesCount;
	}

	protected final void setLink(URL link) {
		this.link = link;
	}
	
	protected final void setApp(App app) {
		this.app = app;
	}
	
	protected final void setLibrary(String library) {
		this.library = library;
	}

	@Override
	public String toString() {
		return "Payload ["
				+ (displayId != null ? "displayId=" + displayId + ", " : "")
				+ (library != null ? "library=" + library + ", " : "")
				+ (title != null ? "title=" + title + ", " : "")
				+ "impactLevel=" + impactLevel + ", "
				+ (method != null ? "method=" + method + ", " : "")
				+ "crashesCount=" + crashesCount + ", impactedDevicesCount="
				+ impactedDevicesCount + ", "
				+ (app != null ? "app=" + app + ", " : "")
				+ (link != null ? "link=" + link : "") + "]";
	}
}