package com.alwinsden.dino

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform