package com.hubose.domain.usecase

import com.hubose.domain.NewsRepository
import com.hubose.domain.common.Transformer
import com.hubose.domain.common.UseCase
import com.hubose.domain.entity.News
import io.reactivex.Single

class GetNews(transfomer: Transformer<List<News>>,
              private val repository: NewsRepository): UseCase<Array<String>, List<News>>(transfomer){

    override fun createObservable(data: Array<String>?): Single<List<News>> {
        return repository.getNews(data)
    }
}