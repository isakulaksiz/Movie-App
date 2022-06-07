package com.isilon.movieapp.data.api

import com.isilon.movieapp.data.model.Model
import io.reactivex.Single

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @GET("")
    fun getQuery(
        @Query("term") term: String,
        @Query("limit") limit: Int
    ): Single<Model>
}