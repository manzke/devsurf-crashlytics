package de.devsurf.crashlytics.service.guice;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

import de.devsurf.crashlytics.service.Constants;

/**
 * This context listener wires the Google Guice and Jersey frameworks together. As a result, both
 * injection methods can be used.
 */
public class GuiceJerseyContextListener extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new JerseyServletModule() {

			@Override
			protected void configureServlets() {
				// Use jersey class path scanning
				Map<String, String> params = new HashMap<String, String>();
				params.put(PackagesResourceConfig.PROPERTY_PACKAGES, Constants.REST_PACKAGE);

				// json mapping via jackson
				params.put(JSONConfiguration.FEATURE_POJO_MAPPING, "true");

				serve("/*").with(GuiceContainer.class, params);
			}
		});
	}
}
