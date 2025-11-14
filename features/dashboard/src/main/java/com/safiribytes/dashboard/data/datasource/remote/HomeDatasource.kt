package com.safiribytes.dashboard.data.datasource.remote

import com.safiribytes.core.utils.Constants
import com.safiribytes.core.utils.HttpUtil
import com.safiribytes.dashboard.data.models.HomeResponseModel
import io.ktor.client.call.body
import io.ktor.http.HttpMethod
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class HomeDatasource @Inject() constructor(
    private val httpUtil: HttpUtil
) {
    fun fetchHomeData() : Flow<HomeResponseModel> = flow{
        val response = httpUtil.makeAPICall(
            url = Constants.homeURL,
            httpMethod = HttpMethod.Get,
            requestBody = null
        )
        val homeResponse: HomeResponseModel = response.body()
        emit(homeResponse)
    }
}