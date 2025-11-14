package com.safiribytes.dashboard.domain.repositories

import com.safiribytes.dashboard.data.models.HomeResponseModel
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun fetchHomeData() : Flow<HomeResponseModel>
}