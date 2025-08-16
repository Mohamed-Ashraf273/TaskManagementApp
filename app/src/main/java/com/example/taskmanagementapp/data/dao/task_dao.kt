package com.example.taskmanagementapp.data.dao

import androidx.room.*
import com.example.taskmanagementapp.data.entity.Task

@Dao
interface TaskDao {
    @Insert suspend fun insert(task: Task): Long
    @Query("SELECT * FROM tasks WHERE projectId = :projectId")
    suspend fun getTasksForProject(projectId: Int): List<Task>
}
