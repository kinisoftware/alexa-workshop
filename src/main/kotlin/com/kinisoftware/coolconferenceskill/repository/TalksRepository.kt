package com.kinisoftware.coolconferenceskill.repository

import com.kinisoftware.coolconferenceskill.model.Talk

class TalksRepository {
    fun getTalks() = listOf(
        Talk(1,"09:00", """<lang xml:lang="en-US">Keynote</lang>""", emptyList()),
        Talk(1, "10:15", "Dando a amor a los tests con Kotlin", listOf("testing", "kotlin")),
        Talk(1, "11:15", "Alexa, ¿has venido para quedarte?", listOf("aws", "alexa")),
        Talk(1, "12:15", "Java 10, ¿mito o realidad?", listOf("java", "jvm")),
        Talk(1, "13:15", "Conoce a LUIS", listOf("microsoft", "asistentes de voz")),
        Talk(1, "15:30", "Creando un juego con el asistente de Google", listOf("google", "asistentes de voz")),
        Talk(1, "16:30", "Creando un skill para Alexa desde cero", listOf("alexa")),
        Talk(1, "17:45", "Keynote de cierre", emptyList())
    )
}