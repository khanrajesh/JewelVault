package com.velox.jewelvault.ui.screen.start_loading

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.velox.jewelvault.ui.nav.MainRoute
import com.velox.jewelvault.ui.components.AnimatedGif
import jewelvault.composeapp.generated.resources.Res
import jewelvault.composeapp.generated.resources.loader_cat

@Composable
fun StartLoadingScreen() {
    val navigator = LocalNavigator.currentOrThrow

    val steps = remember {
        listOf(
            "Checking permissions",
            "Syncing data",
            "Preparing workspace",
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AnimatedGif(
            resource = Res.drawable.loader_cat,
            contentDescription = "Loading cat",
            modifier = Modifier.height(140.dp),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Getting things ready", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(12.dp))
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))
        steps.forEach { item ->
            Text(text = "• $item", style = MaterialTheme.typography.bodyMedium)
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                // TODO: wait for startup checks before proceeding.
                navigator.replace(MainRoute)
            },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Enter App")
        }
    }
}
