package com.example.practica5_2

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var solarList: MutableList<SolarItem>
    private lateinit var solarAdapter: SolarAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        solarList = mutableListOf(
            SolarItem("Corona Solar", R.drawable.corona_solar),
            SolarItem("Espiculas", R.drawable.espiculas),
            SolarItem("Filamentos", R.drawable.filamentos),
            SolarItem("Erupcion Solar", R.drawable.erupcionsolar),
            SolarItem("MAgnetoesfera", R.drawable.magnetosfera),
            SolarItem("MAnchasolar", R.drawable.manchasolar)
        )

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)


        solarAdapter = SolarAdapter(
            solarList,
            onItemCopied = { position ->  },
            onItemDeleted = { position ->  }
        )
        recyclerView.adapter = solarAdapter

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setOnMenuItemClickListener{
            when (it.itemId) {
                R.id.accion_comparar_planetas -> {
                    val intent = Intent(this, CompararPlanetas::class.java)
                    startActivity(intent)
                    true
                }
                else -> super.onOptionsItemSelected(it)
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity, menu)
        return true
    }

}
