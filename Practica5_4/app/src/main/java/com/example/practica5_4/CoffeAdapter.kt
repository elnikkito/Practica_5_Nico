package com.example.practica5_4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CoffeAdapter(private val coffeeShops: List<CoffeShop>) :
    RecyclerView.Adapter<CoffeAdapter.CoffeeShopViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeShopViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_coffeshop, parent, false)
        return CoffeeShopViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoffeeShopViewHolder, position: Int) {
        val coffeeShop = coffeeShops[position]
        holder.bind(coffeeShop)
    }

    override fun getItemCount(): Int = coffeeShops.size

    inner class CoffeeShopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imagen: ImageView = itemView.findViewById(R.id.imagen)
        private val texto: TextView = itemView.findViewById(R.id.texto)
        private val ratingBar: RatingBar = itemView.findViewById(R.id.ratingBar)
        private val ratingValor: TextView = itemView.findViewById(R.id.ratingValor)
        private val location: TextView = itemView.findViewById(R.id.location)
        private val botonReservar: Button = itemView.findViewById(R.id.botonReservar)

        fun bind(coffeeShop: CoffeShop) {
            texto.text = coffeeShop.name
            location.text = coffeeShop.location
            ratingValor.text = coffeeShop.rating.toString()
            ratingBar.rating = coffeeShop.rating

            Glide.with(itemView.context).load(coffeeShop.image).into(imagen)

            ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
                ratingValor.text = rating.toString()
            }

            botonReservar.setOnClickListener {

            }
        }
    }
}
