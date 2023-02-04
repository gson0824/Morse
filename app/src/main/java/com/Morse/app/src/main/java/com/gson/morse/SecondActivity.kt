package com.gson.morse

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

const val EXTRA_ANSWER = "com.gson.morse.answer"

class SecondActivity : AppCompatActivity() {

    private lateinit var original: TextView
    private lateinit var encoded: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        original = findViewById(R.id.original_morse)
        encoded = findViewById(R.id.encoded_morse)

        val bundle = intent
        var s = ""
        if (bundle != null) {
            s = bundle.getStringExtra("input").toString()
            original.text = s
            Toast.makeText(this, s, Toast.LENGTH_LONG).show()
        }
    }
}

