package com.isilon.movieapp.ui.main.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.isilon.movieapp.R
import com.isilon.movieapp.data.model.Result
import com.isilon.movieapp.ui.main.view.MainFragmentDirections

class ITunesAdapter(private val data: ArrayList<Result>) : RecyclerView.Adapter<ITunesAdapter.DataViewHolder>() {

    class DataViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textViewCollectionName: TextView
        val imageViewAvatar: ImageView
        init {
            textViewCollectionName = view.findViewById(R.id.tv_collectionName)
            imageViewAvatar = view.findViewById(R.id.imageViewAvatar)

        }

        fun bind(data: Result){

            textViewCollectionName.text = data.collectionName

            Glide.with(imageViewAvatar.context)
                .load(data.artworkUrl100)
                .into(imageViewAvatar)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent,false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnClickListener{

            val resultData = data[position]

            Log.e("adapter",resultData.collectionName)

            val action = MainFragmentDirections.actionMainFragmentToDetailFragment()
            action.name = resultData.collectionName
            action.avatar = resultData.artworkUrl100
            action.detail = resultData.collectionPrice.toString()
            val navController = Navigation.findNavController(holder.itemView)
            navController.navigate(action)
        }
    }

    override fun getItemCount(): Int {
        Log.d("count", data.size.toString())
        return data.size
    }

    fun addData(list: List<Result>) {
        Log.d("AddedData", data.addAll(list).toString())
        data.addAll(list)
    }

    fun changeData(newList: ArrayList<Result>){
        this.data.clear()
        this.data.addAll(newList)
        notifyDataSetChanged()
    }


}