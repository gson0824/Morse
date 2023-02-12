package com.csc.twoviews

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlin.random.Random

const val EXTRA_ANSWER = "com.csc.twoviews.answer"

class SecondActivity : AppCompatActivity() {

    private lateinit var snacksImageView: ImageView
    private lateinit var findSnacksBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        snacksImageView = findViewById(R.id.snacks_imageView)
        snacksImageView.visibility = View.INVISIBLE

        findSnacksBtn = findViewById(R.id.find_snacks_button)
        findSnacksBtn.setOnClickListener {
            onFindSnacks()
        }

        val bundle = intent.extras
        if (bundle != null) {
            val code = bundle.getInt(EXTRA_SECRET_CODE)
            val msg = getString(R.string.the_secret_code_is) + code.toString()
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        }
    }

    private fun onFindSnacks() {
        val answer = Random.nextInt(3)
        snacksImageView.visibility = View.VISIBLE
        when (answer) {
            0 -> snacksImageView.visibility = View.INVISIBLE
            1 -> snacksImageView.setImageResource(R.drawable.cookie_jar)
            2 -> snacksImageView.setImageResource(R.drawable.milk)
        }

        val intent = Intent()
        intent.putExtra(EXTRA_ANSWER, answer)
        setResult(Activity.RESULT_OK, intent)
    }
}