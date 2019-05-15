package com.kinisoftware.coolconferenceskill.handler

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.IntentRequest
import com.amazon.ask.model.Response
import com.amazon.ask.model.slu.entityresolution.StatusCode
import com.amazon.ask.request.Predicates
import com.kinisoftware.coolconferenceskill.CoolConferenceStreamHandler.Companion.CARD_TITLE
import com.kinisoftware.coolconferenceskill.repository.TalksRepository
import java.util.Optional

class ScheduleIntentHandler : RequestHandler {

    override fun canHandle(input: HandlerInput): Boolean {
        return input.matches(Predicates.intentName("ScheduleIntent"))
    }

    override fun handle(input: HandlerInput): Optional<Response> {
        val request = input.requestEnvelope.request
        val intentRequest = request as IntentRequest
        val intent = intentRequest.intent
        val slots = intent.slots

        val talkTopic = slots["talkTopic"]
        val slotTime = slots["slotTime"]
        val track = slots["track"]!!.resolutions.resolutionsPerAuthority
                .first { it.status.code == StatusCode.ER_SUCCESS_MATCH }
                .values[0].value.name.toInt()

        val talks = TalksRepository().getTalks().filter { it.track == track }
        val response = when {
            slotTime != null && slotTime.value != null -> {
                val talk = talks.firstOrNull { it.time == slotTime.value }
                var text = "A esa hora no hay ninguna charla planificada en el $track"
                talk?.let { text = "A esa hora tienes la charla: ${it.title}" }
                text
            }
            talkTopic != null && talkTopic.value != null -> {
                val filteredTalksTitle = talks.filter { it.topics.contains(talkTopic.value) }.map { it.title }
                when {
                    filteredTalksTitle.isNotEmpty() ->
                        "Las charlas sobre ${talkTopic.value} son: ${filteredTalksTitle.joinToString(", ")}"
                    else ->
                        "No hay charlas sobre ${talkTopic.value}"
                }
            }
            else -> """Estas son todas las charlas de la agenda para el track $track:
                |${talks.joinToString(", ") { it.title }}""".trimMargin()
        }

        return input.responseBuilder
                .withSpeech(response)
                .withSimpleCard(CARD_TITLE, response)
                .withShouldEndSession(true)
                .build()
    }
}