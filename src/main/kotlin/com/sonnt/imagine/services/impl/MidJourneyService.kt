package com.sonnt.imagine.services.impl

import com.sonnt.imagine.config.ApplicationProperties
import com.sonnt.imagine.model.Task
import com.sonnt.imagine.model.TaskType
import com.sonnt.imagine.services.ImageTaskService
import com.sonnt.imagine.services.mjrest.MJRestApiService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import org.springframework.stereotype.Service
import java.util.concurrent.Semaphore

@Service
class MidJourneyService(
    private val properties: ApplicationProperties,
    private val mjRestApiService: MJRestApiService
): ImageTaskService {

    private val taskExecutor = ThreadPoolTaskExecutor()
    private val semaphore: Semaphore

    init {
        taskExecutor.corePoolSize = properties.discord.corePoolSize
        taskExecutor.maxPoolSize = properties.discord.maxPoolSize
        taskExecutor.initialize()

        semaphore = Semaphore(properties.discord.maxPoolSize, true)
    }

    override fun submitTask(task: Task) {
        when(task.taskType) {
            TaskType.IMAGINE -> handleImagineTask(task)

            else -> {}
        }
    }

    private fun handleImagineTask(task: Task) {
        taskExecutor.submit {
            semaphore.acquire()
            mjRestApiService.sendImagineMessage(task.prompt)
        }
    }
}