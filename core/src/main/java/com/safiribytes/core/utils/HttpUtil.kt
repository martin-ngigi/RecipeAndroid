package com.safiribytes.core.utils

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.headers
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.encodedPath
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Inject

class HttpUtil @Inject constructor (
    private val httpClient: HttpClient
){
    suspend fun makeAPICall(
        url: String,
        httpMethod: HttpMethod,
        requestBody: Json?,
    ): HttpResponse {
        val request = HttpRequestBuilder()
        request.url {
            encodedPath = url
        }

        request.method = httpMethod
        if (httpMethod == HttpMethod.Post) {
            request.setBody(requestBody ?: {})
        }

        request.headers {
            append(
                name = HttpHeaders.Authorization,
                value = "Bearer ${Constants.ACCESS_TOKEN}"
            )
        }


        val configuredClient = httpClient.config {
            install(HttpTimeout) {
                requestTimeoutMillis = Constants.REQUEST_TIMEOUT.toLong()
                connectTimeoutMillis = Constants.REQUEST_TIMEOUT.toLong()
                socketTimeoutMillis = Constants.REQUEST_TIMEOUT.toLong()
            }

            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }

        val response = configuredClient.request(request)
        return response
    }
}