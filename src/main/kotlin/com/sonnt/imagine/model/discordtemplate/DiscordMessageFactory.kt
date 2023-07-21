package com.sonnt.imagine.model.discordtemplate

import com.sonnt.imagine.config.ApplicationProperties
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class DiscordMessageFactory {
    @Autowired
    lateinit var properties: ApplicationProperties

    fun buildImagineMessage(prompt: String): DiscordMessageTemplate<ImagineMessageData> {
        val messageData = ImagineMessageData(prompt)
        val discordProperties = properties.discord
        return DiscordMessageTemplate(
            type = 2,
            guildId = discordProperties.guildId,
            channelId = discordProperties.channelId,
            sessionId = discordProperties.sessionId,
            data = messageData
        )
    }


}