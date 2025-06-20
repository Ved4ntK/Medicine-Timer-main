package com.Ved4ntK.Medicine-Timerapp.data.mapper

import com.Ved4ntK.Medicine-Timerapp.data.entity.MedicationEntity
import com.Ved4ntK.Medicine-Timerapp.domain.model.Medication
import com.Ved4ntK.Medicine-Timerapp.util.MedicationType
import java.util.Date

fun MedicationEntity.toMedication(): Medication {
    return Medication(
        id = id,
        name = name,
        dosage = dosage,
        frequency = recurrence,
        startDate = startDate ?: Date(),
        endDate = endDate,
        medicationTime = medicationTime,
        medicationTaken = medicationTaken,
        type = MedicationType.valueOf(type)
    )
}

fun Medication.toMedicationEntity(): MedicationEntity {
    return MedicationEntity(
        id = id,
        name = name,
        dosage = dosage,
        recurrence = frequency,
        startDate = startDate,
        endDate = endDate,
        medicationTime = medicationTime,
        medicationTaken = medicationTaken,
        type = type.name
    )
}
