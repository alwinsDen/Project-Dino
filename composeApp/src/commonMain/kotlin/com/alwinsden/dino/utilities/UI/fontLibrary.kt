package com.alwinsden.dino.utilities.UI

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import dino.composeapp.generated.resources.*
import org.jetbrains.compose.resources.Font

/*
EBGaramond Font
*/
object FontLibrary {
    @Composable
    fun ebGaramond(): FontFamily {
        return FontFamily(
            Font(
                resource = Res.font.ebgaramond_regular,
                FontWeight.Normal,
                style = FontStyle.Normal
            ),
            Font(
                resource = Res.font.ebgaramond_medium,
                FontWeight.Medium,
                FontStyle.Normal
            ),
            Font(
                resource = Res.font.ebgaramond_bold,
                FontWeight.Bold,
                FontStyle.Normal
            ),
            Font(
                resource = Res.font.ebgaramond_italic,
                FontWeight.Normal,
                FontStyle.Italic
            )
        )
    }
}