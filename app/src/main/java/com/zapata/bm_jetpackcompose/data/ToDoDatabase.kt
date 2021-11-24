package com.zapata.bm_jetpackcompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zapata.bm_jetpackcompose.data.models.ToDoTask

/* 
 * @author Alberto Zapata
 *  nov 2021
 */
@Database(entities = [ToDoTask::class], version = 1, exportSchema = false)
abstract class ToDoDatabase: RoomDatabase() {
    abstract fun toDoDao(): ToDoDao
}