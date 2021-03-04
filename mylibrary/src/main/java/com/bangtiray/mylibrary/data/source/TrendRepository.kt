package com.bangtiray.mylibrary.data.source

import com.bangtiray.mylibrary.data.source.remote.RemoteDataSource
import com.bangtiray.mylibrary.data.source.remote.network.ApiResponse
import com.bangtiray.mylibrary.data.source.remote.response.ResponseDto
import com.bangtiray.mylibrary.domain.repository.ITrendRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TrendRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : ITrendRepository {
    override fun getAllTrend(lang: String, since: String): Flow<Resource<List<ResponseDto>>> {
        return object : NetworkBoundResource<List<ResponseDto>>() {
            override suspend fun createCall(): Flow<ApiResponse<List<ResponseDto>>> {
                return remoteDataSource.getAllTrend(lang, since)
            }
        }.asFlow()
    }

}