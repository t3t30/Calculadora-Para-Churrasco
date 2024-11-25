package com.example.calculadorachurrasco

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        // colocar variantes:

        val adultosquebebem = findViewById<TextInputEditText>(R.id.adultosquebebem)
        val adultosquenaobebem = findViewById<TextInputEditText>(R.id.adultosquenaobebem)
        val criancas1 = findViewById<TextInputEditText>(R.id.crianças)
        val duracao1 = findViewById<TextInputEditText>(R.id.duração)


        // conectar botao
        // calculo ativado por botão:

        val btncalcular = findViewById<Button>(R.id.button) //conectado
        //calculo:
        btncalcular.setOnClickListener {
            val adultos1str: String = adultosquebebem.text.toString()
            val adultos2str: String = adultosquenaobebem.text.toString()
            val criancastr: String = criancas1.text.toString()
            val duracaostr: String = duracao1.text.toString()
            if (adultos1str == "" || adultos2str == "" || criancastr =="" || duracaostr == "") {
                Snackbar.make(
                    adultosquebebem,
                    "Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                ) .show()



        }



        // passar para prox tela e levar resultados:


        }
    }
}