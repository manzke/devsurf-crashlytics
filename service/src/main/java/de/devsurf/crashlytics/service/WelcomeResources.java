package de.devsurf.crashlytics.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.core.ResourceContext;

/** The main entry point for this REST interface. */
@Path("/")
public class WelcomeResources {

	@Context
	ResourceContext rc;

	/**
	 * Shows a welcome message as String with all possible endpoints.
	 *
	 * @return a welcome message as String with all possible endpoints.
	 */
	@GET
	@Produces({MediaType.TEXT_PLAIN, MediaType.TEXT_HTML, MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String welcome() {
		return "Welcome to the crashlytics webhook application.";
	}

	@Path("/webhook")
	public WebHookResource getWebHook() {
		return rc.getResource(WebHookResource.class);
	}
}
