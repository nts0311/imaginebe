package com.sonnt.imagine.factory

import com.sonnt.imagine.config.exception.ExceptionResponse
import com.sonnt.imagine.config.exception.ResponseStatusEnum
import com.sonnt.imagine.config.locale.Translator
import com.sonnt.imagine.model.response.BaseResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class ResponseFactory {
    @Autowired
    lateinit var translator: Translator

    fun buildBaseResponse(responseStatus: ResponseStatusEnum = ResponseStatusEnum.ok): BaseResponse {
        return BaseResponse(
            code = responseStatus.code,
            msg = translator.getMessage(responseStatus.code)
        )
    }

    fun fail(responseStatus: ResponseStatusEnum) =
        ResponseEntity.ok(buildBaseResponse(responseStatus))

    fun internalServerError(ex: Exception): ResponseEntity<ExceptionResponse> {
        val message = ex.message ?: translator.getMessage(ResponseStatusEnum.systemError.code)
        return ResponseEntity.internalServerError().body(ExceptionResponse(message, ex.stackTraceToString()))
    }

    fun ok() = ResponseEntity.ok().body(buildBaseResponse())

    fun <T: BaseResponse> ok(body: T): ResponseEntity<T> {
        body.msg = translator.getMessage(body.code)
        return ResponseEntity.ok().body(body)
    }
}



