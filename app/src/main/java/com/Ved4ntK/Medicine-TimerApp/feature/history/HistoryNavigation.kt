package com.Ved4ntK.Medicine-Timerapp.feature.history

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.Ved4ntK.Medicine-Timerapp.core.navigation.Medicine-TimerNavigationDestination
import com.Ved4ntK.Medicine-Timerapp.domain.model.Medication

object HistoryDestination : Medicine-TimerNavigationDestination {
    override val route = "history_route"
    override val destination = "history_destination"
}

fun NavGraphBuilder.historyGraph(bottomBarVisibility: MutableState<Boolean>, fabVisibility: MutableState<Boolean>, navigateToMedicationDetail: (Medication) -> Unit) {
    composable(route = HistoryDestination.route) {
        LaunchedEffect(null) {
            bottomBarVisibility.value = true
            fabVisibility.value = false
        }
        HistoryRoute(navigateToMedicationDetail)
    }
}
