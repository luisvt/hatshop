package com.hatshop.server.security

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.csrf.CookieCsrfTokenRepository

import static org.springframework.http.HttpMethod.GET

@Configuration
class SecurityConfig extends WebSecurityConfigurerAdapter {
  private static final LOGGER = LoggerFactory.getLogger(SecurityConfig.class)

  @Autowired
  private UserDetailsService userDetailsService

  @Bean
  BCryptPasswordEncoder passwordEncoder() { new BCryptPasswordEncoder() }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    LOGGER.debug('configuring AuthenticationManagerBuilder')
    auth
      .userDetailsService(userDetailsService)
      .passwordEncoder(passwordEncoder())
  }

  @Autowired
  Environment environment

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    LOGGER.debug('configuring HttpSecurity')
    http.authorizeRequests()
      .antMatchers('/*', '/assets/**', '/fonts/**').permitAll()
      .antMatchers(GET, "/api/products/**", '/api/departments/**', '/api/categories/**').permitAll()
      .antMatchers('/api/session-user').authenticated()
      .antMatchers('/api/**').hasRole('ADMIN')
    http.httpBasic()
      .and().logout().logoutUrl('/api/logout')
      .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())

    http.authorizeRequests()
      .antMatchers('/h2-console/**').permitAll()
    http.headers().frameOptions().disable()
    http.csrf().ignoringAntMatchers('/h2-console/**')
  }
}
