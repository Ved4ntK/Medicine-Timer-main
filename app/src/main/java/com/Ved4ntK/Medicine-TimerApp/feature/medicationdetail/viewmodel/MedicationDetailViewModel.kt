package com.Ved4ntK.Medicine-Timerapp.feature.medicationdetail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.Ved4ntK.Medicine-Timerapp.analytics.AnalyticsHelper
import com.Ved4ntK.Medicine-Timerapp.domain.model.Medication
import com.Ved4ntK.Medicine-Timerapp.feature.home.usecase.UpdateMedicationUseCase
import com.Ved4ntK.Medicine-Timerapp.feature.medicationdetail.usecase.GetMedicationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MedicationDetailViewModel @Inject constructor(
    private val getMedicationUseCase: GetMedicationUseCase,
    private val updateMedicationUseCase: UpdateMedicationUseCase,
    private val analyticsHelper: AnalyticsHelper
) : ViewModel() {
    private val _medication = MutableStateFlow<Medication?>(null)
    val medication = _medication.asStateFlow()

    fun getMedicationById(id: Long) {
        viewModelScope.launch {
            _medication.value = getMedicationUseCase(id)
        }
    }

    fun updateMedication(medication: Medication, isMedicationTaken: Boolean) {
        viewModelScope.launch {
            updateMedicationUseCase.updateMedication(medication.copy(medicationTaken = isMedicationTaken))
        }
    }

    fun logEvent(eventName: String) {
        analyticsHelper.logEvent(eventName = eventName)
    }
}
