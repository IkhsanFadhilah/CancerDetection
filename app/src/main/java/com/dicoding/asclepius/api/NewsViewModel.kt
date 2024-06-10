package com.dicoding.asclepius.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewsViewModel : ViewModel() {
    private val newsRepository = NewsRepo()
    private val _newsList = MutableLiveData<List<ItemNews>>()
    val newsList: LiveData<List<ItemNews>> = _newsList
    fun fetchHealthNews() {
        newsRepository.getHealthNews(
            onSuccess = { newsList ->
                _newsList.postValue(newsList)
            },
            onFailure = { errorMessage ->
            }
        )
    }
}