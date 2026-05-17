package com.velox.jewelvault.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.DrawableResource

@Composable
expect fun AnimatedGif(
    resource: DrawableResource,
    contentDescription: String?,
    modifier: Modifier = Modifier,
)
