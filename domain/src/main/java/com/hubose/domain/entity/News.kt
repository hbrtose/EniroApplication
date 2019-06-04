package com.hubose.domain.entity

data class News(
    var title: String,
    var description: String,
    var thumbnail: String?,
    var content: String,
    var date: String
)