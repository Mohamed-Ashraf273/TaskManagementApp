package com.example.taskmanagementapp
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.taskmanagementapp.data.AppDatabase
import com.example.taskmanagementapp.data.entity.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "task_management_db"
        ).build()

        val userDao = db.userDao()
        val projectDao = db.projectDao()
        val taskDao = db.taskDao()
        val attachmentDao = db.attachmentDao()

        lifecycleScope.launch(Dispatchers.IO) {
            val userId = userDao.insert(User(name = "Mohamed", email = "mohamed@mail.com"))
            Log.d("DB_TEST", "Inserted User $userId")

            val projectId = projectDao.insert(Project(title = "My First Project", ownerId = userId.toInt()))
            Log.d("DB_TEST", "Inserted Project $projectId")

            val taskId = taskDao.insert(Task(description = "Task 1", projectId = projectId.toInt()))
            Log.d("DB_TEST", "Inserted Task $taskId")

            val attachId = attachmentDao.insert(Attachment(filePath = "/storage/file.pdf", taskId = taskId.toInt()))
            Log.d("DB_TEST", "Inserted Attachment $attachId")

            val projects = projectDao.getAllProjectsOnce()
            Log.d("DAO_TEST", "Suspend projects: $projects")

            projectDao.getAllProjectsFlow().collect { list ->
                Log.d("DAO_TEST", "Flow emission: $list")
            }
        }

        setContent { /* UI not needed for DB test */ }
    }
}
