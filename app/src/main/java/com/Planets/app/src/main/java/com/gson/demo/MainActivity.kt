package com.gson.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private val model = Planets()

    private lateinit var planetsTextView: Text

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        planetsTextView = findViewById(R.id.planet_textview)
    }

    fun onNotMyPlanet(view: View) {
        planetsTextView.text = model.getNextPlanet()
    }

    fun onMyPlant(view: View) {
        planetsTextView.text = model.hello()
    }
}