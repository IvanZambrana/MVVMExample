package com.accenture.mvvmexample.domain

import com.accenture.mvvmexample.data.QuoteRepository
import com.accenture.mvvmexample.data.model.QuoteModel
import com.accenture.mvvmexample.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository){

    suspend operator fun invoke(): Quote? {
        val quotes = repository.getAllQuotesFromDatabase()
        if (!quotes.isNullOrEmpty()) {
            val randonNumber: Int = (quotes.indices).random()
            return quotes[randonNumber]
        }
        return null
    }
}