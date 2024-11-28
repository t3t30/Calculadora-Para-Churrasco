package com.example.calculadorachurrasco

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadorachurrasco.R

const val KEY_RESULT_BEER = "ResultCalculator.KEY_BEER"
const val KEY_RESULT_MEAT = "ResultCalculator.kEY_MEAT"
const val KEY_RESULT_DRINKS = "ResultCalculator.KEY_DRINKS"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultBeer = intent.getFloatExtra(KEY_RESULT_BEER, 0f)
        val resultMeat = intent.getFloatExtra(KEY_RESULT_MEAT, 0f)
        val resultDrinks = intent.getFloatExtra(KEY_RESULT_DRINKS, 0f)

        val meat = findViewById<TextView>(R.id.tv_carne)
        val meatFormat = String.format("%.2f", resultMeat)
        "${meatFormat}(kg)".also { meat.text = it }

        val beer = findViewById<TextView>(R.id.tv_cerveja)
        val beerFormat = String.format("%.2f", resultBeer)
        "${beerFormat}(Litros)".also { beer.text = it }

        val drink = findViewById<TextView>(R.id.tv_refrigerante)
        val drinkFormat = String.format("%.2f", resultDrinks)
        "${drinkFormat}(Litros)".also { drink.text = it }

        val btnRecall = findViewById<Button>(R.id.btn_recalc)
        btnRecall.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}