package com.hubose.eniroapplication.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.hubose.domain.entity.News
import com.hubose.eniroapplication.R
import com.hubose.eniroapplication.common.ImageLoader
import kotlinx.android.synthetic.main.item_list.view.*

class ListAdapter(owner: LifecycleOwner,
                  liveData: LiveData<List<News>>,
                  private val imageLoader: ImageLoader,
                  private val onItemClicked: (String) -> Unit): RecyclerView.Adapter<ListAdapter.ItemHolder>(){

    private val items = mutableListOf<News>()

    init {
        liveData.observe(owner, Observer {
            items.clear()
            items.addAll(it)
            notifyDataSetChanged()
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ItemHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(items[position], onItemClicked, imageLoader)
    }

    class ItemHolder(private val view: View): RecyclerView.ViewHolder(view){
        fun bind(item: News, listener: (String) -> Unit, imageLoader: ImageLoader){
            view.tv_item_title.text = item.title
            view.tv_item_desc.text = item.description
            view.tv_item_date.text = item.date
            item.thumbnail?.let {
                view.iv_item_image.visibility = View.VISIBLE
                imageLoader.load(it, view.iv_item_image)
            }
            view.setOnClickListener { listener(item.content) }
        }
    }
}