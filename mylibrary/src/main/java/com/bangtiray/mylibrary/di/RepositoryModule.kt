package com.bangtiray.mylibrary.di

import com.bangtiray.mylibrary.data.source.TrendRepository
import com.bangtiray.mylibrary.domain.repository.ITrendRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module(includes = [NetworkModule::class])
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(pokemonRepository: TrendRepository): ITrendRepository

}