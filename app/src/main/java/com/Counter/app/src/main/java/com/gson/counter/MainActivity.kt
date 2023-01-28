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

    fun onReset(view :View) {
        count = 0
        constrainedTextView.text = model.getFirstLabels().toString()
        Log.d(TAG, "Pressed Reset. Count = $count")
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
        Log.d(TAG, "Pressed Remove. Count = $count")
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
        Log.d(TAG, "Pressed Add. Count = $count")
    }
}