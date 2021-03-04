package com.bangtiray.mylibrary.domain.usecase

import com.bangtiray.mylibrary.domain.repository.ITrendRepository
import javax.inject.Inject


class Interactor @Inject constructor(private val iTrendRepository: ITrendRepository) : UseCase {
    override fun getAllTrend(lang: String, since: String) = iTrendRepository.getAllTrend(lang, since)

}