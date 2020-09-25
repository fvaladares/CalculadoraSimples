package br.com.pitagoras.calculadorasimples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        getData()
    }

    private fun getData() {
        val result = intent.getDoubleExtra(getString(R.string.intent_code), 0.0)
        resultActivity_textview_result.text = result.toString()
    }
}