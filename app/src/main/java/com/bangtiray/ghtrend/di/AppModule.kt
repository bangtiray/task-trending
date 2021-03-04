package com.bangtiray.ghtrend.di

import com.bangtiray.mylibrary.domain.usecase.UseCase
import com.bangtiray.mylibrary.domain.usecase.Interactor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@Module
@InstallIn(ActivityComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideUseCase(interactor: Interactor): UseCase

}
