package com.velox.jewelvault.ui.screen.splash

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.velox.jewelvault.ui.nav.LoginRoute
import com.velox.jewelvault.ui.theme.rememberZenFontFamily
import jewelvault.composeapp.generated.resources.Res
import jewelvault.composeapp.generated.resources.logo_1
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource

@Composable
fun SplashScreen() {
    val navigator = LocalNavigator.currentOrThrow

    val scale = remember { Animatable(0f) }
    val title = "JEWEL VAULT"

    val visibleLetters = remember { mutableStateListOf<Char>() }
    val zenFontFamily = rememberZenFontFamily()

    LaunchedEffect(Unit) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 1800, easing = LinearOutSlowInEasing),
        )
        title.forEach { char ->
            visibleLetters.add(char)
            delay(70)
        }
        delay(500)
        navigator.replace(LoginRoute)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(120.dp))
        Image(
            painter = painterResource(Res.drawable.logo_1),
            contentDescription = "JewelVault Logo",
            modifier = Modifier.graphicsLayer(
                scaleX = scale.value,
                scaleY = scale.value,
            ),
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row {
            visibleLetters.forEach { letter ->
                AnimatedVisibility(
                    visible = true,
                    enter = fadeIn(animationSpec = tween(900)) + slideInVertically(
                        animationSpec = tween(900),
                        initialOffsetY = { fullHeight -> -fullHeight / 2 },
                    ),
                ) {
                    Text(
                        text = letter.toString(),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = zenFontFamily,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(horizontal = 2.dp),
                    )
                }
            }
        }
    }
}
