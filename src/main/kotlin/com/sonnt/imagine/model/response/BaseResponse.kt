package com.sonnt.imagine.model.response

import org.springframework.http.HttpStatus

open class BaseResponse(
    var code: String = "0",
    var msg: String = "Success",
)