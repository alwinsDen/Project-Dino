package com.alwinsden.dino.sheets.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import authManager.GoogleAuthenticator
import com.alwinsden.dino.utilities.UI.DialogLoader
import dino.composeapp.generated.resources.Res
import dino.composeapp.generated.resources.android_light_sq_ctn
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
actual fun ClickableContinueWithGoogle(nonce: String) {
    val scope = rememberCoroutineScope()
    val authenticatorClass = remember { GoogleAuthenticator() }
    var loaderState by remember { mutableStateOf((false)) }
    Image(
        painter = painterResource(
            resource = Res.drawable.android_light_sq_ctn
        ), contentDescription = "Continue with Google",
        modifier = Modifier.clickable {
            println("Trigger IOS")
            scope.launch {
                authenticatorClass.login()
            }
        }
    )
    DialogLoader(loaderState)
}