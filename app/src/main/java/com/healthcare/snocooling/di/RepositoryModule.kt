package com.healthcare.snocooling.di

import com.healthcare.data.datasource.local.AnalysisLocalDataSource
import com.healthcare.data.repository.AnalysisRepositoryImpl
import com.healthcare.domain.repository.AnalysisRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideAnalysisRepository(
        analysisLocalDataSource: AnalysisLocalDataSource
    ): AnalysisRepository {
        return AnalysisRepositoryImpl(analysisLocalDataSource)
    }
}