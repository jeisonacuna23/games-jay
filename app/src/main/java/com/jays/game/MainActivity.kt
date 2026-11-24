package com.jays.game

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.boyoffi9.matrixrainview.MatrixRainView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rain = findViewById<MatrixRainView>(R.id.matrixRain)
        
        // Usamos el conjunto predefinido ALNUM (letras y números)
        rain.charSet = MatrixRainView.CharSet.ALNUM
        
        // Estelas más largas: más densidad (columnas) y velocidad moderada
        rain.density = 2.5f 
        rain.speed = 0.8f   
        
        rain.rainColor = Color.parseColor("#00FF41")
    }
}
