package com.bangtiray.ghtrend.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bangtiray.mylibrary.domain.usecase.UseCase

class ViewModel @ViewModelInject constructor(private val useCase: UseCase):ViewModel(){
    fun getAllTrend(lang:String, since:String)=useCase.getAllTrend(lang,since).asLiveData()

}