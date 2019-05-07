package com.hubose.eniroapplication.di

import com.hubose.data.entity.Article
import com.hubose.data.mapper.NewsDataToNewsMapper
import com.hubose.data.repository.RemoteNewsRepository
import com.hubose.domain.NewsRepository
import com.hubose.domain.common.Mapper
import com.hubose.domain.entity.News
import com.hubose.domain.usecase.GetNews
import com.hubose.eniroapplication.common.AsyncTransformer
import com.hubose.eniroapplication.common.ImageLoader
import com.hubose.eniroapplication.common.PicassoImageLoader
import com.hubose.eniroapplication.list.ListViewModel
import com.squareup.picasso.Picasso
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModels = module {
    viewModel { ListViewModel(get()) }
}

val dataModule = module {
    single<NewsRepository> { RemoteNewsRepository(get(), get()) }
}

val mappers = module {
    factory<Mapper<Article, News>> { NewsDataToNewsMapper() }
}

val useCases = module {
    factory { GetNews(AsyncTransformer(), get()) }
}

val utils = module {
    single<ImageLoader> { PicassoImageLoader(Picasso.with(androidContext())) }
}