package com.Ved4ntK.Medicine-Timerapp.feature.medicationconfirm.usecase

import com.Ved4ntK.Medicine-Timerapp.domain.model.Medication
import com.Ved4ntK.Medicine-Timerapp.domain.repository.MedicationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AddMedicationUseCase @Inject constructor(
    private val repository: MedicationRepository
) {
    suspend fun addMedication(medications: List<Medication>): Flow<List<Medication>> = repository.insertMedications(medications)
}
