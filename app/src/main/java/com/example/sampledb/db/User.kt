package com.example.sampledb.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0,
    @ColumnInfo(name = "name")
    val name: String?
//    @ColumnInfo(name = "last_name")
//    val lastName: String?
//    val lastName: String?
)
