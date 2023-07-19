package com.sonnt.imagine.config.exception

enum class ResponseStatusEnum(val code: String = "0") {
    OK,
    Error("1"),
    ValidationError("4"),
    SystemError("500")
}

class BusinessException(
    val responseStatus: ResponseStatusEnum = ResponseStatusEnum.Error
): RuntimeException()