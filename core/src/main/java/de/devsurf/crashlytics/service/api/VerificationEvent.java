package de.devsurf.crashlytics.service.api;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VerificationEvent extends WebHookEvent {
	protected VerificationEvent() {
		super(Event.VERIFICATION, PayloadType.NONE);
	}

	@Override
	public String toString() {
		return "VerificationEvent ["
				+ (event != null ? "event=" + event + ", " : "")
				+ (payloadType != null ? "payloadType=" + payloadType : "")
				+ "]";
	}
}