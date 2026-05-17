package com.velox.jewelvault.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import jewelvault.composeapp.generated.resources.Res
import jewelvault.composeapp.generated.resources.zen_antique_regular

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    ),
)

@OptIn(ExperimentalResourceApi::class)
@Composable
fun rememberZenFontFamily(): FontFamily {
    val zenFont = Font(Res.font.zen_antique_regular, weight = FontWeight.Normal)
    return remember(zenFont) {
        FontFamily(zenFont)
    }
}
