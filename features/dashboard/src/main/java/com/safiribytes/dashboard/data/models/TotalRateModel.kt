package com.safiribytes.dashboard.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.text.DecimalFormat

@Serializable
data class TotalRateModel(
    @SerialName("rate_id")
    val rateID: String,
    @SerialName("open_id")
    val openID: String,
    val rating: Double,
    @SerialName("total_ratings")
    val totalRatings: Int,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("updated_at")
    val updatedAt: String
) {
    val ratingFormatted: String
        get() {
            val formatter = DecimalFormat("#.##")
            return formatter.format(rating)
        }
}
