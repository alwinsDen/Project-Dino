package com.alwinsden.dino.googleAuthn.serverManager

import com.alwinsden.dino.valkeyManager.ValkeyManager
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
import com.google.api.client.http.HttpTransport
import com.google.api.client.json.JsonFactory
import com.google.api.client.json.gson.GsonFactory
import glide.api.models.GlideString.gs
import glide.api.models.commands.SetOptions
import io.ktor.server.application.*
import kotlinx.coroutines.future.await

fun ApplicationCall.verifyGoogleToken(mobileGoogleIdToken: String) {
    val transport: HttpTransport = GoogleNetHttpTransport.newTrustedTransport()
    val jsonFactory: JsonFactory = GsonFactory.getDefaultInstance()
    val verifier: GoogleIdTokenVerifier = GoogleIdTokenVerifier.Builder(
        transport, jsonFactory
    ).setAudience(
        listOf(
            application.environment.config.propertyOrNull("dinoBackend.googleAuth.GOOGLE_AUDIENCE")?.getString()
        )
    ).build()
    var idToken: GoogleIdToken? = null
    try {
        idToken = verifier.verify(mobileGoogleIdToken)
    } catch (e: Exception) {
        throw IllegalArgumentException(e)
    }

    val payload: GoogleIdToken.Payload = idToken.payload
    println(payload.email)

    val cachedNonce = ValkeyManager.getClient().get(gs(payload.nonce)).get()
    if (cachedNonce == null) {
        throw IllegalStateException("Invalid nonce. Please retry to login.")
    } else {
        application.log.debug("Verified ")
    }
}


//nonce generator
suspend fun ApplicationCall.nonceGenerator(): String {
    val generatedUuid = java.util.UUID.randomUUID().toString()

    //set up the object class to set Valkey nonce
    val valkeyOptions = SetOptions.builder().expiry(SetOptions.Expiry.Seconds(60)).build()
    ValkeyManager.getClient().set(gs(generatedUuid), gs(generatedUuid), valkeyOptions).await()

    return generatedUuid
}