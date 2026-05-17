package com.velox.jewelvault

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.velox.jewelvault.ui.nav.AppRoot
import com.velox.jewelvault.ui.theme.JewelVaultTheme

@Composable
@Preview
fun App() {
    JewelVaultTheme {
        Column(
            modifier = Modifier
                .background(androidx.compose.material3.MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AppRoot()
        }
    }
}
