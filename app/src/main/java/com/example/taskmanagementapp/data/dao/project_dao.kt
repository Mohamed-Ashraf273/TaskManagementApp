package com.example.taskmanagementapp.data.dao

import androidx.room.*
import com.example.taskmanagementapp.data.entity.Project
import com.example.taskmanagementapp.data.relations.ProjectWithTasks
import kotlinx.coroutines.flow.Flow

@Dao
interface ProjectDao {
    @Insert suspend fun insert(project: Project): Long

    @Query("SELECT * FROM projects")
    suspend fun getAllProjectsOnce(): List<Project>

    @Query("SELECT * FROM projects")
    fun getAllProjectsFlow(): Flow<List<Project>>

    @Transaction
    @Query("SELECT * FROM projects WHERE projectId = :projectId")
    suspend fun getProjectWithTasks(projectId: Int): ProjectWithTasks
}
