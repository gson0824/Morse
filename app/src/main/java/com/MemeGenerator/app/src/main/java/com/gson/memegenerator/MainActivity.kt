package com.gson.memegenerator

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random
import com.gson.memegenerator.model.Meme


class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var imageButton: ImageButton
    private var count = 0
    private lateinit var resetButton: Button

    private var model = Meme(this@MainActivity)
    private lateinit var cl: ConstraintLayout

    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val value = result.data?.getIntExtra("counter", 0)
                val msg =  getString(R.string.snack) + value.toString()
                val snackbar = Snackbar.make(cl, msg, Snackbar.LENGTH_INDEFINITE)
                snackbar.show()
            }
        }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView =findViewById(R.id.showme_meme)
        imageButton = findViewById(R.id.imageButton_meme)
        resetButton = findViewById(R.id.resetButton)
        cl = findViewById(R.id.layout_meme)

        imageButton.setOnClickListener {
            onShowOtherView()
        }

        resetButton.setOnClickListener {
            count = 0
        }
    }

    private fun onShowOtherView() {
        val intent = Intent(this, MemeActivity::class.java)
        count++
        val r = Random.nextInt(8)
        intent.putExtra("text", model.generate_text(r))
        intent.putExtra("meme", model.generate_meme(r))
        intent.putExtra("counter", count)

        //startActivity(intent)

        startForResult.launch(intent)
    }
}

