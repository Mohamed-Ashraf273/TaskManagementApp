package com.example.taskmanagementapp.data.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.taskmanagementapp.data.entity.Project
import com.example.taskmanagementapp.data.entity.Task

data class ProjectWithTasks(
    @Embedded val project: Project,
    @Relation(
        parentColumn = "projectId",
        entityColumn = "taskId",
        associateBy = Junction(ProjectTaskCrossRef::class)
    )
    val tasks: List<Task>
)
