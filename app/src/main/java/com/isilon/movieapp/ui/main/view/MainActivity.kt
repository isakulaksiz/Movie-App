package com.isilon.movieapp.ui.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.androidnetworking.AndroidNetworking
import com.isilon.movieapp.R


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidNetworking.initialize(applicationContext);


    }
}