package com.sonnt.imagine.model.discordtemplate

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
class DiscordMessageTemplate<T>(
    val type: Int,
    val guildId: String,
    val channelId: String,
    val applicationId: String = "936929561302675456",
    val sessionId: String,
    val messageId: String? = null,
    var messageFlags: Int? = null,
    val data: T?
)


class DiscordSlashCommandParam(
    val type: Int,
    val name: String,
    val value: String
)

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
class ImagineMessageData(
    prompt: String
) {
    val version = "1118961510123847772"
    val id = "938956540159881230"
    val name = "imagine"
    val type = 1
    val options = mutableListOf(
        DiscordSlashCommandParam(
            type = 3,
            name = "prompt",
            value = prompt
        )
    )
}

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
class ImageVariationMessageData(
    val componentType: Int,
    val customId: String
)
