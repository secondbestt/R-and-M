package com.reddit.rickandmortyapp.noncompose

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reddit.rickandmortyapp.Utils.downloadfromUrl
import com.reddit.rickandmortyapp.Utils.placeholderProgressBar
import com.reddit.rickandmortyapp.R
import com.reddit.rickandmortyapp.model.Result
import kotlinx.android.synthetic.main.row_layout.view.*


class RecyclerViewAdapter(private val apiList : ArrayList<Result>) : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {
    class RowHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(apiModel: Result, position: Int){
            itemView.text1.text =apiModel.name
            itemView.text2.text =apiModel.gender
            itemView.text3.text =apiModel.created
            itemView.text4.text =apiModel.status
            itemView.text5.text =apiModel.origin.name
            itemView.imageview.downloadfromUrl(apiModel.image, placeholderProgressBar(itemView.context))
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false)
        return RowHolder(view)
    }
    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(apiList[position],position)
    }
    override fun getItemCount(): Int {
        return apiList.size
    }
}