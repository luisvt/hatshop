package com.hatshop.server.utils

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.error.ErrorAttributeOptions
import org.springframework.boot.web.servlet.error.ErrorAttributes
import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest

import javax.servlet.http.HttpServletRequest

import static org.springframework.boot.web.error.ErrorAttributeOptions.Include.STACK_TRACE

@RestController
class CustomErrorController implements ErrorController {

    /**
     * Error Attributes in the Application
     */
    @Autowired
    private ErrorAttributes errorAttributes

    /**
     * Supports other formats like JSON, XML
     * @param request
     * @return
     */
    @RequestMapping(value = '/error')
    ResponseEntity<Map<String, Object>> error(HttpServletRequest request, WebRequest webRequest) {
        Map<String, Object> body = errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.of(STACK_TRACE))
        HttpStatus status = getStatus(request)
        return new ResponseEntity<Map<String, Object>>(body, status)
    }

    /**
     * Returns the path of the error page.
     *
     * @return the error path
     */
    @Override
    String getErrorPath() { '/error' }


    private static HttpStatus getStatus(HttpServletRequest request) {
        def statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code")
        if (statusCode != null) {
            try {
                return HttpStatus.valueOf(statusCode)
            } catch (Exception ignored) {
            }
        }
        return HttpStatus.INTERNAL_SERVER_ERROR
    }
}
