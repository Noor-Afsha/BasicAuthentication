package com.example.noor.noorSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringConfig {

	// by using we can encode our password
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails admin = User.builder().username("noor").password(passwordEncoder().encode("noor@123"))
				.roles("admin").build();
		UserDetails user = User.builder().username("afsha").password(passwordEncoder().encode("noor@1234"))
				.roles("user").build();

		// i need to store it temporary:-

		// this will store temporary
		return new InMemoryUserDetailsManager(admin, user);
	}

	// checking the security filter method that which type of request is coming

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

		// csrf is a type of attacker
		return httpSecurity.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults()).build();
	}
}