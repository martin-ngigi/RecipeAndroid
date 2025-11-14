package com.safiribytes.dashboard.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeResponseModel(
    val message: String,
    @SerialName("status_code")
    val statusCode: Int,
    val data: HomeData
)
