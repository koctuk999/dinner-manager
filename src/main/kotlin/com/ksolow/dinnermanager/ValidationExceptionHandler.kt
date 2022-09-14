package com.ksolow.dinnermanager

import com.ksolow.dinnermanager.entity.ErrorResponse
import org.slf4j.LoggerFactory.getLogger
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class ValidationExceptionHandler {

    private val log = getLogger(ValidationExceptionHandler::class.java)

    @ExceptionHandler(HttpMessageNotReadableException::class)
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    fun processHttpMessageNotReadableException(ex: HttpMessageNotReadableException): ResponseEntity<ErrorResponse> {
        log.warn(ex.cause?.message)
        return ResponseEntity
            .status(BAD_REQUEST)
            .body(
                ErrorResponse(
                    type = "IllegalParameters",
                    message = ex.cause?.message
                )
            )
    }
}
