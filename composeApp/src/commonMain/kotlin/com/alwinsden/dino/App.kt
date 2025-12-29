package com.alwinsden.dino

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dino.composeapp.generated.resources.Res
import dino.composeapp.generated.resources.android_light_sq_ctn
import dino.composeapp.generated.resources.dino_corner
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Box(
            modifier = Modifier
                .background(Color(0xff23D76E))
                .statusBarsPadding()
                .fillMaxSize(),
        ) {
            Box(Modifier.align(Alignment.Center)) {
                Column {
                    Text("Project Dino", fontSize = 20.sp, color = Color.White)
                    Spacer(Modifier.height(5.dp))
                    Image(
                        painter = painterResource(
                            resource = Res.drawable.android_light_sq_ctn
                        ), contentDescription = "Continue with Google"
                    )
                }
            }
            Box(Modifier.align(Alignment.BottomEnd)) {
                Image(
                    painter = painterResource(
                        resource = Res.drawable.dino_corner,
                    ),
                    contentDescription = "Corner logo for the ",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxWidth(0.7f)
                )
            }
        }
    }
}