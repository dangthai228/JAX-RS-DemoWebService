package com.thaind.config;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;


@ApplicationPath("/rest/*")
public class JerseyServletContainerConfig extends ResourceConfig {
    public JerseyServletContainerConfig() {
        // if there are more than two packages then separate them with semicolon
        packages("com.thaind.api");
        register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), Level.INFO,
                LoggingFeature.Verbosity.PAYLOAD_ANY, 10000));
    }
}
