package com.sonnt.imagine.controller

import com.sonnt.imagine.config.exception.BusinessException
import com.sonnt.imagine.config.exception.ResponseStatusEnum
import com.sonnt.imagine.factory.ResponseFactory
import com.sonnt.imagine.model.dto.ImagineRequest
import com.sonnt.imagine.model.response.BaseResponse
import com.sonnt.imagine.services.ProcessTaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/image")
class ImageTaskController {

    @Autowired lateinit var taskService: ProcessTaskService
    @Autowired lateinit var responseFactory: ResponseFactory

    @PostMapping("imagine")
    fun requestImageGeneration(
        @RequestBody body: ImagineRequest
    ): ResponseEntity<*> {
        return responseFactory.ok(TestResponse())
    }
}

data class TestResponse(
    val khum: String = "khum1",
    val messcode: Int = 0,
    val money: Double = 6.9
): BaseResponse()