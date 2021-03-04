package com.bangtiray.mylibrary.domain.repository

import com.bangtiray.mylibrary.data.source.Resource
import com.bangtiray.mylibrary.data.source.remote.response.ResponseDto
import kotlinx.coroutines.flow.Flow

interface ITrendRepository {
    fun getAllTrend(lang:String, since:String):Flow<Resource<List<ResponseDto>>>
}