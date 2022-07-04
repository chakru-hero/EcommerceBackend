package com.portfolio.chakru.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig {

	private final PasswordEncoder passwordEncoder;

	@Autowired
	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {

		this.passwordEncoder = passwordEncoder;
	}

//	@Autowired
//	private UserModel userModel;

//	private DataSource datasource;

	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/", "index", "/css/*", "/js/*").permitAll().anyRequest()
				.authenticated().and().httpBasic();
		// .formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/home/all",
		// true);

		return http.build();
	}

	@Bean
	protected UserDetailsService userDetailsService(/* DataSource datasource */) {
		UserDetails adminuser = User.builder().username("adminuser").password(passwordEncoder.encode("password"))
				.roles("ADMIN").build();
//	JdbcUserDetailsManager users = new JdbcUserDetailsManager(datasource);
//	users.createUser(user);
//	return users;
		UserDetails user = User.builder().username("user").password(passwordEncoder.encode("password")).roles("USER").build();

		return new InMemoryUserDetailsManager(adminuser, user);

	}

	@Bean
	protected WebSecurityCustomizer webSecurityCustomizer() {
		return null;
	}
}
