package com.example.helpai.data.DataSourse

import android.R
import androidx.compose.ui.semantics.Role
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "message")
data class ChatMessageEntity(

    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val role: String,
    val text: String,
    val timestamp: Long = System.currentTimeMillis()

)
