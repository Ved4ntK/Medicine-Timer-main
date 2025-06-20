package com.Ved4ntK.Medicine-Timerapp.di

import android.content.Context
import com.Ved4ntK.Medicine-Timerapp.MedicationNotificationService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NotificationModule {
    @Provides
    @Singleton
    fun provideMedicationNotificationService(
        @ApplicationContext context: Context,
    ): MedicationNotificationService = MedicationNotificationService(context)
}
