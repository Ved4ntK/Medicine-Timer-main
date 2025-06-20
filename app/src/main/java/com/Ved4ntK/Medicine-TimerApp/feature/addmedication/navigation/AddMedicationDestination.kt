package com.Ved4ntK.Medicine-Timerapp.feature.addmedication.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.Ved4ntK.Medicine-Timerapp.core.navigation.Medicine-TimerNavigationDestination
import com.Ved4ntK.Medicine-Timerapp.domain.model.Medication
import com.Ved4ntK.Medicine-Timerapp.feature.addmedication.AddMedicationRoute
import com.Ved4ntK.Medicine-Timerapp.feature.home.navigation.ASK_ALARM_PERMISSION
import com.Ved4ntK.Medicine-Timerapp.feature.home.navigation.ASK_NOTIFICATION_PERMISSION

object AddMedicationDestination : Medicine-TimerNavigationDestination {
    override val route = "add_medication_route"
    override val destination = "add_medication_destination"
}

fun NavGraphBuilder.addMedicationGraph(navController: NavController, bottomBarVisibility: MutableState<Boolean>, fabVisibility: MutableState<Boolean>, onBackClicked: () -> Unit, navigateToMedicationConfirm: (List<Medication>) -> Unit) {
    composable(route = AddMedicationDestination.route) {
        LaunchedEffect(null) {
            bottomBarVisibility.value = false
            fabVisibility.value = false
        }

        navController.previousBackStackEntry?.savedStateHandle.apply {
            this?.set(ASK_NOTIFICATION_PERMISSION, true)
        }
        navController.previousBackStackEntry?.savedStateHandle.apply {
            this?.set(ASK_ALARM_PERMISSION, true)
        }
        AddMedicationRoute(onBackClicked, navigateToMedicationConfirm)
    }
}
