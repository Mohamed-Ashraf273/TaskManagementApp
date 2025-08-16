package com.example.taskmanagementapp.data.entity

import androidx.room.*

@Entity(
    tableName = "projects",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["userId"],
            childColumns = ["ownerId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("ownerId")]
)
data class Project(
    @PrimaryKey(autoGenerate = true) val projectId: Int = 0,
    val title: String,
    val ownerId: Int
)
