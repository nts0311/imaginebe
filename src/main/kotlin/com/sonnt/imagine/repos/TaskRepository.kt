package com.sonnt.imagine.repos

import com.sonnt.imagine.model.Task
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository: MongoRepository<Task, String> {
}