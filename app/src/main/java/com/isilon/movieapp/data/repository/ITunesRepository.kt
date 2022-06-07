package com.isilon.movieapp.data.repository

import android.util.Log
import com.isilon.movieapp.data.api.ApiHelper
import com.isilon.movieapp.data.model.Model
import io.reactivex.Single

class ITunesRepository(private val apiHelper: ApiHelper) {
    fun searchMoviesFromQuery(query: String, limit: Int): Single<Model>? {
        Log.e("queryRepository",query)
        return apiHelper.searchMoviesFromQuery(query, limit)
    }
}