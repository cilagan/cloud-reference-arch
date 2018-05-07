package gov.psm.primary.service;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration.class })
public class PrimaryServiceApplication extends SpringBootServletInitializer {

	private static final Logger PSM_LOGGER = LoggerFactory.getLogger(PrimaryServiceApplication.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PrimaryServiceApplication.class);
	}

	public static void main(String[] args) {
		PSM_LOGGER.debug("PrimaryServiceApplication.main");
		setEmbeddedContainerEnvironmentProperties();
		SpringApplication.run(PrimaryServiceApplication.class, args);
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		PSM_LOGGER.debug("PrimaryServiceApplication.onStartup");
		setExternalContainerEnvironmentProperties();
		super.onStartup(servletContext);
	}

	private static void setEmbeddedContainerEnvironmentProperties() {
		PSM_LOGGER.debug("PrimaryServiceApplication.setEmbeddedContainerEnvironment");
		setEnvironmentProperties();
		System.setProperty("server.context-path", "/primarySvc");
	}

	private static void setExternalContainerEnvironmentProperties() {
		PSM_LOGGER.debug("PrimaryServiceApplication.setExternalContainterEnvironmentProperties");
		setEnvironmentProperties();
	}

	private static void setEnvironmentProperties() {
		PSM_LOGGER.debug("PrimaryServiceApplication.setExternalContainterEnvironmentProperties");
		System.setProperty("spring.config.name", "primarySvc");
	}

}