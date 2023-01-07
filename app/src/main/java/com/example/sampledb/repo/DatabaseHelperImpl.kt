package com.example.sampledb.repo

import com.example.sampledb.db.AppDatabase
import com.example.sampledb.db.User

class DatabaseHelperImpl(
    private val appDatabase: AppDatabase
) : DatabaseHelper {
    override suspend fun getUsers(): List<User> = appDatabase.UserDao().getAll()
    override suspend fun insert(user: User) {
        appDatabase.UserDao().insert(user)
    }
}
