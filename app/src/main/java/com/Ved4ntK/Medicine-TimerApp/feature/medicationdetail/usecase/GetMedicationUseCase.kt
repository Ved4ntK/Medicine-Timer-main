package com.Ved4ntK.Medicine-Timerapp.feature.medicationdetail.usecase

import com.Ved4ntK.Medicine-Timerapp.domain.model.Medication
import com.Ved4ntK.Medicine-Timerapp.domain.repository.MedicationRepository
import javax.inject.Inject

class GetMedicationUseCase @Inject constructor(
    private val repository: MedicationRepository
) {
    suspend operator fun invoke(id: Long): Medication? = repository.getMedicationById(id)
}
