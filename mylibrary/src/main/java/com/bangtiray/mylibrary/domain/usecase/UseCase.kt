package com.bangtiray.mylibrary.domain.usecase

import com.bangtiray.mylibrary.data.source.Resource
import com.bangtiray.mylibrary.data.source.remote.response.ResponseDto
import kotlinx.coroutines.flow.Flow

interface UseCase {
    fun getAllTrend(lang:String, since:String):Flow<Resource<List<ResponseDto>>>
}