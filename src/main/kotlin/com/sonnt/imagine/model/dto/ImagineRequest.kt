package com.sonnt.imagine.model.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.URL

data class ImagineRequest(
    @field:NotNull(message = "{prompt.empty}")
    @field:NotBlank(message = "{prompt.empty}")
    val prompt: String?,

    @field:URL(message = "{url.not.valid}")
    val refImageUrl: String?,

    @field:NotNull(message = "{firebase.token.empty}")
    @field:NotBlank(message = "{firebase.token.empty}")
    val firebaseToken: String?
)
