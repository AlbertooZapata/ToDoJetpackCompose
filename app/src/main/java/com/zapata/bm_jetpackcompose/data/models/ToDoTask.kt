package com.zapata.bm_jetpackcompose.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zapata.bm_jetpackcompose.utils.Constants.DATABASE_TABLE

/* 
 * @author Alberto Zapata
 *  nov 2021
 */
@Entity(tableName = DATABASE_TABLE)
data class ToDoTask(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: Priority
)