package com.Ved4ntK.Medicine-Timerapp.domain.model

import android.os.Parcelable
import com.Ved4ntK.Medicine-Timerapp.util.MedicationType
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class Medication(
    val id: Long = 0,
    val name: String,
    val dosage: Int,
    val frequency: String,
    val startDate: Date,
    val endDate: Date,
    val medicationTaken: Boolean,
    val medicationTime: Date,
    val type: MedicationType = MedicationType.getDefault()
) : Parcelable
