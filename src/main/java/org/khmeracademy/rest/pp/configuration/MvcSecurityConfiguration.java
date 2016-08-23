package org.khmeracademy.rest.pp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class MvcSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	@Qualifier("RESTAuthenticationEntryPoint")
	private RESTAuthenticationEntryPoint restAutentication;
	
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			// TODO Auto-generated method stub
			super.configure(auth);
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable();
			http.httpBasic()
				.authenticationEntryPoint(restAutentication);
		}
}
