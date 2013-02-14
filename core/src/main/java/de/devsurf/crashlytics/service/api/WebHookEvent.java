package de.devsurf.crashlytics.service.api;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;


@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="event")
@JsonSubTypes({
        @Type(value = VerificationEvent.class, name = "verification"),
        @Type(value = IssueEvent.class, name = "issue_impact_change")})
public abstract class WebHookEvent {
	protected Event event;
	@JsonProperty("payload_type")
	protected PayloadType payloadType;
	
	protected WebHookEvent() {
		event = Event.UNKNOWN;
		payloadType = PayloadType.NONE;
	}
	
	protected WebHookEvent(Event event, PayloadType payloadType) {
		this.event = event;
		this.payloadType = payloadType;
	}

	public final Event getEvent() {
		return event;
	}

	protected final void setEvent(Event event) {
		this.event = event;
	}

	public final PayloadType getPayloadType() {
		return payloadType;
	}

	protected final void setPayloadType(PayloadType payloadType) {
		this.payloadType = payloadType;
	}
}