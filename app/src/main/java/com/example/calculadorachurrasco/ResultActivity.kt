package com.example.calculadorachurrasco

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
const val  Key_carne= "ResultActivity.KEY_CARNE"
const val Key_cerveja= "ResultActivity.KEY_CERVEJA"
const val Key_refrigerante= "ResultActivity.KEY_REFRIGERANTE"



class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)


        // recuperação de resultados
        val resultcarne = intent.getFloatExtra(Key_carne, 0f)
        val resultcerveja = intent.getFloatExtra( Key_cerveja, 0f)
        val resultrefrigerante = intent.getFloatExtra( Key_refrigerante, 0f)

        val carne = findViewById<TextView>(R.id.tv_carne)
        val carneFormat = String.format("%.2f", resultcarne)
        "${carneFormat}(kg)".also { carne.text = it }

        val cerveja = findViewById<TextView>(R.id.tv_cerveja)
        val cervejaFormat = String.format("%.2f", resultcerveja)
        "${cervejaFormat}(Litros)".also { cerveja.text = it }

        val refrigerante = findViewById<TextView>(R.id.tv_refrigerante)
        val refrigeranteFormat = String.format("%.2f", resultrefrigerante)
        "${refrigeranteFormat}(Litros)".also { refrigerante.text = it }


    }
}