package gov.psm.secondary.service;

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
public class SecondaryServiceApplication extends SpringBootServletInitializer {

	private static final Logger PSM_LOGGER = LoggerFactory.getLogger(SecondaryServiceApplication.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SecondaryServiceApplication.class);
	}

	public static void main(String[] args) {
		PSM_LOGGER.debug("SecondaryServiceApplication.main");
		setEmbeddedContainerEnvironmentProperties();
		SpringApplication.run(SecondaryServiceApplication.class, args);
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		PSM_LOGGER.debug("SecondaryServiceApplication.onStartup");
		setExternalContainerEnvironmentProperties();
		super.onStartup(servletContext);
	}

	private static void setEmbeddedContainerEnvironmentProperties() {
		PSM_LOGGER.debug("SecondaryServiceApplication.setEmbeddedContainerEnvironment");
		setEnvironmentProperties();
		System.setProperty("server.context-path", "/secondarySvc");
	}

	private static void setExternalContainerEnvironmentProperties() {
		PSM_LOGGER.debug("SecondaryServiceApplication.setExternalContainterEnvironmentProperties");
		setEnvironmentProperties();
	}

	private static void setEnvironmentProperties() {
		PSM_LOGGER.debug("SecondaryServiceApplication.setExternalContainterEnvironmentProperties");
		System.setProperty("spring.config.name", "secondarySvc");
	}

}