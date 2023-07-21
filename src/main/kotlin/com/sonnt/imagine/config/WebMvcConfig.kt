package com.sonnt.imagine.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.sonnt.imagine.config.exception.BusinessException
import com.sonnt.imagine.model.response.BaseResponse
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

//@Component
//class AuthHeaderFilter: OncePerRequestFilter() {
//    override fun doFilterInternal(
//        request: HttpServletRequest,
//        response: HttpServletResponse,
//        filterChain: FilterChain
//    ) {
//        val appHeader = request.getHeader("App")
//
//        if (appHeader != "secret") {
//            ObjectMapper().writeValue(
//                response.outputStream,
//                BaseResponse(code = "401", msg = "")
//            )
//        } else {
//            filterChain.doFilter(request, response)
//        }
//
//    }
//}