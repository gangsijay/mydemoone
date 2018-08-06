package com.two.lgums.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.two.core.security.authorize.AuthorizeConfigManager;

/**
 * 功能描述: ${description}
 *
 **/
@Configuration
public class AuthWebSecurityConfig  extends WebSecurityConfigurerAdapter {
    @Autowired
    protected  ArtUserDetailsService myUserDetailsService;

    @Autowired
    AuthorizeConfigManager authorizeConfigManager;
    
    @Bean
    protected BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

		http.formLogin().loginPage("/login")
		.loginProcessingUrl("/loginProcess")
                .successForwardUrl("/loginSuccess")
                .failureForwardUrl("/fail")
		.and().authorizeRequests()
		.antMatchers("/login","/loginProcess","/loginSuccess","/fail").permitAll()
		.and().csrf().disable().headers().frameOptions().disable();
        authorizeConfigManager.config(http.authorizeRequests());
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
    }
}
