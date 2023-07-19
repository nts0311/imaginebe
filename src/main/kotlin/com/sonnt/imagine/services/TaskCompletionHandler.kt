package com.sonnt.imagine.services

import com.sonnt.imagine.model.Task

interface TaskCompletionHandler {
    fun onTaskCompleted(task: Task)
}