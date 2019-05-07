package com.hubose.data.mapper

import com.hubose.data.entity.Article
import com.hubose.domain.common.Mapper
import com.hubose.domain.entity.News
import java.time.LocalDate
import java.util.*

class NewsDataToNewsMapper: Mapper<Article, News>(){

    override fun mapFrom(from: Article): News {
        return News(from.title, from.description, from.urlToImage, from.content, from.publishedAt)
    }
}