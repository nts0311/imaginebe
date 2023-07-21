package com.sonnt.imagine.config.locale

import jakarta.servlet.http.HttpServletRequest
import jakarta.validation.Validator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver
import java.util.*

@Configuration
class ClientLocaleResolver: AcceptHeaderLocaleResolver() {

    private val supportLanguageCodes = listOf("en", "vi")

    private val defaultLocales: Locale
        get() = Locale("en")

    private val locales: List<Locale>
        get() = supportLanguageCodes.map { Locale(it) }

    override fun resolveLocale(request: HttpServletRequest): Locale {
        val langHeader = request.getHeader("Accept-Language") ?: return defaultLocales
        return Locale.lookup(Locale.LanguageRange.parse(langHeader), locales)
    }
}

