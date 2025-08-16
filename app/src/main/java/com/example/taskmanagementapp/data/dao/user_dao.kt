package com.example.taskmanagementapp.data.dao

import androidx.room.*
import com.example.taskmanagementapp.data.entity.User

@Dao
interface UserDao {
    @Insert suspend fun insert(user: User): Long
    @Query("SELECT * FROM users") suspend fun getAll(): List<User>
}
