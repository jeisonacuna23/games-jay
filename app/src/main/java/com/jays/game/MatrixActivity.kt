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

        // Aplicar los ajustes guardados
        rain.charSet = MatrixRainView.CharSet.ALNUM
        rain.speed = prefs.getInt("speed", 10).toFloat() / 10f
        rain.density = prefs.getInt("density", 20).toFloat() / 10f
        rain.rainColor = prefs.getInt("color", Color.parseColor("#00FF41"))
    }
}
