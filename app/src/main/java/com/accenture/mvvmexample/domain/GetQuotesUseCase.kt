package com.accenture.mvvmexample.domain

import com.accenture.mvvmexample.data.QuoteRepository
import com.accenture.mvvmexample.data.database.entities.toDatabase
import com.accenture.mvvmexample.data.model.QuoteModel
import com.accenture.mvvmexample.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {


    suspend operator fun invoke(): List<Quote> {
        val quotes = repository.getAllQuotesFromApi()

        return if (quotes.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase()})
            quotes
        }else{
            repository.getAllQuotesFromDatabase()
        }
    }

}