package com.kinisoftware.coolconferenceskill.handler

import com.kinisoftware.coolconferenceskill.CoolConferenceStreamHandler.Companion.CARD_TITLE
import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.LaunchRequest
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates
import java.util.*

class LaunchRequestHandler : RequestHandler {

    override fun canHandle(input: HandlerInput): Boolean {
        return input.matches(Predicates.requestType(LaunchRequest::class.java))
    }

    override fun handle(input: HandlerInput): Optional<Response> {
        val repromptText = "Puedes preguntarme por la agenda completa, la charla de una hora determinada o por temas."
        val text = "Bienvenido a Conferencia Molona! Pregúntame por la agenda"
        return input.responseBuilder
            .withSpeech(text)
            .withSimpleCard(CARD_TITLE, text)
            .withReprompt(repromptText)
            .build()
    }
}