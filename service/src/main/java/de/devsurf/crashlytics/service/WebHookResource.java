package de.devsurf.crashlytics.service;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.spi.resource.Singleton;

import de.devsurf.crashlytics.service.api.WebHookEvent;

@Singleton
public class WebHookResource {
	@Context
	protected UriInfo uriInfo;

	@Context
	protected HttpServletRequest request;

	protected static final Logger LOGGER = LoggerFactory.getLogger(WebHookResource.class);

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String call(WebHookEvent event) {
		System.out.println(event);

		return "jersey-system-08.11.2012";
	}
}
