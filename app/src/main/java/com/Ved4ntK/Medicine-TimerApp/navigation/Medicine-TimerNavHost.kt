package com.Ved4ntK.Medicine-Timerapp.navigation

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.Ved4ntK.Medicine-Timerapp.feature.addmedication.navigation.addMedicationGraph
import com.Ved4ntK.Medicine-Timerapp.feature.calendar.navigation.calendarGraph
import com.Ved4ntK.Medicine-Timerapp.feature.history.historyGraph
import com.Ved4ntK.Medicine-Timerapp.feature.home.navigation.HomeDestination
import com.Ved4ntK.Medicine-Timerapp.feature.home.navigation.homeGraph
import com.Ved4ntK.Medicine-Timerapp.feature.medicationconfirm.navigation.MEDICATION
import com.Ved4ntK.Medicine-Timerapp.feature.medicationconfirm.navigation.MedicationConfirmDestination
import com.Ved4ntK.Medicine-Timerapp.feature.medicationconfirm.navigation.medicationConfirmGraph
import com.Ved4ntK.Medicine-Timerapp.feature.medicationdetail.MedicationDetailDestination
import com.Ved4ntK.Medicine-Timerapp.feature.medicationdetail.medicationDetailGraph
import com.Ved4ntK.Medicine-Timerapp.util.navigateSingleTop

@Composable
fun Medicine-TimerNavHost(
    bottomBarVisibility: MutableState<Boolean>,
    fabVisibility: MutableState<Boolean>,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = HomeDestination.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        homeGraph(
            navController = navController,
            bottomBarVisibility = bottomBarVisibility,
            fabVisibility = fabVisibility,
            navigateToMedicationDetail = { medication ->
                navController.navigate(
                    MedicationDetailDestination.createNavigationRoute(medication.id)
                )
            }
        )
        historyGraph(
            bottomBarVisibility = bottomBarVisibility,
            fabVisibility = fabVisibility,
            navigateToMedicationDetail = { medication ->
                navController.navigate(
                    MedicationDetailDestination.createNavigationRoute(medication.id)
                )
            }
        )
        medicationDetailGraph(
            bottomBarVisibility = bottomBarVisibility,
            fabVisibility = fabVisibility,
            onBackClicked = { navController.navigateUp() }
        )
        calendarGraph(bottomBarVisibility, fabVisibility)
        addMedicationGraph(
            navController = navController,
            bottomBarVisibility = bottomBarVisibility,
            fabVisibility = fabVisibility,
            onBackClicked = { navController.navigateUp() },
            navigateToMedicationConfirm = {
                // TODO: Replace with medication id
                val bundle = Bundle()
                bundle.putParcelableArrayList(MEDICATION, ArrayList(it))
                navController.currentBackStackEntry?.savedStateHandle.apply {
                    this?.set(MEDICATION, bundle)
                }
                navController.navigate(MedicationConfirmDestination.route)
            }
        )
        medicationConfirmGraph(
            navController = navController,
            bottomBarVisibility = bottomBarVisibility,
            fabVisibility = fabVisibility,
            onBackClicked = { navController.navigateUp() },
            navigateToHome = {
                navController.navigateSingleTop(HomeDestination.route)
            }
        )
    }
}
