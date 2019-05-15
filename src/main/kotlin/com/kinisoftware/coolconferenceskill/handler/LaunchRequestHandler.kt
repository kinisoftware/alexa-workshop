package com.kinisoftware.coolconferenceskill.handler

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.LaunchRequest
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates
import com.kinisoftware.coolconferenceskill.CoolConferenceStreamHandler.Companion.CARD_TITLE
import java.util.Optional

class LaunchRequestHandler : RequestHandler {

    override fun canHandle(input: HandlerInput): Boolean {
        return input.matches(Predicates.requestType(LaunchRequest::class.java))
    }

    override fun handle(input: HandlerInput): Optional<Response> {
        val repromptText = "Puedes preguntarme por la agenda completa, la charla de una hora determinada o por temas para alguno de los dos tracks."
        val text = "Bienvenido a Conferencia Muy Molona! Pregúntame por la agenda de alguno de los dos tracks"
        return input.responseBuilder
                .withSpeech(text)
                .withSimpleCard(CARD_TITLE, text)
                .withReprompt(repromptText)
                .build()
    }
}