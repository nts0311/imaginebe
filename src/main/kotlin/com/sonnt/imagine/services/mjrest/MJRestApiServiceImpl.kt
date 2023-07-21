package com.sonnt.imagine.services.mjrest

import com.sonnt.imagine.config.ApplicationProperties
import com.sonnt.imagine.model.discordtemplate.DiscordMessageFactory
import org.bson.json.JsonObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.*
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class MJRestApiServiceImpl: MJRestApiService {

    private val DISCORD_BASE_URL = "https://discord.com"
    private val discordApiUrl: String = "$DISCORD_BASE_URL/api/v9/interactions"

    @Autowired
    lateinit var properties: ApplicationProperties

    @Autowired
    lateinit var discordMessageFactory: DiscordMessageFactory

    override fun sendImagineMessage(prompt: String): Boolean {
        val message = discordMessageFactory.buildImagineMessage(prompt)
        val response = postJson<Any>(discordApiUrl, message) ?: return false
        return response.statusCode == HttpStatus.NO_CONTENT
    }

    override fun sendUpscaleMessage(messageInfo: DiscordMessageInfo, index: Int): Boolean {
        return false
    }

    private inline fun <reified T> postJson(url: String, obj: Any): ResponseEntity<T>? {
        return try {
            val headers = HttpHeaders()
            headers.set("Authorization", properties.discord.userToken)
            headers.set("User-Agent", properties.discord.userAgent)
            headers.contentType = MediaType.APPLICATION_JSON
            val restTemplate = RestTemplate()
            val httpEntity = HttpEntity<Any>(obj, headers)
            restTemplate.postForEntity(url, httpEntity, T::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }

    }
}