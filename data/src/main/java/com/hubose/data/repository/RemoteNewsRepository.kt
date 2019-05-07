package com.hubose.data.repository

import com.hubose.data.api.Api
import com.hubose.data.entity.Article
import com.hubose.domain.NewsRepository
import com.hubose.domain.common.Mapper
import com.hubose.domain.entity.News
import io.reactivex.Single

class RemoteNewsRepository(private val api: Api, private val mapper: Mapper<Article, News>): NewsRepository{
    override fun getNews(data: Array<String>?): Single<List<News>> {
        return data?.let {
            api.getNewsQuery(data.joinToString(",")).map { result -> result.articles.map { mapper.mapFrom(it) }}
        } ?: api.getNews().map { result -> result.articles.map { mapper.mapFrom(it) }}
    }
}