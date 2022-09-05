package com.checkIn.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.checkIn.api.services.PassUserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	private PassUserDetailsService passUserDetailsService;
	
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	
	//it allows web based security for specific http request
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.POST,"/checkin").permitAll()//antMatchers->use to configure the URL paths
		.antMatchers(HttpMethod.GET,"/checkinhost").authenticated()
		.antMatchers(HttpMethod.GET,"/checkin").permitAll().and()
			.csrf() //that forces user to execute unwanted actions
			.disable()
			.cors() //restricting the resources implemented in web browser
			.disable()
			.authorizeRequests()
			.antMatchers("/token").permitAll()
			.anyRequest().permitAll()
			.and()
			//stateless is one that does not save client data generated in one session
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	// here  we define which type of authentication we will use
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(passUserDetailsService);	
		//userDetailsService-> it is an interface,used to retrive user related data
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
