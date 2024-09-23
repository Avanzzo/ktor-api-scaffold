package api.presentation.routes

import api.di.apiModule
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import org.koin.ktor.plugin.Koin

fun Application.configureRouting(){
    routing {
        route("/health") {
            get("/check") {
                call.respond(HttpStatusCode.OK, "Server is healthy")
            }
        }
    }
}

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json(Json {
            ignoreUnknownKeys = true
        })
    }
}

fun Application.configureDI() {
    install(Koin) {
        modules(apiModule)
    }
}

fun Application.module(){
    configureSerialization()
    configureDI()
    configureRouting()
}