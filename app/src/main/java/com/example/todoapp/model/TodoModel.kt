package com.example.todoapp.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class TodoModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "title")
    val title:String = "Default title",
    @ColumnInfo(name = "description")
    val description:String = "Default description",
)