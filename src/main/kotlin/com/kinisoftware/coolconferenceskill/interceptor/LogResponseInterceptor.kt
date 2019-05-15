package com.kinisoftware.coolconferenceskill.interceptor

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.interceptor.ResponseInterceptor
import com.amazon.ask.model.Response
import com.google.gson.Gson
import java.util.*

class LogResponseInterceptor : ResponseInterceptor {
    override fun process(input: HandlerInput, response: Optional<Response>) {
        response.ifPresent { println("Response: ${Gson().toJson(it)}") }
    }
}