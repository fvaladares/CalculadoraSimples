package br.com.pitagoras.calculadorasimples

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var result: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initButtons()
    }

    private fun initButtons() {
        main_button_sub.setOnClickListener {
            Toast.makeText(
                this,
                "Botão ${getString(R.string.main_button_sub)} acionado",
                Toast.LENGTH_LONG
            ).show()
            calc(getString(R.string.main_button_sub)[0])
        }

        main_button_div.setOnClickListener {
            Toast.makeText(
                this,
                "Botão ${getString(R.string.main_button_div)} acionado",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun add(view: View) {
        Toast.makeText(
            this,
            "Botão ${getString(R.string.main_button_add)} acionado",
            Toast.LENGTH_LONG
        ).show()
        calc(getString(R.string.main_button_add)[0])
    }

    fun mul(view: View) {
        Toast.makeText(
            this,
            "Botão ${getString(R.string.main_button_mul)} acionado",
            Toast.LENGTH_LONG
        ).show()

        calc(getString(R.string.main_button_mul)[0])

        val intent = Intent(this, ResultActivity::class.java).apply {
            putExtra(getString(R.string.intent_code), result)
        }

        startActivity(intent)
    }

    private fun calc( operation: Char) {
        val parcel1 = main_editText_parcel1.text.toString().toDouble()
        val parcel2 = main_editText_parcel2.text.toString().toDouble()

        result = when(operation) {
            getString(R.string.main_button_add)[0] -> parcel1 + parcel2
            '-' -> parcel1 - parcel2
            '*' -> parcel1 * parcel2
            '/' -> parcel1 / parcel2
            else -> 0.0
        }

        main_textView_result.text = result.toString()
    }
}