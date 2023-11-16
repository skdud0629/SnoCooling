package com.healthcare.domain.usecase

import com.healthcare.domain.repository.AnalysisRepository
import javax.inject.Inject

class AnalysisUseCase @Inject constructor(
    private val analysisRepository: AnalysisRepository
) {
}