package com.Ved4ntK.Medicine-Timerapp.util

import androidx.navigation.NavHostController

fun NavHostController.navigateSingleTop(route: String) {
    this.navigate(route) {
        popUpTo(route)
        launchSingleTop = true
    }
}
