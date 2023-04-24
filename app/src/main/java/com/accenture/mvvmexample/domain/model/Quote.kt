package com.accenture.mvvmexample.domain.model

import com.accenture.mvvmexample.data.database.entities.QuoteEntity
import com.accenture.mvvmexample.data.model.QuoteModel

data class Quote(val quote: String, val author: String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)
