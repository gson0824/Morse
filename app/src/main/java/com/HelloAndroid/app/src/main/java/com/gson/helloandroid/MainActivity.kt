package com.gson.helloandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var helloTextView: TextView
    private lateinit var answerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        helloTextView = findViewById(R.id.hello_android)
        answerButton = findViewById(R.id.Answer)
    }


    fun onAnswerButton(view: View) {
        helloTextView.text = getString(R.string.hello_android)
    }
}