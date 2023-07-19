package com.sonnt.imagine.config.exception

import com.sonnt.imagine.config.exception.BusinessException
import com.sonnt.imagine.factory.ResponseFactory
import com.sonnt.imagine.model.response.BaseResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

class ExceptionResponse(
    message: String = "",
    val stackTrace: String
): BaseResponse("500", message)

@RestControllerAdvice
class GlobalExceptionsHandler {

    @Autowired
    lateinit var responseFactory: ResponseFactory

    @ExceptionHandler(BusinessException::class)
    fun handleBusinessExceptions(ex: BusinessException): ResponseEntity<*> {
        return responseFactory.fail(ex.responseStatus)
    }

    @ExceptionHandler(Exception::class)
    fun handleExceptions(ex: Exception): ResponseEntity<*> {
        ex.printStackTrace()
        return responseFactory.internalServerError(ex)
    }
}

fun ok() = ResponseEntity.ok().body(BaseResponse())

fun ok(body: Any) = ResponseEntity.ok().body(body)