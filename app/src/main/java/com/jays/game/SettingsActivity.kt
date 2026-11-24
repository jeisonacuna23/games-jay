package com.jays.game

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        
        prefs = getSharedPreferences("matrix_prefs", MODE_PRIVATE)

        val seekSpeed = findViewById<SeekBar>(R.id.seekSpeed)
        val seekDensity = findViewById<SeekBar>(R.id.seekDensity)
        val seekSize = findViewById<SeekBar>(R.id.seekSize)

        // Cargar valores guardados (por defecto: speed=10, density=20, size=40)
        seekSpeed.progress = prefs.getInt("speed", 10)
        seekDensity.progress = prefs.getInt("density", 20)
        seekSize.progress = prefs.getInt("size", 40)
        
        var selectedColor = prefs.getInt("color", Color.parseColor("#00FF41"))

        // Guardar color seleccionado temporalmente
        val colorButtons = mapOf(
            findViewById<Button>(R.id.btnColorGreen) to Color.parseColor("#00FF41"),
            findViewById<Button>(R.id.btnColorRed) to Color.parseColor("#FF0000"),
            findViewById<Button>(R.id.btnColorBlue) to Color.parseColor("#0000FF"),
            findViewById<Button>(R.id.btnColorPurple) to Color.parseColor("#9B59B6")
        )

        for ((button, color) in colorButtons) {
            button.setOnClickListener { selectedColor = color }
        }

        findViewById<Button>(R.id.btnSave).setOnClickListener {
            val editor = prefs.edit()
            editor.putInt("speed", seekSpeed.progress)
            editor.putInt("density", seekDensity.progress)
            editor.putInt("size", seekSize.progress)
            editor.putInt("color", selectedColor)
            editor.apply()

            Toast.makeText(this, "Ajustes guardados", Toast.LENGTH_SHORT).show()
            finish() // Vuelve al menú
        }
    }
}
