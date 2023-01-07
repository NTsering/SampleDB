package com.example.sampledb.views.di

import android.content.Context
import androidx.room.Room
import com.example.sampledb.db.AppDatabase
import com.example.sampledb.repo.DatabaseHelper
import com.example.sampledb.repo.DatabaseHelperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Provides
    fun provideDBHelper(appDatabase: AppDatabase): DatabaseHelper {
        return DatabaseHelperImpl(appDatabase)
    }

    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "sample-app-database"
        ).build()
    }
}
