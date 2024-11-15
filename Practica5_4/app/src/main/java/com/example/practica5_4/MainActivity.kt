package com.example.practica5_4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val coffeeShops = listOf(
            CoffeShop("Antico Caffè Greco", "St. Italy, Rome", 4.5f, R.drawable.images),
            CoffeShop("La Colombe", "Philadelphia, USA", 4.7f, R.drawable.images1),
            CoffeShop("Café de Flore", "Paris, France", 4.3f, R.drawable.images2),
            CoffeShop("Caffè Florian", "Venice, Italy", 4.6f, R.drawable.images3),
            CoffeShop("Blue Bottle Coffee", "Tokyo, Japan", 4.8f, R.drawable.images4),
            CoffeShop("Tim Wendelboe", "Oslo, Norway", 4.9f, R.drawable.images5),
            CoffeShop("Stumptown Coffee Roasters", "Portland, USA", 4.4f, R.drawable.images6)
        )

        recyclerView.adapter = CoffeAdapter(coffeeShops)
    }
}
