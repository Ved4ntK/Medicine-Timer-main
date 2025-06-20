package com.Ved4ntK.Medicine-Timerapp

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.Ved4ntK.Medicine-Timerapp.analytics.AnalyticsHelper
import com.Ved4ntK.Medicine-Timerapp.domain.model.Medication
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class MedicationNotificationService @Inject constructor(
    @ApplicationContext private val context: Context
) {
    fun scheduleNotification(medication: Medication, analyticsHelper: AnalyticsHelper) {
        val alarmIntent = Intent(context, MedicationNotificationReceiver::class.java).apply {
            putExtra(MEDICATION_INTENT, medication)
        }

        val alarmPendingIntent = PendingIntent.getBroadcast(
            context,
            medication.id.toInt(),
            alarmIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val alarmService = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val time = medication.medicationTime.time

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            try {
                alarmService.setExactAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP,
                    time,
                    alarmPendingIntent
                )
            } catch (exception: SecurityException) {
                FirebaseCrashlytics.getInstance().recordException(exception)
            }
        }

        analyticsHelper.trackNotificationScheduled(medication)
    }

    companion object {
        const val MEDICATION_CHANNEL_ID = "medication_channel"
    }
}
