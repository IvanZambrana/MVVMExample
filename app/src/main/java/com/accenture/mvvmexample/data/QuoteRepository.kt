package com.accenture.mvvmexample.data

import com.accenture.mvvmexample.data.database.dao.QuoteDao
import com.accenture.mvvmexample.data.database.entities.QuoteEntity
import com.accenture.mvvmexample.data.model.QuoteModel
import com.accenture.mvvmexample.data.network.QuoteService
import com.accenture.mvvmexample.domain.model.Quote
import com.accenture.mvvmexample.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
) {


    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response: List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote> {
        val response = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}