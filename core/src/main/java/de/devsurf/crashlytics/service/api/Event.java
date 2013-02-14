package de.devsurf.crashlytics.service.api;

public enum Event {
	VERIFICATION("verification"), 
	ISSUE_IMPACT_CHANGE("issue_impact_change"), 
	UNKNOWN("unknown");

	private String representation;

	private Event(String representation) {
		this.representation = representation;
	}

	public String getRepresentation() {
		return representation;
	}

	public static Event fromValue(String representation) {
		switch (representation) {
		case "verification":
			return VERIFICATION;
		case "issue_impact_change":
			return ISSUE_IMPACT_CHANGE;
		default:
			return UNKNOWN;
		}
	}
}