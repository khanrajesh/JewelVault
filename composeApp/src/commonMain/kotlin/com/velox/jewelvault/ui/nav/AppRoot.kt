package com.velox.jewelvault.ui.nav

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator

@Composable
fun AppRoot() {
    Navigator(SplashRoute)
}
