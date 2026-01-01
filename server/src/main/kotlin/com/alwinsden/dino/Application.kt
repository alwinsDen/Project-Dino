package com.alwinsden.dino

import com.alwinsden.dino.googleAuthn.serverManager.verifyGoogleToken
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    routing {
        get("/") {
            call.respondText("Ktor: ${Greeting().greet()}")
        }
        post("/login") {
            val text = call.receiveText()
            call.verifyGoogleToken(text)
            call.respondText("return JTW token here")//TODO
        }
    }
}