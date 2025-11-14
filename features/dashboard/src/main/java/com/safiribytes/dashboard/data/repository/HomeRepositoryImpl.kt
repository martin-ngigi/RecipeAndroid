package com.safiribytes.dashboard.data.repository

import com.safiribytes.dashboard.data.datasource.remote.HomeDatasource
import com.safiribytes.dashboard.data.models.HomeResponseModel
import com.safiribytes.dashboard.domain.repositories.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject() constructor(
    private val homeDatasource: HomeDatasource
): HomeRepository {
    override fun fetchHomeData() : Flow<HomeResponseModel> {
        return homeDatasource.fetchHomeData()
    }
}