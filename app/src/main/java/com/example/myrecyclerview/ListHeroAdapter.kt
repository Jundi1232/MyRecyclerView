package com.example.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListHeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.ListViewHorder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHorder {
      val view: View= LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero,parent,false)
        return ListViewHorder(view)
    }

    override fun onBindViewHolder(holder: ListViewHorder, position: Int) {
        val (name, decription, photo)=listHero[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvname.text=name
        holder.tvDescription.text=decription
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listHero[holder.adapterPosition]) }

    }

    override fun getItemCount(): Int = listHero.size

    class ListViewHorder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView=itemView.findViewById(R.id.img_item_photo)
        var tvname: TextView=itemView.findViewById(R.id.tv_item_name)
        var tvDescription: TextView=itemView.findViewById(R.id.tv_item_description)
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Hero)
    }
}