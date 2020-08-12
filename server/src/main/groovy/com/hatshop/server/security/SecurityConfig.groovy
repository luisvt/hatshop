package com.hatshop.server.security

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.csrf.CsrfFilter
import org.springframework.security.web.csrf.CsrfToken
import org.springframework.security.web.csrf.CsrfTokenRepository
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.web.util.WebUtils

import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import static org.springframework.http.HttpMethod.GET

@Configuration
class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final LOGGER = LoggerFactory.getLogger(SecurityConfig.class)

    @Autowired
    private UserDetailsService userDetailsService

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        LOGGER.debug('configuring AuthenticationManagerBuilder')
        auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(new BCryptPasswordEncoder())
    }

    @Autowired
    Environment environment

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        LOGGER.debug('configuring HttpSecurity')
//        http.authorizeRequests()
//            .antMatchers("/", "/index.html", '/views/**', "/styles/**", "/scripts/**", "/fonts/**")
//            .permitAll()
//            .antMatchers(GET, "/products/**", '/departments/**', '/categories/**').permitAll()
//            .anyRequest().authenticated()
//            .and().httpBasic()
//            // next 3 lines are added to avoid sending back `WWW-AUTHENTICATION` header
//            // this header is responsible of showing base-auth login popup in the browser.
//            .authenticationEntryPoint({ req, res, authException ->
//                res.sendError(HttpServletResponse.SC_UNAUTHORIZED)
//            })
//            .and().csrf().csrfTokenRepository(csrfTokenRepository())
//            .and().addFilterAfter(csrfHeaderFilter(), CsrfFilter)
    }

    private static Filter csrfHeaderFilter() {
        return new OncePerRequestFilter() {
            @Override
            protected void doFilterInternal(HttpServletRequest request,
                                            HttpServletResponse response, FilterChain filterChain)
                    throws ServletException, IOException {
                def csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName())
                if (csrf != null) {
                    def cookie = WebUtils.getCookie(request, "XSRF-TOKEN")
                    String token = csrf.getToken()
                    if (cookie == null || token != null
                            && token != cookie.getValue()) {
                        cookie = new Cookie("XSRF-TOKEN", token)
                        cookie.setPath("/")
                        response.addCookie(cookie)
                    }
                }
                filterChain.doFilter(request, response)
            }
        }
    }

    private static CsrfTokenRepository csrfTokenRepository() {
        def repository = new HttpSessionCsrfTokenRepository()
        repository.setHeaderName("X-XSRF-TOKEN")
        repository
    }
}
