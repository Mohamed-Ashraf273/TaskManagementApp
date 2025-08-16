package com.example.taskmanagementapp.data.relations

import androidx.room.Entity

@Entity(primaryKeys = ["projectId", "taskId"])
data class ProjectTaskCrossRef(
    val projectId: Int,
    val taskId: Int
)
