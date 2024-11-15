package com.example.practica5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageSwitcher
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(
    private val images: List<Int>,
    private val imageSwitcher: ImageSwitcher
) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageResource = images[position]
        holder.imageView.setImageResource(imageResource)

        holder.itemView.setOnClickListener {
            imageSwitcher.setImageResource(imageResource)
        }
    }

    override fun getItemCount(): Int = images.size
}
