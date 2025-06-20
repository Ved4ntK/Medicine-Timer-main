package com.Ved4ntK.Medicine-Timerapp.feature.home.usecase

import com.Ved4ntK.Medicine-Timerapp.domain.model.Medication
import com.Ved4ntK.Medicine-Timerapp.domain.repository.MedicationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMedicationsUseCase @Inject constructor(
    private val repository: MedicationRepository
) {

    fun getMedications(date: String? = null): Flow<List<Medication>> {
        return if (date != null) {
            repository.getMedicationsForDate(date)
        } else repository.getAllMedications()
    }
}
