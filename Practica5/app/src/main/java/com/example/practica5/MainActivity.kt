
package com.example.practica5

import android.os.Bundle
import android.widget.ImageSwitcher
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val images = listOf(
            R.drawable.image1, R.drawable.image2, R.drawable.image3,
            R.drawable.image4, R.drawable.image5, R.drawable.image6,
            R.drawable.image7, R.drawable.image8, R.drawable.image9,
            R.drawable.image10
        )


        val imageSwitcher: ImageSwitcher = findViewById(R.id.imageSwitcher)
        imageSwitcher.setFactory {
            val imageView = ImageView(this)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView
        }


        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = ImageAdapter(images, imageSwitcher)
    }
}
