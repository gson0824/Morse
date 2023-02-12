package com.gson.memegenerator

import android.annotation.SuppressLint
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.gson.memegenerator.model.Meme


class MemeActivity : AppCompatActivity() {

    private lateinit var image2: ImageView
    private lateinit var text2: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meme)

        image2 = findViewById(R.id.memeImage)
        text2 = findViewById(R.id.memeText)

        val bundle = intent.extras
        if (bundle != null) {
            text2.text = bundle.getString("text")
            image2.setImageResource(bundle.getInt("meme"))
        }

        setResult(Activity.RESULT_OK, intent)
    }
}
