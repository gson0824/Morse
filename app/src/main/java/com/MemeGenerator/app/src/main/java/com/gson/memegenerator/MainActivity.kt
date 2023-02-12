package com.gson.memegenerator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var imageButton: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView =findViewById(R.id.showme_meme)
        imageButton = findViewById(R.id.imageButton_meme)

        imageButton.setOnClickListener {
            onShowOtherView()
        }
    }

    private fun onShowOtherView() {
        val intent = Intent(this, MemeActivity::class.java)
        startActivity(intent)
    }
}