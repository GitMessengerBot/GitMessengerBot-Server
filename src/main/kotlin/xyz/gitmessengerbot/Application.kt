package xyz.gitmessengerbot

import io.ktor.application.install
import io.ktor.features.CORS
import io.ktor.features.StatusPages
import io.ktor.http.HttpMethod
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import xyz.gitmessengerbot.plugins.configureRouting

fun main() {
    embeddedServer(factory = Netty, port = 8080, host = "175.203.199.77") {
        install(StatusPages)
        install(CORS) {
            method(HttpMethod.Options)
            method(HttpMethod.Get)
            anyHost()
        }
        configureRouting()
        println("start")
    }.start(wait = true)
}
