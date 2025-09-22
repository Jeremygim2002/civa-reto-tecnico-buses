package com.civa.retotecnico.buses.bus_api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Main application class for the Bus Management API
 * 
 * This Spring Boot application provides a REST API for managing buses and brands
 * with features including:
 * - Read-only operations (GET endpoints)
 * - Pagination and sorting support
 * - HTTP Basic Authentication
 * - CORS configuration for frontend integration
 * - OpenAPI/Swagger documentation
 * - PostgreSQL database integration
 * 
 * @author Bus API Team
 * @version 1.0.0
 */
@SpringBootApplication
public class BusApiApplication {

	private static final Logger logger = LoggerFactory.getLogger(BusApiApplication.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BusApiApplication.class);
		Environment env = app.run(args).getEnvironment();
		
		logApplicationStartup(env);
	}

	/**
	 * Log application startup information
	 */
	private static void logApplicationStartup(Environment env) {
		String protocol = "http";
		if (env.getProperty("server.ssl.key-store") != null) {
			protocol = "https";
		}
		
		String serverPort = env.getProperty("server.port", "8080");
		String contextPath = env.getProperty("server.servlet.context-path", "");
		String hostAddress = "localhost";
		
		try {
			hostAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			logger.warn("Unable to determine host address");
		}
		
		logger.info("""
			
			----------------------------------------------------------
			\tApplication '{}' is running! Access URLs:
			\tLocal: \t\t{}://localhost:{}{}
			\tExternal: \t{}://{}:{}{}
			\tSwagger UI: \t{}://localhost:{}{}/swagger-ui
			\tAPI Docs: \t{}://localhost:{}{}/api-docs
			\tProfile(s): \t{}
			----------------------------------------------------------
			""",
			env.getProperty("spring.application.name", "Bus API"),
			protocol, serverPort, contextPath,
			protocol, hostAddress, serverPort, contextPath,
			protocol, serverPort, contextPath,
			protocol, serverPort, contextPath,
			env.getActiveProfiles().length == 0 ? "default" : String.join(", ", env.getActiveProfiles())
		);
	}
}
