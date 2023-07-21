package com.sonnt.imagine.config

import jakarta.validation.Validator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean

@Configuration
class BeanConfig {
    @Bean
    fun messageSource() =
        ResourceBundleMessageSource().apply {
            setBasename("messages")
            setDefaultEncoding("UTF-8")
            setUseCodeAsDefaultMessage(false)
        }

    @Bean
    fun getValidator(): Validator {
        val bean = LocalValidatorFactoryBean()
        bean.setValidationMessageSource(messageSource())
        return bean
    }
}