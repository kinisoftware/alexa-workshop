package com.kinisoftware.coolconferenceskill

import com.amazon.ask.SkillStreamHandler
import com.amazon.ask.Skills
import com.kinisoftware.coolconferenceskill.handler.LaunchRequestHandler
import com.kinisoftware.coolconferenceskill.handler.ScheduleIntentHandler
import com.kinisoftware.coolconferenceskill.interceptor.LogRequestInterceptor
import com.kinisoftware.coolconferenceskill.interceptor.LogResponseInterceptor

class CoolConferenceStreamHandler : SkillStreamHandler(skill) {
    companion object {
        const val CARD_TITLE = "Conferencia Molona"

        private val skill = Skills.custom()
            .addRequestInterceptor(LogRequestInterceptor())
            .addResponseInterceptor(LogResponseInterceptor())
            .addRequestHandlers(
                LaunchRequestHandler(),
                ScheduleIntentHandler()
            )
            .build()
    }
}