package com.Ved4ntK.Medicine-Timerapp.feature.home.viewmodel

import com.Ved4ntK.Medicine-Timerapp.domain.model.Medication

data class HomeState(
    val greeting: String = "",
    val userName: String = "",
    val lastSelectedDate: String,
    val medications: List<Medication> = emptyList()
)
