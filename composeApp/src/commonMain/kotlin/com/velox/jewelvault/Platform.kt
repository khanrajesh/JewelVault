package com.velox.jewelvault

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform