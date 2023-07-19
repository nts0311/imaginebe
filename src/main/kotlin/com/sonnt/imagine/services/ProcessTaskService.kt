package com.sonnt.imagine.services

import com.sonnt.imagine.config.exception.BusinessException
import com.sonnt.imagine.config.exception.ResponseStatusEnum
import com.sonnt.imagine.model.Task
import com.sonnt.imagine.model.TaskType
import com.sonnt.imagine.model.dto.ImagineRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProcessTaskService {

    @Autowired
    lateinit var midJourneyService: ImageTaskService

    fun handleImagineTask(request: ImagineRequest) {

        val task = Task(
            taskType = TaskType.IMAGINE,
            prompt = request.prompt!!,
            promptEng = request.prompt,
            refImageUrl = request.refImageUrl,
            firebaseMessagingToken = request.firebaseToken!!
        )

        midJourneyService.submitTask(task)
    }
}