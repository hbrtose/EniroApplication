package com.hubose.data.entity

import com.squareup.moshi.Json

data class NewsData(
    @Json(name = "articles")
    val articles: List<Article>,
    @Json(name = "status")
    val status: String,
    @Json(name = "totalResults")
    val totalResults: Int
)