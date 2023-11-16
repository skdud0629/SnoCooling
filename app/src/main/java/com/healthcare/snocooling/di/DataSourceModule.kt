package com.healthcare.snocooling.di

import com.healthcare.data.datasource.local.AnalysisLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun provideAnalysisLocalDataSource(
    ): AnalysisLocalDataSource {
        return AnalysisLocalDataSource()
    }
}