package com.example.practica5_2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CompararPlanetas : AppCompatActivity() {

    private lateinit var planetaList: List<Planeta>
    private lateinit var adapter: ArrayAdapter<Planeta>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.comparar_planetas)

        planetaList = listOf(
            Planeta("Mercurio", 0.382, 0.387, 5400.0),
            Planeta("Venus", 0.949, 0.723, 5250.0),
            Planeta("Tierra", 1.0, 1.0, 5520.0),
            Planeta("Marte", 0.53, 1.542, 3960.0),
            Planeta("Júpiter", 11.2, 5.203, 1350.0),
            Planeta("Saturno", 9.41, 9.539, 700.0),
            Planeta("Urano", 3.38, 19.81, 1200.0),
            Planeta("Neptuno", 3.81, 30.07, 1500.0),
            Planeta("Plutón", 0.18, 39.44, 5.0)
        )

        adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, planetaList)

        val autoCompleteTextView1: AutoCompleteTextView = findViewById(R.id.autoCompleteTextView1)
        autoCompleteTextView1.setAdapter(adapter)
        autoCompleteTextView1.setOnItemClickListener { parent, _, position, _ ->
            val planetaSeleccionado = parent.getItemAtPosition(position) as Planeta
            mostrarDatos(planetaSeleccionado, 1)
        }

        val autoCompleteTextView2: AutoCompleteTextView = findViewById(R.id.autoCompleteTextView2)
        autoCompleteTextView2.setAdapter(adapter)
        autoCompleteTextView2.setOnItemClickListener { parent, _, position, _ ->
            val planetaSeleccionado = parent.getItemAtPosition(position) as Planeta
            mostrarDatos(planetaSeleccionado, 2)
        }
    }

    private fun mostrarDatos(planeta: Planeta, planetaSeleccionado: Int) {
        if (planetaSeleccionado == 1) {
            findViewById<TextView>(R.id.planet1Diametro).text = planeta.diametro.toString()
            findViewById<TextView>(R.id.planet1Distancia).text = planeta.distanciaAlSol.toString()
            findViewById<TextView>(R.id.planet1Densidad).text = planeta.densidad.toString()
        } else {
            findViewById<TextView>(R.id.planet2Diametro).text = planeta.diametro.toString()
            findViewById<TextView>(R.id.planet2Distancia).text = planeta.distanciaAlSol.toString()
            findViewById<TextView>(R.id.planet2Densidad).text = planeta.densidad.toString()
        }
    }
}
