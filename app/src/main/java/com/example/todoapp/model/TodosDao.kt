@file:Suppress("AndroidUnresolvedRoomSqlReference")

package com.example.todoapp.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodosDao {
    @Insert
    fun addTodo(todo: TodoModel)

    @Query("SELECT * FROM todo")
    fun getAllTodos(): List<TodoModel>
}