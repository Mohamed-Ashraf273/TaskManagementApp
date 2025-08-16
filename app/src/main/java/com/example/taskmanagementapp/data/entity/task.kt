package com.example.taskmanagementapp.data.entity

import androidx.room.*

@Entity(
    tableName = "tasks",
    indices = [Index("projectId")]
)
data class Task(
    @PrimaryKey(autoGenerate = true) val taskId: Int = 0,
    val description: String,
    val projectId: Int
)
