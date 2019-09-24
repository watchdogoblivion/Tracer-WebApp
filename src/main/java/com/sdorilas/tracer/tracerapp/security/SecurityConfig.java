package com.sdorilas.tracer.tracerapp.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.sdorilas.tracer.tracerapp.repositories.UserRepository;
import com.sdorilas.tracer.tracerapp.services.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	CustomPasswordEncoder customPasswordEncoder;
	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	DataSource dataSource;
	@Autowired
	public UserRepository userRepository;
	String auth_code = "]R]4}@x&?UHc2,YNMB<4mV!;^=q3Z-RQ";

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider())
		.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
		.authoritiesByUsernameQuery("select username, authority " + "from authorities where username=?")
		;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/home").hasAnyAuthority("ADMIN")
				.antMatchers("/AskQuestion").hasAnyAuthority("ADMIN", "USER")
				.antMatchers("/AnswerQuestion").hasAnyAuthority("ADMIN", "USER")
				.and()
				.formLogin().loginPage("/Login")
				.defaultSuccessUrl("/").failureUrl("/Login?error=true").permitAll()
				.and()
				.logout().clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/Logout").deleteCookies("JSESSIONID").invalidateHttpSession(true);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}
}
