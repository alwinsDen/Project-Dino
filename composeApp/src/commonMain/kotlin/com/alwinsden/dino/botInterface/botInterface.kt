package com.alwinsden.dino.botInterface

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/*
* NAVIGATION: BotInterface fot the main
* Bot interaction page.
* */
@Composable
fun BotInterface() {
    Box(
        modifier = Modifier.statusBarsPadding().fillMaxSize(),
    ) {
        Text("Chat Box")
    }
}