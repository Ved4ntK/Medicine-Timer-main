package com.Ved4ntK.Medicine-Timerapp.feature.home.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.Ved4ntK.Medicine-Timerapp.core.navigation.Medicine-TimerNavigationDestination
import com.Ved4ntK.Medicine-Timerapp.domain.model.Medication
import com.Ved4ntK.Medicine-Timerapp.feature.home.HomeRoute

const val ASK_NOTIFICATION_PERMISSION = "notification_permission"
const val ASK_ALARM_PERMISSION = "alarm_permission"
object HomeDestination : Medicine-TimerNavigationDestination {
    override val route = "home_route"
    override val destination = "home_destination"
}

fun NavGraphBuilder.homeGraph(navController: NavController, bottomBarVisibility: MutableState<Boolean>, fabVisibility: MutableState<Boolean>, navigateToMedicationDetail: (Medication) -> Unit) {
    composable(route = HomeDestination.route) {
        LaunchedEffect(null) {
            bottomBarVisibility.value = true
            fabVisibility.value = true
        }
        val askNotificationPermission = navController.currentBackStackEntry?.savedStateHandle?.get<Boolean>(ASK_NOTIFICATION_PERMISSION) ?: false
        val askAlarmPermission = navController.currentBackStackEntry?.savedStateHandle?.get<Boolean>(ASK_ALARM_PERMISSION) ?: false

        HomeRoute(navController, askNotificationPermission, askAlarmPermission, navigateToMedicationDetail)
    }
}
