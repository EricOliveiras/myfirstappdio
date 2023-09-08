package com.example.myfirstappdio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var spinner: Spinner
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.languageSpinner)
        textView = findViewById(R.id.textHello)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.language_list,
            android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedLanguage = parent?.getItemAtPosition(position).toString()
                updateText(selectedLanguage)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }

    private fun updateText(language: String) {
        val resourceId = when (language) {
            "Inglês" -> R.string.hello_en
            "Espanhol" -> R.string.hello_es
            "Francês" -> R.string.hello_fr
            "Português-Br" -> R.string.hello_pt
            else -> R.string.hello_pt
        }

        val translatedText = getString(resourceId)
        textView.text = translatedText
    }
}
