package com.kinisoftware.coolconferenceskill

import com.amazon.ask.SkillStreamHandler
import com.amazon.ask.Skills
import com.kinisoftware.coolconferenceskill.handler.LaunchRequestHandler

class CoolConferenceStreamHandler : SkillStreamHandler(skill) {
    companion object {
        const val CARD_TITLE = "Conferencia Molona"

        private val skill = Skills.custom()
            // Add here interceptors for request & response
            .addRequestHandlers(
                LaunchRequestHandler()
                // Add here Intent Request Handlers
            )
            .build()
    }
}