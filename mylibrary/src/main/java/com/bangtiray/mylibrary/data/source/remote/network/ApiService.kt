package com.bangtiray.mylibrary.data.source.remote.network

import com.bangtiray.mylibrary.data.source.remote.response.ResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("repositories")
    suspend fun getAllTrend(
        @Query("language") lang: String,
        @Query("since") since: String
    ): List<ResponseDto>
}