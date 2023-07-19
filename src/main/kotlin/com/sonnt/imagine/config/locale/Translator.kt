package com.sonnt.imagine.config.locale

import com.sonnt.imagine.config.exception.ResponseStatusEnum
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.stereotype.Component

@Component
class Translator{
    @Autowired
    lateinit var messageSource: ResourceBundleMessageSource

    fun getMessage(code: String): String {
        val locale = LocaleContextHolder.getLocale()
        return try {
            messageSource.getMessage(code, null, locale)
        } catch (ex: Exception) {
            messageSource.getMessage(ResponseStatusEnum.Error.code, null, locale)
        }
    }

}