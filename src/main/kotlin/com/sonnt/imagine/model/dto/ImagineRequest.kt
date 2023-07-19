package com.sonnt.imagine.model.dto

data class ImagineRequest(
    val prompt: String,
    val refImageUrl: String?,
    val firebaseToken: String
)
