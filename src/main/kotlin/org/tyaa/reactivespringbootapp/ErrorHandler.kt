package org.tyaa.reactivespringbootapp

import org.tyaa.reactivespringbootapp.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ErrorHandler {
    @ExceptionHandler(Exception::class)
    fun JsonParseExceptionHandler(exception: Exception): ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse("JSON Error", exception.message ?: "invalid json"),
                HttpStatus.BAD_REQUEST)
    }
}