package com.employee.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.employee.controller.StudentController;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class);

	
	/*
	 * @Bean PasswordEncoder getEncoder() { return new BCryptPasswordEncoder(); }
	 */
	@Autowired
	AccessDeniedHandler accessDeniedHandler;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		logger.trace("INFO LOGGER from SecurityConfiguration");
		logger.debug("DEBUG LOGGER from SecurityConfiguration");
		logger.info("INFO LOGGER from SecurityConfiguration");
		logger.warn("WARN LOGGER from SecurityConfiguration");
		logger.error("ERROR LOGGER from SecurityConfiguration");
		
		
		http.authorizeRequests()
		.antMatchers("/getUserName").permitAll()
		.antMatchers("/getPassword").hasRole("ADMIN")
		.antMatchers("/getClientId").hasRole("USER")
		.anyRequest().permitAll() // commenting this also same. allowing all the non ant matcher urls without auth
		//.anyRequest().authenticated() // This will make all the URLs to get authenticated.  - Any role cred will be working
		.and()
		.formLogin()// we can give customised form as well
		.and()
		.csrf().disable()
		.exceptionHandling()
		.accessDeniedHandler(accessDeniedHandler);
		
	}
	/*
	 * @Autowired PasswordEncoder passwordEncoder;
	 */
	
	// it will redirect to login page for authentication for the given URLs with non permitAll.
	// If we give incorrect username pwd, it will throw bad credential. 
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * 
	 * PasswordEncoder encoder =
	 * PasswordEncoderFactories.createDelegatingPasswordEncoder();
	 * 
	 * 
	 * auth.inMemoryAuthentication()
	 * .withUser("manoj").password(encoder.encode("manojpwd")).roles("ADMIN") // we
	 * can use {noop}manojpwd as well if we dint want to encode the pwd. .and()
	 * .withUser("mark").password(encoder.encode("markpwd")).roles("USER") .and()
	 * .withUser("testuser").password(encoder.encode("testpwd")).roles("TEMP"); }
	 */
	
	// JDBC based auth
	/*
	 * auth.jdbcAuthentication() .dataSource(dataSource)
	 * .usersByUsernameQuery(userbyUsernameQuery)
	 * .authoritiesByUsernameQuery(rolebyUsernameQuery)
	 * .passwordEncoder(passwordEncoder());
	 */
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		
		auth.inMemoryAuthentication()/* .passwordEncoder(encoder) */
		.withUser("manoj").password(encoder.encode("manojpwd")).roles("ADMIN") // we can use {noop}manojpwd as well if we dint want to encode the pwd. 
		.and()
		.withUser("mark").password(encoder.encode("markpwd")).roles("USER")
		.and()
		.withUser("testuser").password(encoder.encode("testpwd")).roles("TEMP");
	}
}
