package com.Ved4ntK.Medicine-Timerapp.feature.history.viewmodel

import com.Ved4ntK.Medicine-Timerapp.domain.model.Medication

data class HistoryState(
    val medications: List<Medication> = emptyList()
)
