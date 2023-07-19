package com.sonnt.imagine.config.exception

enum class ResponseStatusEnum(val code: String = "0") {
    ok,
    error("1"),
    systemError("500")
}

class BusinessException(
    val responseStatus: ResponseStatusEnum = ResponseStatusEnum.error
): RuntimeException()