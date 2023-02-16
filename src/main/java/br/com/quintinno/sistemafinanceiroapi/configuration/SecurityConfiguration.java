package br.com.quintinno.sistemafinanceiroapi.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.httpBasic().and().authorizeHttpRequests().anyRequest().authenticated().and().csrf().disable();
	}

}
