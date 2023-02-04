package com.gson.morse

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gson.morse.model.Morse


class SecondActivity : AppCompatActivity() {

    private lateinit var original: TextView
    private lateinit var encoded: TextView
    private var model = Morse()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        original = findViewById(R.id.original_morse)
        encoded = findViewById(R.id.encoded_morse)

        val bundle = intent.extras
        var s = ""
        if (bundle != null) {
            s = bundle.getString("input").toString()
            original.text = s
        }
        encoded.text = model.encodeMessage(s)
    }
}

