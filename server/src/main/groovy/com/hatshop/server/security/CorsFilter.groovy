package com.hatshop.server.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component

import javax.servlet.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
@Profile('development')
class CorsFilter implements Filter {

  @Autowired
  Environment environment

  void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    HttpServletResponse response = (HttpServletResponse) res
    HttpServletRequest request = (HttpServletRequest) req
    response.setHeader("Access-Control-Allow-Origin", "*")
    response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE")
    response.setHeader("Access-Control-Max-Age", "3600")
    if (request.getMethod() != 'OPTIONS') {
      chain.doFilter(req, res)
    }
  }

  void init(FilterConfig filterConfig) {}

  void destroy() {}

}
