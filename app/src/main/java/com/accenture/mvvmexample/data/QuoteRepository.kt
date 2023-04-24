package com.accenture.mvvmexample.data

import com.accenture.mvvmexample.data.model.QuoteModel
import com.accenture.mvvmexample.data.model.QuoteProvider
import com.accenture.mvvmexample.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api: QuoteService, private val quoteProvider: QuoteProvider){


    suspend fun getAllQuotes():List<QuoteModel>{
        val response:List<QuoteModel> = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}