package com.hubose.domain

import com.hubose.domain.entity.News
import io.reactivex.Single

interface NewsRepository{
    fun getNews(data: Array<String>?): Single<List<News>>
}