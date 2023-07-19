package com.sonnt.imagine.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

enum class TaskStatus {
    INIT,
    PROCESSING,
    SUCCESS,
    FAILED
}

enum class TaskType {
    IMAGINE,
    UPSCALE,
    VARIATION
}

@Document
data class Task(
    @Id
    var id: String = "",
    val taskType: TaskType,
    @Indexed
    var status: TaskStatus = TaskStatus.INIT,
    @Indexed
    var prompt: String,
    var promptEng: String,
    var refImageUrl: String? = null,
    var messageId: String = "",
    var processingMessageId: String = "",
    var firebaseMessagingToken: String,
    var resultImageUrl: String? = null
) {
    val createDate: LocalDateTime = LocalDateTime.now()
    var completeDate: LocalDateTime = LocalDateTime.now()
}