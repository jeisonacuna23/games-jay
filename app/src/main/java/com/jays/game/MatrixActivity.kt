package com.jays.game

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.boyoffi9.matrixrainview.MatrixRainView

class MatrixActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matrix)

        val rain = findViewById<MatrixRainView>(R.id.matrixRain)
        val prefs = getSharedPreferences("matrix_prefs", MODE_PRIVATE)

        // Aplicar los ajustes guardados (con valores por defecto)
        rain.charSet = MatrixRainView.CharSet.ALNUM
        
        // Convertimos los valores de las barras (0-30) a valores flotantes útiles para la vista
        rain.speed = prefs.getInt("speed", 10).toFloat() / 10f
        rain.density = prefs.getInt("density", 20).toFloat() / 10f
        
        // Color guardado
        rain.rainColor = prefs.getInt("color", Color.parseColor("#00FF41"))

        // Intentar ajustar el tamaño del texto si la librería lo soporta
        try {
            rain.textSize = prefs.getInt("size", 40).toFloat()
        } catch (e: Exception) {
            // Si la versión de la librería no tiene textSize, ignoramos el error
        }
    }
}
