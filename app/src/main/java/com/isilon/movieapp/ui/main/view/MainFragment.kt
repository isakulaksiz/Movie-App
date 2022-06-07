package com.isilon.movieapp.ui.main.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.isilon.movieapp.R
import com.isilon.movieapp.data.api.ApiHelper
import com.isilon.movieapp.data.api.ApiServiceImpl
import com.isilon.movieapp.data.model.Result
import com.isilon.movieapp.databinding.FragmentMainBinding
import com.isilon.movieapp.ui.base.ViewModelFactory
import com.isilon.movieapp.ui.main.adapter.ITunesAdapter
import com.isilon.movieapp.ui.main.viewmodel.ITunesViewModel
import com.isilon.movieapp.utils.Status

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var mainViewModel: ITunesViewModel
    private lateinit var adapter: ITunesAdapter


    private lateinit var temp: String
    var limit: Int =20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpUI()
        setUpViewModel()
        setUpObserver()


        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    mainViewModel.fetchPosts(query, limit)
                    temp = query
                }

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    mainViewModel.fetchPosts(newText,limit)
                    temp = newText
                }

                return false
            }
        })


        binding.scrollView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight) {
                limit += 2
                binding.progressBar.visibility = View.VISIBLE
                mainViewModel.fetchPosts(temp, limit)
            }
        })

    }

    private fun setUpObserver() {
        mainViewModel.data.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    it.data?.let { data -> renderList(data.results) }
                    Log.e("STATUS/OK", it.toString())
                    binding.recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                }

                Status.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    Log.e("STATUS/ERR", it.toString())
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun setUpViewModel() {
        //val apiService: ApiService
        mainViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(ApiServiceImpl()))
        )
            .get(ITunesViewModel::class.java)
    }

    private fun setUpUI() {
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(),3,GridLayoutManager.VERTICAL,false)
        adapter = ITunesAdapter(arrayListOf())
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerView.context,
                (binding.recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )

        binding.recyclerView.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun renderList(data: List<Result>) {
        val list = ArrayList<Result>()
        list.addAll(data)
        adapter.changeData(list)
    }
}