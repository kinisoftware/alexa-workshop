package com.kinisoftware.coolconferenceskill.handler

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.IntentRequest
import com.amazon.ask.model.Response
import com.kinisoftware.coolconferenceskill.repository.TalksRepository
import java.util.*

/**
 * 1) Extend RequestHandler
 * 2) Override canHandle in order to check if the input Intent name matches with the one we want to handle here
 * 3) Override handle:
 *   3.1) Get talkTopic slot from the input intent
 *   3.2) Add case for filtering the talks by the talkTopic if present
 *   3.3) Build & return the response
 */
class ScheduleIntentHandler : RequestHandler {

    override fun canHandle(input: HandlerInput) = false


    override fun handle(input: HandlerInput): Optional<Response> {
        val request = input.requestEnvelope.request
        val intentRequest = request as IntentRequest
        val intent = intentRequest.intent
        val slots = intent.slots

        val slotTime = slots["slotTime"]

        val talks = TalksRepository().getTalks()
        val response = when {
            slotTime != null && slotTime.value != null -> {
                val talk = talks.firstOrNull { it.time == slotTime.value }
                var text = "A esa hora no hay ninguna charla planificada"
                talk?.let { text = "A esa hora tienes la charla: ${it.title}" }
                text
            }
            // Add case for the talkTopic slot
            else -> "Estas son todas las charlas de la agenda: ${talks.joinToString(", ") { it.title }}"
        }

        return Optional.empty() // Build & return the response
    }
}