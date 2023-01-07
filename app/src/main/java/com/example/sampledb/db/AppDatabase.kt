package com.example.sampledb.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sampledb.db.dao.UserDao

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun UserDao(): UserDao
}
