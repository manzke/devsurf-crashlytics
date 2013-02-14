package de.devsurf.crashlytics.service.api;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class IssueEvent extends WebHookEvent {
	private Payload payload;
	
	protected IssueEvent() {
		super(Event.ISSUE_IMPACT_CHANGE, PayloadType.ISSUE);
	}

	public final Payload getPayload() {
		return payload;
	}

	protected final void setPayload(Payload payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "IssueEvent ["
				+ (payload != null ? "payload=" + payload + ", " : "")
				+ (event != null ? "event=" + event + ", " : "")
				+ (payloadType != null ? "payloadType=" + payloadType : "")
				+ "]";
	}
}