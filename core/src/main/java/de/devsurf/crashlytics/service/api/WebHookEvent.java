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