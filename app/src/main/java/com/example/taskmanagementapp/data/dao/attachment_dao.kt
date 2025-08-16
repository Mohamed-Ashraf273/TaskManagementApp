package com.example.taskmanagementapp.data.dao

import androidx.room.*
import com.example.taskmanagementapp.data.entity.Attachment

@Dao
interface AttachmentDao {
    @Insert suspend fun insert(attachment: Attachment): Long
    @Query("SELECT * FROM attachments WHERE taskId = :taskId")
    suspend fun getAttachmentsForTask(taskId: Int): List<Attachment>
}
