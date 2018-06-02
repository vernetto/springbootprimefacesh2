package org.pierre.pvjoinfacestest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Spring Security Configuration.
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfigurerAdapter.class);

	@Override
	protected void configure(HttpSecurity http) {
		try {
			http.csrf().disable();
			http.userDetailsService(userDetailsService()).authorizeRequests().antMatchers("/").permitAll()
					.antMatchers("/**.jsf").permitAll().antMatchers("/javax.faces.resource/**").permitAll().anyRequest()
					.authenticated().and().formLogin().loginPage("/login.jsf").permitAll()
					.failureUrl("/login.jsf?error=true").defaultSuccessUrl("/index.jsf").and().logout()
					.logoutSuccessUrl("/login.jsf");
			http.headers().frameOptions().disable();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		logger.debug("PV successfully configured security");
	}

	@Override
	protected UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager result = new InMemoryUserDetailsManager();
		result.createUser(User.withDefaultPasswordEncoder().username("admin").password("admin123")
				.authorities("ROLE_ADMIN").build());
		result.createUser(User.withDefaultPasswordEncoder().username("user").password("user123")
				.authorities("ROLE_USER").build());
		return result;
	}
}
