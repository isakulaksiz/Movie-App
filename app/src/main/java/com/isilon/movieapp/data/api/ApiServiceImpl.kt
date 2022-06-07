package com.isilon.movieapp.data.api

import com.isilon.movieapp.data.model.Model
import com.isilon.movieapp.utils.Constants
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single

class ApiServiceImpl : ApiService{
    override fun getQuery(term: String, limit: Int): Single<Model> {

        return Rx2AndroidNetworking.get(Constants.BASE_URL)
            .addQueryParameter("term",term)
            .addQueryParameter("limit", limit.toString())
            .build()
            .getObjectSingle(Model::class.java)
    }

}