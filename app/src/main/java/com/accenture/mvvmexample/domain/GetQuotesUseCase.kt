package com.accenture.mvvmexample.domain

import com.accenture.mvvmexample.data.QuoteRepository
import com.accenture.mvvmexample.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()

}