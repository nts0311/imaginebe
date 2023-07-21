package com.sonnt.imagine.services.completionhandler

import com.sonnt.imagine.model.Task

interface TaskCompletionHandler {
    fun onTaskCompleted(task: Task)
}