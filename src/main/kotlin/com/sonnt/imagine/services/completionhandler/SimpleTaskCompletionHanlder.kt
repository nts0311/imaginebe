package com.sonnt.imagine.services.completionhandler

import com.sonnt.imagine.model.Task
import org.springframework.stereotype.Component

@Component
class SimpleTaskCompletionHandler: TaskCompletionHandler {
    override fun onTaskCompleted(task: Task) {

    }
}