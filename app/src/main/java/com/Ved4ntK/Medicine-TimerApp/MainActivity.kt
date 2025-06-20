package com.Ved4ntK.Medicine-Timerapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.Ved4ntK.Medicine-Timerapp.analytics.AnalyticsEvents
import com.Ved4ntK.Medicine-Timerapp.analytics.AnalyticsHelper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var analyticsHelper: AnalyticsHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Medicine-TimerApp(analyticsHelper = analyticsHelper)
        }
        parseIntent(intent)
    }

    private fun parseIntent(intent: Intent?) {
        val isMedicationNotification = intent?.getBooleanExtra(MEDICATION_NOTIFICATION, false) ?: false
        if (isMedicationNotification) {
            analyticsHelper.logEvent(AnalyticsEvents.REMINDER_NOTIFICATION_CLICKED)
        }
    }
}
