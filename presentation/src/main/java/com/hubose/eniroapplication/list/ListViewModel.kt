package com.hubose.eniroapplication.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hubose.domain.entity.News
import com.hubose.domain.usecase.GetNews
import com.hubose.eniroapplication.common.BaseViewModel

class ListViewModel(getNews: GetNews) : BaseViewModel() {

    private var itemsData: MutableLiveData<List<News>> = MutableLiveData()
    private val arguments = arrayOf("sport", "business")

    init {
        addDisposable(
            getNews.observable(arguments).subscribe(
                {
                    itemsData.value = it
                }, {
                    error.value = it
                }
            )
        )
    }

    fun getData(): LiveData<List<News>>{
        return itemsData
    }
}