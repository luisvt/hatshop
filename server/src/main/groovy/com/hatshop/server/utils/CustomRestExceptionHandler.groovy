package com.hatshop.server.utils

import org.springframework.context.MessageSource
import org.springframework.data.rest.webmvc.RepositoryRestExceptionHandler
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.TransactionSystemException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

import javax.validation.ConstraintViolationException

@ControllerAdvice("com.hatshop.server")
class CustomRestExceptionHandler extends RepositoryRestExceptionHandler {
  CustomRestExceptionHandler(MessageSource messageSource) {
    super(messageSource)
  }

  @ExceptionHandler(TransactionSystemException)
  ResponseEntity<?> handleConstraintViolationException(TransactionSystemException e) {
    def cve = e.rootCause as ConstraintViolationException
    new ResponseEntity<?>(
      [errors: cve.constraintViolations.collectEntries { [(it.propertyPath): it.message] }],
      HttpStatus.CONFLICT)
  }

//    @ExceptionHandler(DataIntegrityViolationException)
//    ResponseEntity<ExceptionMessage> handleConflict(DataIntegrityViolationException e) {
////        super.handleConflict(e)
//        new ResponseEntity([message: 'unique'], HttpStatus.CONFLICT)
//    }
}
