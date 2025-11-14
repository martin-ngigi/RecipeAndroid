package com.safiribytes.dashboard.presentation
import com.safiribytes.dashboard.data.models.HomeResponseModel

data class HomeUIState(
    val isLoading: Boolean = false,
    val homeResponseModel: HomeResponseModel? = null,
    val message: String? = null
)