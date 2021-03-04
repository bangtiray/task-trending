package com.bangtiray.mylibrary.data.source

import com.bangtiray.mylibrary.data.source.remote.network.ApiResponse
import kotlinx.coroutines.flow.*

abstract class NetworkBoundResource<T> {
    private var result: Flow<Resource<T>> = flow {
        when (val apiResponse = createCall().first()) {
            is ApiResponse.Success -> {
//                saveCallResult(apiResponse.data)
                createCall().first()
                emit(Resource.Success<T>(apiResponse.data))

            }
            is ApiResponse.Empty -> {
                onFetchEmpty()
                emit(Resource.Error<T>("Empty Result"))
            }
            is ApiResponse.Error -> {
                onFetchFailed()
                emit(Resource.Error<T>(apiResponse.errorMessage))
            }
        }
    }

    protected abstract suspend fun createCall(): Flow<ApiResponse<T>>

    protected open fun onFetchEmpty() {}
    protected open fun onFetchFailed() {}
    fun asFlow(): Flow<Resource<T>> = result
//    protected abstract suspend fun saveCallResult(data: T)
}
