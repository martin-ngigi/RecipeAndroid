package com.safiribytes.core.di

import android.content.Context
import com.safiribytes.core.utils.Constants
import com.safiribytes.core.utils.HttpUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton
import io.ktor.client.engine.okhttp.OkHttp

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClientEngine(): HttpClientEngine {
        return OkHttp.create()
    }
    @Provides
    @Singleton
    fun provideHttpClient(
        httpClientEngine: HttpClientEngine,
        @ApplicationContext context: Context
    ): HttpClient {
        return HttpClient(httpClientEngine) {
            install(Logging){
                level = LogLevel.ALL
            }

            install(DefaultRequest) {
                url(Constants.BASE_URL)
                header(key = HttpHeaders.ContentType, value = ContentType.Application.Json)
            }

            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        isLenient = true
                    }
                )
            }
        }
    }

    @Provides
    @Singleton
    fun provideHttpUtil(
        httpClient: HttpClient,
    ): HttpUtil {
        return HttpUtil(httpClient = httpClient)
    }
}