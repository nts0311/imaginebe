package com.sonnt.imagine.config.exception

import com.sonnt.imagine.factory.ResponseFactory
import com.sonnt.imagine.model.response.BaseResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.function.Consumer


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

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException): ResponseEntity<*> {
        val message = ex.allErrors.firstOrNull()?.defaultMessage
        return responseFactory.validationError(message)
    }

    @ExceptionHandler(Exception::class)
    fun handleExceptions(ex: Exception): ResponseEntity<*> {
        ex.printStackTrace()
        return responseFactory.internalServerError(ex)
    }
}

fun ok() = ResponseEntity.ok().body(BaseResponse())

fun ok(body: Any) = ResponseEntity.ok().body(body)