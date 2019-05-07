package com.hubose.data.entity

import com.squareup.moshi.Json

data class Source(
    @Json(name = "id")
    val id: String,
    @Json(name = "name")
    val name: String
)