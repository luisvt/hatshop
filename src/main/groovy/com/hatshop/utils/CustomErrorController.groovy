package com.hatshop.utils

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.web.ErrorAttributes
import org.springframework.boot.autoconfigure.web.ErrorController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.ServletRequestAttributes

import javax.servlet.http.HttpServletRequest

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
    ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> body = getErrorAttributes(request, getTraceParameter(request))
        HttpStatus status = getStatus(request)
        return new ResponseEntity<Map<String, Object>>(body, status)
    }

    /**
     * Returns the path of the error page.
     *
     * @return the error path
     */
    @Override
    String getErrorPath() {
        return '/error'
    }


    private static boolean getTraceParameter(HttpServletRequest request) {
        "false" != request.getParameter("trace")?.toLowerCase()
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request,
                                                   boolean includeStackTrace) {
        def requestAttributes = new ServletRequestAttributes(request)
        return this.errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace)
    }

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