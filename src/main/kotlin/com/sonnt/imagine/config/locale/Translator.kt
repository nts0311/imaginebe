package com.sonnt.imagine.config.locale

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
        return messageSource.getMessage(code, null, locale)
    }
}