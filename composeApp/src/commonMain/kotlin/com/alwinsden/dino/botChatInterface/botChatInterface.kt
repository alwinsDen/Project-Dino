package com.alwinsden.dino.botChatInterface

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.PowerSettingsNew
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.alwinsden.dino.botChatInterface.components.AiUpdatedField
import com.alwinsden.dino.botChatInterface.components.UserCreatedField
import com.alwinsden.dino.botInterface.components.BotTextField
import com.alwinsden.dino.utilities.UI.DefaultFontStylesDataClass
import com.alwinsden.dino.utilities.UI.defaultFontStyle

@Composable
fun BotChatInterface() {
    val verticalScrollState = rememberScrollState()
    BoxWithConstraints(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        val mxWidth = maxWidth * .7f
        Column(
            Modifier.verticalScroll(state = verticalScrollState)
        ) {
            Spacer(Modifier.height(50.dp))
            UserCreatedField(maxWidth = mxWidth)
            AiUpdatedField(maxWidth = mxWidth)
            UserCreatedField(maxWidth = mxWidth)
            AiUpdatedField(maxWidth = mxWidth)
            UserCreatedField(maxWidth = mxWidth)
            AiUpdatedField(maxWidth = mxWidth)
            UserCreatedField(maxWidth = mxWidth)
            AiUpdatedField(maxWidth = mxWidth)
            UserCreatedField(maxWidth = mxWidth)
            AiUpdatedField(maxWidth = mxWidth)
            UserCreatedField(maxWidth = mxWidth)
            AiUpdatedField(maxWidth = mxWidth)
            Spacer(
                Modifier
                    .navigationBarsPadding()
                    .height(120.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                .background(color = Color(0xfffafafa))
        ) {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Settings, contentDescription = null)
            }
            Text(
                text = "17th January 2026", textAlign = TextAlign.Center, style = defaultFontStyle(
                    DefaultFontStylesDataClass()
                )
            )
            Row(
                modifier = Modifier.weight(1f, true),
                horizontalArrangement = Arrangement.End,
            ) {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Default.PowerSettingsNew, contentDescription = "Logout app")
                }
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Default.History, contentDescription = "Logout app")
                }
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth()
                .align(Alignment.BottomCenter)
                .dropShadow(
                    shape = RoundedCornerShape(20.dp),
                    shadow = Shadow(
                        radius = 5.dp,
                        spread = 5.dp,
                        color = Color(0xff98D6B2),
                        offset = DpOffset(x = 0.dp, (3).dp)
                    )
                )
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                .background(Color(0xffffffff))
                .padding(top = 15.dp)
                .navigationBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            BotTextField()
        }
    }
}