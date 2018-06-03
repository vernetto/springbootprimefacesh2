package org.pierre.pvjoinfacestest;

import javax.inject.Inject;

import org.littleshoot.proxy.HttpProxyServer;
import org.littleshoot.proxy.impl.DefaultHttpProxyServer;
import org.pierre.mavenfilter.MavenFilter;
import org.pierre.mavenfilter.MavenFilterConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableConfigurationProperties(MavenFilterConfiguration.class)
public class PVJoinFacesTestApplication extends SpringBootServletInitializer implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(PVJoinFacesTestApplication.class);
	
	@Inject
	MavenFilterConfiguration properties ;

	public static void main(String[] args) {
		SpringApplication.run(PVJoinFacesTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.debug("PV creating HttpProxyServer on port " + properties.getPort());
		
		HttpProxyServer server = DefaultHttpProxyServer.bootstrap().withPort(Integer.parseInt(properties.getPort())).withFiltersSource(new MavenFilter())
				.start();
		logger.debug("PV done with creating HttpProxyServer");

	}

	public MavenFilterConfiguration getProperties() {
		return properties;
	}

	public void setProperties(MavenFilterConfiguration properties) {
		this.properties = properties;
	}
	
	

}
