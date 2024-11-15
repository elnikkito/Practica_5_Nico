package com.example.practica5_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView

class SolarAdapter(
    private val solarList: MutableList<SolarItem>,
    private val onItemCopied: (position: Int) -> Unit,
    private val onItemDeleted: (position: Int) -> Unit
) : RecyclerView.Adapter<SolarAdapter.SolarViewHolder>() {

    inner class SolarViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.solarImage)
        val toolbar: Toolbar = view.findViewById(R.id.toolbarSolar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SolarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_solar, parent, false)
        return SolarViewHolder(view)
    }

    override fun onBindViewHolder(holder: SolarViewHolder, position: Int) {
        val solarItem = solarList[position]
        holder.imageView.setImageResource(solarItem.imageResId)
        holder.toolbar.title = solarItem.name


        holder.toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_copy -> {
                    val copiedItem = SolarItem(solarItem.name + " (Copia)", solarItem.imageResId)
                    solarList.add(position + 1, copiedItem)
                    notifyItemInserted(position + 1)
                    onItemCopied(position)
                    true
                }
                R.id.action_delete -> {
                    solarList.removeAt(position)
                    notifyItemRemoved(position)
                    onItemDeleted(position)
                    true
                }

                else -> false
            }
        }
    }

    override fun getItemCount(): Int = solarList.size
}
