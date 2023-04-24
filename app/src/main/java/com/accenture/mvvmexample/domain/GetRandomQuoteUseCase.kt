package com.accenture.mvvmexample.domain

import com.accenture.mvvmexample.data.model.QuoteModel
import com.accenture.mvvmexample.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val quoteProvider: QuoteProvider){

    operator fun invoke(): QuoteModel? {
        val quotes: List<QuoteModel> = quoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            val randonNumber: Int = (0..quotes.size - 1).random()
            return quotes[randonNumber]
        }
        return null
    }
}