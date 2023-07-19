package com.sonnt.imagine.services.impl

import com.sonnt.imagine.model.Task
import com.sonnt.imagine.services.ImageTaskService
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import org.springframework.stereotype.Service

@Service
class MidJourneyService: ImageTaskService {

    private val taskExecutor = ThreadPoolTaskExecutor()

    init {
        taskExecutor.corePoolSize = 3
        taskExecutor.maxPoolSize = 3
    }

    override fun submitTask(task: Task) {

    }
}