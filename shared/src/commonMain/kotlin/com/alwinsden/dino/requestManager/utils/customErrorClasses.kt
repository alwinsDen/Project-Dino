package com.alwinsden.dino.requestManager.utils

import kotlinx.serialization.Serializable

class CustomErrorClasses {
}

class CustomInAppException(val appCode: Int, val incomingErrorMessage: String? = null) : RuntimeException()

@Serializable
data class ErrorObjectCustom(
    val errorCode: Int? = null,
    val errorType: String,
    val errorMessage: String? = null
)