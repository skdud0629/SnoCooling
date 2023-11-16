package com.healthcare.presentation.ui.analysis.viewmodel

import androidx.lifecycle.ViewModel
import com.healthcare.domain.usecase.AnalysisUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnalysisViewModel @Inject constructor(
    private val analysisUseCase: AnalysisUseCase
) : ViewModel() {

}