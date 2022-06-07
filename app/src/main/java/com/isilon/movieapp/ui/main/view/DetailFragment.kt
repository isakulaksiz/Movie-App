package com.isilon.movieapp.ui.main.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.isilon.movieapp.R
import com.isilon.movieapp.data.model.Result
import com.isilon.movieapp.databinding.FragmentDetailBinding
import com.isilon.movieapp.databinding.FragmentMainBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = arguments?.getString("name")
        val imageUrl = arguments?.getString("avatar")
        val description = arguments?.getString("detail")


        binding.tvDetailName.text = name
        binding.tvDetailPrice.text = description

        Glide.with(binding.ivDetailAvatar.context)
            .load(imageUrl)
            .into(binding.ivDetailAvatar)
        Log.e("dataName",name.toString())
        Log.e("dataAvatar",imageUrl.toString())
        Log.e("dataDescription",description.toString())
    }

}