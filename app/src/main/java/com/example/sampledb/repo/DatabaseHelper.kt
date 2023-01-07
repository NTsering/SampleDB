package com.example.sampledb.repo

import com.example.sampledb.db.User

interface DatabaseHelper {
    suspend fun getUsers(): List<User>
    suspend fun insert(user: User)
}
