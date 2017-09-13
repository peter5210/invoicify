package com.libertymutual.goforcode.invoicify.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.libertymutual.goforcode.invoicify.services.InvoicifyUserDetailsService;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private InvoicifyUserDetailsService UserDetailsService;
	
	 public SecurityConfiguration(InvoicifyUserDetailsService UserDetailsService) {
		this.UserDetailsService = UserDetailsService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests().antMatchers("/", "/css/**", "/js/**", "/signup").permitAll()
				.antMatchers("/invoices/**")
					.hasAnyRole("ADMIN", "ACCOUNTANT")
				.antMatchers("/billing-records/**")
					.hasAnyRole("ADMIN", "CLERK")
				.antMatchers("/admin/**")
					.hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
				.formLogin();
	}
	
	@Bean
	public PasswordEncoder passwordEncorder() {
		return new BCryptPasswordEncoder();
	}

	public UserDetailsService userDetailService() {
		return UserDetailsService;
	}
}
