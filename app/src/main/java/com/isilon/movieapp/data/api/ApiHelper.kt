package com.isilon.movieapp.data.api

import android.util.Log
import com.isilon.movieapp.data.model.Model
import io.reactivex.Single

class ApiHelper(private val apiService: ApiService) {
    fun searchMoviesFromQuery(query: String, limit: Int): Single<Model>?  {
        Log.e("queryApiHelper",query)

        return apiService.getQuery(query, limit)
    }
}