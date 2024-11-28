package com.example.calculadorachurrasco
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadorachurrasco.R
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtAdults = findViewById<TextInputEditText>(R.id.edt_adultos)
        edtAdults.text?.clear()
        val edtChildren = findViewById<TextInputEditText>(R.id.edt_criancas)
        val edtAdultsDont = findViewById<TextInputEditText>(R.id.edt_adultosdont)
        val edtHours = findViewById<TextInputEditText>(R.id.edt_horas)
        val btnCalculate = findViewById<Button>(R.id.btn_calc)

        btnCalculate.setOnClickListener {
            val adultsStr: String = edtAdults.text.toString()
            val childrenStr: String = edtChildren.text.toString()
            val hoursStr: String = edtHours.text.toString()
            val adultsnoStr: String = edtAdultsDont.text.toString()

            if (adultsStr == "" || childrenStr == "" || hoursStr == "") {
                Snackbar.make(
                    edtAdults,
                    "Preencha todos os campos!",
                    Snackbar.LENGTH_LONG
                )
                    .show()
            } else {

                val adults = adultsStr.toFloat()
                val adultsdontdrink = adultsnoStr.toFloat()
                val children = childrenStr.toFloat()
                val hours = hoursStr.toFloat()
                var adultsconts : Float?= 0f
                var childrenconts : Float?= 0f
                val quatro = 4f/10f
                val seis = 6f/10f
                val duzentos = 2f/10f
                val trezentos = 3f/10f
                if(hours<=4){adultsconts = quatro}
                else if (hours>4){adultsconts = seis}
                if (hours<4){childrenconts= duzentos}
                else if (hours>4){childrenconts = trezentos}


                val childrenMeat = children * childrenconts!!
                val adultsMeat = adults * adultsconts!!
                val adultsDontMeat = adultsdontdrink * 3/10 * hours
                val meat = childrenMeat + adultsMeat + adultsDontMeat
                val beerAdults = adults * 1 * hours
                val refrigeratorChildren = children * 2/10 * hours
                val refrigeratorAdult = adultsdontdrink * 4/10 * hours
                val refrigerator = refrigeratorAdult + refrigeratorChildren

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_BEER, beerAdults)
                intent.putExtra(KEY_RESULT_MEAT, meat)
                intent.putExtra(KEY_RESULT_DRINKS, refrigerator)
                startActivity(intent)


            }
        }
    }
}

