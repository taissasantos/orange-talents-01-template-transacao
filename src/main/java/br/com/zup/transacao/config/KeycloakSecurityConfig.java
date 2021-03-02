package br.com.zup.transacao.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

public class KeycloakSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests(authorize ->
		authorize
		.antMatchers(HttpMethod.GET,"/api/transacao/**").hasAuthority("SCOPE_transacao:read")
		.antMatchers(HttpMethod.GET,"/api/transacao/**").hasAuthority("SCOPE_transacao:write")
		.anyRequest().authenticated())
		.csrf().disable()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
	}

}
