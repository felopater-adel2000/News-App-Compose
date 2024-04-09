package com.jetpack.compose.news.data.remote

import com.jetpack.compose.news.data.remote.dto.NewsResponse
import com.jetpack.compose.news.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("everything")
    suspend fun getNews(
        @Query("sources") sources: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse
}