package com.accenture.mvvmexample.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.accenture.mvvmexample.data.database.dao.QuoteDao
import com.accenture.mvvmexample.data.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase:RoomDatabase() {
    abstract fun getQuoteDao():QuoteDao
}