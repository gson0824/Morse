package com.gson.morse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts


class MainActivity : AppCompatActivity() {

    private lateinit var encode: Button
    private lateinit var text: EditText

    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val msg = result.data?.getStringExtra("encoded")
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        encode = findViewById(R.id.button)
        text = findViewById(R.id.editText_morse)

        encode.setOnClickListener {
            onShowOtherView()
        }
    }

    private fun onShowOtherView() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("input", text.text.toString())
        //startActivity(intent)

        startForResult.launch(intent)
    }
    }