package org.pierre.pvjoinfacestest;

import org.littleshoot.proxy.HttpProxyServer;
import org.littleshoot.proxy.impl.DefaultHttpProxyServer;
import org.pierre.mavenfilter.MavenFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PVJoinFacesTestApplication extends SpringBootServletInitializer implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(PVJoinFacesTestApplication.class);
	@Value("${proxyport}")
	private String proxyport;

	public static void main(String[] args) {
		SpringApplication.run(PVJoinFacesTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.debug("PV creating HttpProxyServer");
		
		HttpProxyServer server = DefaultHttpProxyServer.bootstrap().withPort(Integer.parseInt(proxyport)).withFiltersSource(new MavenFilter())
				.start();
		logger.debug("PV done with creating HttpProxyServer");

	}

}
