package de.devsurf.crashlytics.service.api;

import java.net.URL;

import org.codehaus.jackson.annotate.JsonProperty;

public class Payload {
	@JsonProperty("display_id")
	private String displayId;
	@JsonProperty
	private String title;
	@JsonProperty
	private String method;
	@JsonProperty("impact_level")
	private int impactLevel;
	@JsonProperty("crashes_count")
	private long crashesCount;
	@JsonProperty("impacted_devices_count")
	private long impactedDevicesCount; 
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

	@Override
	public String toString() {
		return "Payload ["
				+ (displayId != null ? "displayId=" + displayId + ", " : "")
				+ (title != null ? "title=" + title + ", " : "")
				+ (method != null ? "method=" + method + ", " : "")
				+ "impactLevel=" + impactLevel + ", crashesCount="
				+ crashesCount + ", impactedDevicesCount="
				+ impactedDevicesCount + ", "
				+ (link != null ? "link=" + link : "") + "]";
	}
}