package com.example.todoapp.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TodoModel::class], version = 1, exportSchema = false)
abstract class AppDatabase:RoomDatabase(){
    abstract val todosDao:TodosDao
    companion object{
        const val DATABASE_NAME = "db-todoapp"
    }
}