package com.gson.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.gson.counter.model.LabelChanger

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    private lateinit var constrainedTextView: TextView

    private var model = LabelChanger()
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        constrainedTextView = findViewById(R.id.textView_counter)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "called onDestroy")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "called onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "called onResume")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "called onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "called onStop")
    }


    fun onReset(view :View) {
        count = 0
        constrainedTextView.text = model.getFirstLabels().toString()
    }

    fun onRemove(view: View) {
        if (count > 0) {
            count -= 1
        }

        if (count == 0) {
            constrainedTextView.text = model.getFirstLabels().toString()
        }
        else {
            constrainedTextView.text = model.getSecondLabels().toString() + count.toString()
        }
    }

    fun onAdd(view :View) {

        if (count < 5) {
            count += 1
        }

        if (count == 5) {
            constrainedTextView.text = model.getThirdLabels().toString()
        }
        else {
            constrainedTextView.text =  model.getSecondLabels().toString() + count.toString()
        }
    }

}