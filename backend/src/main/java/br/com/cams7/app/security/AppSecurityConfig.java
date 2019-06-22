/**
 * 
 */
package br.com.cams7.app.security;

import static br.com.cams7.app.security.SecurityConstants.LOGIN_URL;
import static br.com.cams7.app.security.SecurityConstants.SIGNUP_URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author cams7
 *
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService service;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// @formatter:off
		httpSecurity
			/*.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues()).and()*/
			.csrf().disable()
			.authorizeRequests()
			.antMatchers(HttpMethod.POST, LOGIN_URL).permitAll()
			.antMatchers(HttpMethod.GET, SIGNUP_URL).permitAll()
			//.antMatchers(HttpMethod.GET, "/home").permitAll()
			.anyRequest().authenticated()
			.and()
			// filtra requisições de login
			.addFilterBefore(new JWTAuthenticationFilter(LOGIN_URL, authenticationManager()),UsernamePasswordAuthenticationFilter.class)			
			// filtra outras requisições para verificar a presença do JWT no header
			.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
		// @formatter:on
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// @formatter:off
		web.ignoring().antMatchers(
			"/v2/api-docs", 
			"/configuration/ui", 
			"/swagger-resources/**", 
			"/configuration/**", 
			"/swagger-ui.html", 
			"/webjars/**"
		);
		// @formatter:on
	}

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
	}
}
