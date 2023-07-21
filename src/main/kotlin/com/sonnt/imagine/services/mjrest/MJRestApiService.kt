package com.sonnt.imagine.services.mjrest

data class DiscordMessageInfo(
    val messageId: String = "",
    val messageHash: String?,
    val messageFlags: Int?
)

interface MJRestApiService {
    fun sendImagineMessage(prompt: String): Boolean
    fun sendUpscaleMessage(messageInfo: DiscordMessageInfo, index: Int): Boolean
}