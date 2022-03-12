package com.anawajha.phoneonyourhead.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.anawajha.phoneonyourhead.model.Category
import com.anawajha.phoneonyourhead.R

class CategoryAdapter(
    var activity: Activity,
    var categories: ArrayList<Category>,
    var click: OnClick
) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.img_category)
        var label: TextView = itemView.findViewById(R.id.tv_label)
        var cardView: CardView = itemView.findViewById(R.id.cv_category)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val root = LayoutInflater.from(activity).inflate(R.layout.category_item, parent, false)
        return ViewHolder(root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.label.text = categories[position].label
        holder.image.setImageResource(categories[position].image)
        holder.cardView.setCardBackgroundColor(categories[position].color)
        holder.cardView.setOnClickListener {
            click.onClickItem(holder.adapterPosition)
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    interface OnClick {
        fun onClickItem(position: Int)
    }

}