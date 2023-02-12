package com.gson.memegenerator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import kotlin.random.Random
import com.gson.memegenerator.model.Meme


class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var imageButton: ImageButton
    private var model = Meme()

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
        val r = Random.nextInt(8)
        intent.putExtra("text", model.generate_text(r))
        intent.putExtra("meme", model.generate_meme(r))

        startActivity(intent)
    }
}