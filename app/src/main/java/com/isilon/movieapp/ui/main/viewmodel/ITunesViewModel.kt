package com.isilon.movieapp.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.isilon.movieapp.data.model.Model
import com.isilon.movieapp.data.repository.ITunesRepository
import com.isilon.movieapp.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ITunesViewModel(private val iTunesRepository: ITunesRepository) : ViewModel(){
    val data = MutableLiveData<Resource<Model>>()
    private val compositeDisposable = CompositeDisposable()

     fun fetchPosts(q: String, limit: Int) {
        data.postValue(Resource.loading(null))
         Log.e("queryViewModel",q)
        iTunesRepository.searchMoviesFromQuery(q,limit)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())?.let {
                compositeDisposable.add(
                it.subscribe({ model ->
                        data.value = Resource.success(model)
                        Log.e("movieList", model.toString())
                    }, {
                        Log.e("ERR",data.value.toString())
                        data.value= Resource.error("Something went wrong", null)
                    })
            )
            }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun searchQuery(): MutableLiveData<Resource<Model>> {
        return data
    }
}