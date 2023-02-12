package com.csc.boom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var explodingTextView: TextView
    private lateinit var proposeToast: Button
    private lateinit var showOtherActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        proposeToast = findViewById(R.id.propose_toast_button)
        proposeToast.setOnClickListener {
            Toast.makeText(this, R.string.initial_toast, Toast.LENGTH_SHORT).show()
        }
        showOtherActivity = findViewById(R.id.other_activity_button)
        showOtherActivity.setOnClickListener {
            val intent = Intent(this, OtherActivity::class.java)
            startActivity(intent)
        }

        // This code crashes the app. What can we do?
//        val alteredText = getString(R.plurals.imagine_x_explosions, 7)
//        explodingTextView.text = alteredText
    }

    fun onProposeToast(view: View) {
        Toast.makeText(this, R.string.my_real_toast, Toast.LENGTH_SHORT).show()
    }
}