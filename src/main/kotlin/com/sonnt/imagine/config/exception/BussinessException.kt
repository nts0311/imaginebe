package com.sonnt.imagine.config.exception

import com.sonnt.imagine.model.response.BaseResponse

enum class ResponseStatusEnum(val code: String = "0") {
    OK,
    Error("error"),
    ValidationError("validation.error"),
    SystemError("internal.error")
}

class BusinessException(
    val responseStatus: ResponseStatusEnum = ResponseStatusEnum.Error
): RuntimeException()

class ExceptionResponse(
    message: String = "",
    val stackTrace: String
): BaseResponse("internal.error", message)