package xyz.gitmessengerbot.plugins

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("daol.xyz 로 접속 가능")
        }

        get("/random") {
            call.respondText("사용법: /random/{items}\n아이템들은 ,로 구분")
        }

        get("/random/{items}") {
            val items = call.parameters["items"]?.split(",") ?: emptyList()
            call.respondText("추천 아이템은?! ${items.random()} 입니다.")
        }

        get("/error") {
            call.respondText("Error!!!")
        }
    }
}
