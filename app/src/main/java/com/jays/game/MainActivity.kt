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
        
        // Caracteres en español (mayúsculas, números y símbolos)
        rain.charSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789#$%&@".toCharArray()
        
        // Estelas más largas: aumentamos la densidad y bajamos un poco la velocidad
        rain.density = 2.0f 
        rain.speed = 0.8f   
        
        rain.rainColor = Color.parseColor("#00FF41")
    }
}
