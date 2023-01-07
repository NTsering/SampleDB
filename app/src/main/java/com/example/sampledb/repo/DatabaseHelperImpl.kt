package com.example.sampledb.repo

import com.example.sampledb.db.AppDatabase
import com.example.sampledb.db.User
import kotlinx.coroutines.flow.Flow

class DatabaseHelperImpl(
    private val appDatabase: AppDatabase
) : DatabaseHelper {
    override suspend fun getUsers(): List<User> = appDatabase.UserDao().getAll()
    override suspend fun insert(user: User) {
        appDatabase.UserDao().insert(user)
    }
}
