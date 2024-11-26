package com.example.calculadorachurrasco

import android.content.Intent
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
            if (adultos1str.isEmpty() || adultos2str.isEmpty() || criancastr.isEmpty() || duracaostr.isEmpty()) {
                Snackbar.make(
                    adultosquebebem,
                    "Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                val bebem = adultos1str.toFloat()
                val naobebem = adultos2str.toFloat()
                val crianca = criancastr.toFloat()
                val duracao = duracaostr. toFloat()

                // logica do calculo do resultado:
                val carne_total = (bebem + naobebem)*0.3* duracao + crianca*0.15*duracao
                val cerveja_total = bebem * duracao * 1
                val refrigerante = ( naobebem * 0.4) + (crianca * 0.2)

                val intent = Intent  (this, ResultActivity::class.java)
                intent.putExtra("Key_carne", carne_total)
                intent.putExtra("Key_cerveja", cerveja_total)
                intent.putExtra("Key_refrigerante", refrigerante)
                startActivity(intent)


                //val intentcarne = Intent (this, ResultActivity::class.java)
                //intentcarne.putExtra("123", carne_total)

                //startActivity(intentcarne)

                //val intentcerveja = Intent (this, ResultActivity::class.java)
                //intentcerveja.putExtra("1234", cerveja_total)

                //startActivity(intentcerveja)

                //val intentrefrigerante = Intent (this, ResultActivity::class.java)
                //intentrefrigerante.putExtra("12345", refrigerante)

               // startActivity(intentrefrigerante)




                }


        }



        // passar para prox tela e levar resultados:


        }
    }
