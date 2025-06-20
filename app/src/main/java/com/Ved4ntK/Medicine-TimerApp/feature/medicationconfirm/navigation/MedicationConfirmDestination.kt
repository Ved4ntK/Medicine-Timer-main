package com.Ved4ntK.Medicine-Timerapp.feature.medicationconfirm.navigation

import android.os.Bundle
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.Ved4ntK.Medicine-Timerapp.core.navigation.Medicine-TimerNavigationDestination
import com.Ved4ntK.Medicine-Timerapp.domain.model.Medication
import com.Ved4ntK.Medicine-Timerapp.feature.medicationconfirm.MedicationConfirmRoute

const val MEDICATION = "medication"

object MedicationConfirmDestination : Medicine-TimerNavigationDestination {
    override val route = "medication_confirm_route"
    override val destination = "medication_confirm_destination"
}

fun NavGraphBuilder.medicationConfirmGraph(navController: NavController, bottomBarVisibility: MutableState<Boolean>, fabVisibility: MutableState<Boolean>, onBackClicked: () -> Unit, navigateToHome: () -> Unit) {

    composable(
        route = MedicationConfirmDestination.route,
    ) {
        LaunchedEffect(null) {
            bottomBarVisibility.value = false
            fabVisibility.value = false
        }
        val medicationBundle = navController.previousBackStackEntry?.savedStateHandle?.get<Bundle>(MEDICATION)
        val medicationList = medicationBundle?.getParcelableArrayList<Medication>(MEDICATION)
        MedicationConfirmRoute(medicationList, onBackClicked, navigateToHome)
    }
}
