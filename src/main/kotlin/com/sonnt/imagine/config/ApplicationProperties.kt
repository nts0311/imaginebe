package com.sonnt.imagine.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "mj")
class ApplicationProperties {

    lateinit var discord: DiscordProperties

    data class DiscordProperties(
        val guildId: String,
        val channelId: String,
        val userToken: String,
        val sessionId: String,
        val userAgent: String,
        val corePoolSize: Int,
        val maxPoolSize: Int,
    )
}