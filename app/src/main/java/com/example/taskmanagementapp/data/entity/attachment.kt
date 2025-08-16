package com.example.taskmanagementapp.data.entity

import androidx.room.*

@Entity(
    tableName = "attachments",
    foreignKeys = [
        ForeignKey(
            entity = Task::class,
            parentColumns = ["taskId"],
            childColumns = ["taskId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("taskId")]
)
data class Attachment(
    @PrimaryKey(autoGenerate = true) val attachmentId: Int = 0,
    val filePath: String,
    val taskId: Int
)
