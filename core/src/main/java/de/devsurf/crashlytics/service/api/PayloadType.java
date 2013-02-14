package de.devsurf.crashlytics.service.api;

import org.codehaus.jackson.annotate.JsonCreator;


public enum PayloadType {
	ISSUE("issue"),
	NONE("none");
	private String representation;

	private PayloadType(String representation) {
		this.representation = representation;
	}

	public String getRepresentation() {
		return representation;
	}

	@JsonCreator
	public static PayloadType fromValue(String representation) {
		switch (representation) {
		case "issue":
			return ISSUE;
		default:
			return NONE;
		}
	}
}