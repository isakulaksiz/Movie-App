package com.isilon.movieapp.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.isilon.movieapp.data.api.ApiHelper
import com.isilon.movieapp.data.repository.ITunesRepository
import com.isilon.movieapp.ui.main.viewmodel.ITunesViewModel

class ViewModelFactory(private val apiHelper: ApiHelper): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ITunesViewModel::class.java))
            return ITunesViewModel(ITunesRepository(apiHelper)) as T
        throw IllegalArgumentException("Undefined Class name !")
    }

}