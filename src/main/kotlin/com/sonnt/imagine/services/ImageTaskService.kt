package com.sonnt.imagine.services

import com.sonnt.imagine.model.Task

interface ImageTaskService {
    fun submitTask(task: Task)
}