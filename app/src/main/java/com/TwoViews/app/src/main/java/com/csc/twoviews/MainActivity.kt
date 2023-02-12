package com.csc.twoviews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kotlin.random.Random

const val EXTRA_SECRET_CODE = "com.csc.twoviews.secret"

class MainActivity : AppCompatActivity() {

    private lateinit var showOtherViewBtn: Button

    // uncomment this and switch to option 2 below for generating a toast indicating what snacks are available.
    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

            if (result.resultCode == RESULT_OK) {

                val msg = when (result.data?.getIntExtra(EXTRA_ANSWER, 0)) {
                    1 -> getString(R.string.thanks_for_cookies)
                    2 -> getString(R.string.thanks_for_milk)
                    else -> getString(R.string.thanks_for_nothing)
                }
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showOtherViewBtn = findViewById(R.id.show_other_view_button)
        showOtherViewBtn.setOnClickListener {
            onShowOtherView()
        }
    }

    private fun onShowOtherView() {

        val intent = Intent(this, SecondActivity::class.java)
        val r = Random.nextInt(16)
        intent.putExtra(EXTRA_SECRET_CODE, r)

        // 1
        // startActivity(intent)

        // 2
        startForResult.launch(intent)
    }
}