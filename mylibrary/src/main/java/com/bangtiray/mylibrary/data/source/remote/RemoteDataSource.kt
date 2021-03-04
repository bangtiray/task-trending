package com.bangtiray.mylibrary.data.source.remote

import com.bangtiray.mylibrary.data.source.remote.network.ApiResponse
import com.bangtiray.mylibrary.data.source.remote.network.ApiService
import com.bangtiray.mylibrary.data.source.remote.response.ResponseDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService){
    suspend fun getAllTrend(lang:String, since:String):Flow<ApiResponse<List<ResponseDto>>>{
        return  flow {
            try {
                val response=apiService.getAllTrend(lang,since)
                if(response.isNotEmpty()){
                    emit(ApiResponse.Success(response))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e:Exception){
                emit(ApiResponse.Error(e.localizedMessage))
            }
        }.flowOn(Dispatchers.IO)
    }
}