package com.devspace.taskbeats

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDao {


    @Query("SELECT * FROM taskentity")
    fun getAll(): List<TaskEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(taskEntities: List<TaskEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(taskEntity: TaskEntity)

    @Update
    fun update(taskEntity: TaskEntity)

    @Delete
    fun delete(taskEntity: TaskEntity)

    @Query("SELECT * FROM taskentity where category is :categoryName")
    fun getAllByCategory(categoryName: String): List<TaskEntity>

    @Delete
    fun deleteAll(taskEntity: List<TaskEntity>)
}