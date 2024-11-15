package com.example.practica5_2

data class Planeta(
    val nombre: String,
    val diametro: Double,
    val distanciaAlSol: Double,
    val densidad: Double
) {
    override fun toString(): String {
        return nombre
    }
}
