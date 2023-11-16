package com.healthcare.data.repository

import com.healthcare.data.datasource.local.AnalysisLocalDataSource
import com.healthcare.domain.repository.AnalysisRepository
import javax.inject.Inject

class AnalysisRepositoryImpl @Inject constructor(
   private val analysisLocalDataSource: AnalysisLocalDataSource
) : AnalysisRepository {
}