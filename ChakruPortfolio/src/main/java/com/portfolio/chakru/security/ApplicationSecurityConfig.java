//package com.portfolio.chakru.security;
//
//import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(
//		// securedEnabled = true,
//		// jsr250Enabled = true,
//		prePostEnabled = true)
//public class ApplicationSecurityConfig {
////	@Autowired
////	private final UserDetailsService userDetailsService;
////	@Autowired
////	private final PasswordEncoder passwordEncoder;
////
////
////
////	public UserDetailsService getUserDetailsService() {
////		return userDetailsService;
////	}
////
////
////
////	public PasswordEncoder getPasswordEncoder() {
////		return passwordEncoder;
////	}
//
//
//
//	@Bean
//	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////		http.csrf().disable()
////		.authorizeRequests()
////		.antMatchers("/", "index", "/css/*", "/js/*")
////		.permitAll()
////		.anyRequest()
////		.authenticated()
////		.and()
////		.httpBasic();
////		 .formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/home/all",
////		 true);
//
//		http.sessionManagement().sessionCreationPolicy(STATELESS);
//		http.authorizeRequests().antMatchers("/", "index", "/css/*", "/js/*").permitAll();
//		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
//				.defaultSuccessUrl("/p", true);
//		
//		return http.build();
//	}
////
////	@Bean
////	protected UserDetailsService userDetailsService(/* DataSource datasource */) {
////		UserDetails adminuser = User.builder().username("adminuser").password(passwordEncoder.encode("password"))
////				.roles("ADMIN").build();
//////	JdbcUserDetailsManager users = new JdbcUserDetailsManager(datasource);
//////	users.createUser(user);
//////	return users;
////		UserDetails user = User.builder().username("user").password(passwordEncoder.encode("password")).roles("USER")
////				.build();
////
////		return new InMemoryUserDetailsManager(adminuser, user);
////
////	}
////
//	@Bean
//	protected WebSecurityCustomizer webSecurityCustomizer() {
//		return null;
//	}
//}
