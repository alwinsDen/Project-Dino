package com.alwinsden.dino.sheets.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import authManager.IOSAuthentication
import dino.composeapp.generated.resources.Res
import dino.composeapp.generated.resources.btn_apple_id_rec
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource

@Composable
actual fun TriggerAutoSignIn() {
    TODO("Not yet implemented")
}

actual suspend fun manualTriggerSignIn() {
    TODO("Not yet implemented")
}

@Composable
actual fun ClickableContinueWithApple(nonce: String) {
    val authenticationClass = remember { IOSAuthentication() }
    val scope = rememberCoroutineScope()
    Image(
        painter = painterResource(resource = Res.drawable.btn_apple_id_rec),
        contentDescription = "",
        modifier = Modifier.fillMaxWidth(.5f)
            .clickable {
                println("Initiate iOS login.")
                scope.launch {
                    authenticationClass.triggerLoginAtRequest()
                }
            }
    )
}