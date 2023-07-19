package com.sonnt.imagine.controller

import com.sonnt.imagine.factory.ResponseFactory
import com.sonnt.imagine.model.dto.ImagineRequest
import com.sonnt.imagine.services.ProcessTaskService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
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
        @RequestBody @Validated body: ImagineRequest
    ): ResponseEntity<*> {
        taskService.handleImagineTask(body)
        return responseFactory.ok()
    }
}
