package com.zapata.bm_jetpackcompose.di

import android.content.Context
import androidx.room.Room
import com.zapata.bm_jetpackcompose.data.ToDoDatabase
import com.zapata.bm_jetpackcompose.utils.Constants
import com.zapata.bm_jetpackcompose.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/* 
 * @author Alberto Zapata
 *  nov 2021
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun providerDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        ToDoDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: ToDoDatabase) = database.toDoDao()
}