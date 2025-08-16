package com.example.taskmanagementapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.taskmanagementapp.data.dao.*
import com.example.taskmanagementapp.data.entity.*
import com.example.taskmanagementapp.data.relations.ProjectTaskCrossRef
import com.example.taskmanagementapp.data.converters.Converters

@Database(
    entities = [User::class, Project::class, Task::class, Attachment::class, ProjectTaskCrossRef::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun projectDao(): ProjectDao
    abstract fun taskDao(): TaskDao
    abstract fun attachmentDao(): AttachmentDao
}
