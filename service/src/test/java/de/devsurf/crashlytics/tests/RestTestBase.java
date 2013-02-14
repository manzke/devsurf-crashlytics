package de.devsurf.crashlytics.tests;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.StatusType;

import junit.framework.Assert;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.google.inject.servlet.GuiceFilter;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;

import de.devsurf.crashlytics.service.Constants;
import de.devsurf.crashlytics.service.guice.GuiceJerseyContextListener;

public class RestTestBase {

	private static JerseyTest jerseyTest;
	protected static String requestFilters = null;

	@BeforeClass
	public static void setUpServer() throws Exception {
			jerseyTest = new JerseyTest() {
				@Override
				public AppDescriptor configure() {
					WebAppDescriptor.Builder builder =
							new WebAppDescriptor.Builder(Constants.REST_PACKAGE)
									.contextListenerClass(GuiceJerseyContextListener.class)
									.filterClass(GuiceFilter.class);;

					return builder.build();
				}

				@Override
				public WebResource resource() {
					URI baseURI = super.getBaseURI();
					WebResource resource = client().resource(baseURI);
					return resource;
				}

				@Override
				public Client client() {
					ClientConfig clientConfig = new DefaultClientConfig();
					clientConfig.getClasses().add(JacksonJsonProvider.class);
					return Client.create(clientConfig);
				}
			};

			jerseyTest.setUp();
	}

	@AfterClass
	public static void tearDownServer() throws Exception {
		jerseyTest.tearDown();
	}

	/** Path to folders resource. */
	public static final String WEBHOOK_PATH = "webhook";

	public static final String METHOD_GET = "GET";
	public static final String METHOD_HEAD = "HEAD";
	public static final String METHOD_DELETE = "DELETE";
	public static final String METHOD_POST = "POST";
	public static final String METHOD_PUT = "PUT";

	public static final String PATH_SEPARATOR = "/";

	public ClientResponse performPost(String path, String json, StatusType status) {
		ClientResponse response =
				resource().path(path).entity(json, MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class);
		Assert.assertEquals(status.getStatusCode(), response.getStatus());
		return response;
	}

	protected WebResource resource() {
		return jerseyTest.resource();
	}
}
