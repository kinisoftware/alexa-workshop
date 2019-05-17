package com.kinisoftware.coolconferenceskill.repository

import com.kinisoftware.coolconferenceskill.model.Talk

class TalksRepository {
    fun getTalks() = listOf(
        Talk(1,"09:00", "Keynote", emptyList()),
        Talk(1, "10:15", "Dando a amor a los tests con Kotlin", listOf("testing", "kotlin")),
        Talk(1, "11:15", "Alexa, ¿has venido para quedarte?", listOf("aws", "alexa")),
        Talk(1, "12:15", "Java 10, ¿mito o realidad?", listOf("java", "jvm")),
        Talk(1, "13:15", "Conoce a LUIS", listOf("microsoft", "asistentes de voz")),
        Talk(1, "15:30", "Creando un juego con el asistente de Google", listOf("google", "asistentes de voz")),
        Talk(1, "16:30", "Creando un skill para Alexa desde cero", listOf("alexa")),
        Talk(1, "17:45", "Keynote de cierre", emptyList()),
        Talk(2, "10:15", "Dame tus tipos Pegaso", listOf("programming", "kotlin")),
        Talk(2, "11:15", "Asistentes de voz, una charla para dominarlos a todos", listOf("asistentes de voz", "alexa", "google", "microsoft")),
        Talk(2, "12:15", "De Java 7 a Java 8", listOf("java", "jvm")),
        Talk(2, "13:15", "¿Cuándo tengo que parar de refactorizar?", listOf("refactoring", "clean code")),
        Talk(2, "15:30", "Trucos para un AWS Lambda tope gama", listOf("aws", "lambda")),
        Talk(2, "16:30", "Cómo dar una charla en un evento técnico", listOf("charlas"))
    )
}