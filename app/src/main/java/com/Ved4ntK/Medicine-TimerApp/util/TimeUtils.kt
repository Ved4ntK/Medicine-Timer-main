package com.Ved4ntK.Medicine-Timerapp.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.Ved4ntK.Medicine-Timerapp.R
import com.Ved4ntK.Medicine-Timerapp.domain.model.Medication
import com.Ved4ntK.Medicine-Timerapp.extension.toFormattedDateString
import java.util.Calendar
import java.util.concurrent.TimeUnit
import kotlin.math.abs

const val HOUR_MINUTE_FORMAT = "h:mm a"
@Composable
fun getTimeRemaining(medication: Medication): String {
    val currentTime = Calendar.getInstance().time
    val dateBefore = medication.medicationTime
    val timeDiff = abs(currentTime.time - dateBefore.time)

    // If the medication is scheduled for a future date, display days remaining
    if (medication.medicationTime.toFormattedDateString() != medication.endDate.toFormattedDateString()) {
        val daysRemaining = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS) + 1L
        return stringResource(id = R.string.time_remaining, daysRemaining, stringResource(id = R.string.days))
    }

    // If the medication is scheduled for today, calculate time remaining in hours and minutes
    val hoursRemaining = TimeUnit.HOURS.convert(timeDiff, TimeUnit.MILLISECONDS)
    val minutesRemaining = TimeUnit.MINUTES.convert(timeDiff, TimeUnit.MILLISECONDS)
    return when {
        hoursRemaining > 1 -> stringResource(id = R.string.time_remaining, hoursRemaining, stringResource(id = R.string.hours))
        minutesRemaining > 1 -> stringResource(id = R.string.time_remaining, minutesRemaining, stringResource(id = R.string.days))
        else -> stringResource(id = R.string.take_Medicine-Timer_now)
    }
}
