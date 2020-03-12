package com.bishwajeet.newsreader.view.news.fragmentNewsReader

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class NewsReaderViewModel @Inject constructor(): ViewModel() {

    private var _url = MutableLiveData<String>()

    var url: LiveData<String>
        get() {
            return _url
        }
        set(value) {
            _url.value = value.value
        }


    fun saveUrl(url: String?) {
        _url.value = url
    }
}