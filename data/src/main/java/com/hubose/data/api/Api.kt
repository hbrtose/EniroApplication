package com.hubose.data.api

import com.hubose.data.entity.NewsData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Api{

    @GET("everything")
    fun getNewsQuery(@Query("q") query: String): Single<NewsData>

    @GET("everything")
    fun getNews(): Single<NewsData>
}