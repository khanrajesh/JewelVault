package com.velox.jewelvault.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asComposeImageBitmap
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.getDrawableResourceBytes
import org.jetbrains.compose.resources.rememberResourceEnvironment
import org.jetbrains.skia.Bitmap
import org.jetbrains.skia.Codec
import org.jetbrains.skia.Data

@Composable
actual fun AnimatedGif(
    resource: DrawableResource,
    contentDescription: String?,
    modifier: Modifier,
) {
    val environment = rememberResourceEnvironment()
    val bytes by produceState<ByteArray?>(null, resource, environment) {
        value = getDrawableResourceBytes(environment, resource)
    }

    val codec = remember(bytes) {
        bytes?.let { Codec.makeFromData(Data.makeFromBytes(it)) }
    }

    DisposableEffect(codec) {
        onDispose { codec?.close() }
    }
    val frameCount = remember(codec) { codec?.frameCount ?: 0 }
    val framesInfo = remember(codec) { codec?.framesInfo.orEmpty() }
    var frameIndex by remember(codec) { mutableStateOf(0) }

    LaunchedEffect(codec, frameCount) {
        if (codec == null || frameCount <= 1) return@LaunchedEffect
        while (true) {
            val frameDelay = framesInfo.getOrNull(frameIndex)?.duration?.coerceAtLeast(16) ?: 100
            delay(frameDelay.toLong())
            frameIndex = (frameIndex + 1) % frameCount
        }
    }

    val imageBitmap = remember(codec, frameIndex) {
        codec?.let { decodeFrame(it, frameIndex) }
    }

    if (imageBitmap != null) {
        Image(
            bitmap = imageBitmap,
            contentDescription = contentDescription,
            modifier = modifier,
        )
    }
}

private fun decodeFrame(codec: Codec, frameIndex: Int): ImageBitmap {
    val bitmap = Bitmap()
    bitmap.allocPixels(codec.imageInfo)
    codec.readPixels(bitmap, frameIndex)
    return bitmap.asComposeImageBitmap()
}
