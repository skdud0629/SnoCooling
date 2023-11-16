package com.healthcare.snocooling.di

import com.healthcare.domain.repository.AnalysisRepository
import com.healthcare.domain.usecase.AnalysisUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideAnalysisUseCase(
        analysisRepository: AnalysisRepository
    ): AnalysisUseCase {
        return AnalysisUseCase(analysisRepository)
    }
}