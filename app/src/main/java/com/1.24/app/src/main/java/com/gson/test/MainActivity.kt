package com.gson.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var displayTextView: TextView
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayTextView = findViewById(R.id.display_string_textview)
        editText = findViewById(R.id.editText)

        editText.filters += InputFilter.LengthFilter(1)
        editText.requestFocus()

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                val displayString = displayTextView.text
                var newString = ""

                if (p0?.length == 1) {
                    val char = p0.first()

                    for (letter in displayString) {
                        if (letter == char) {
                            newString += "*"
                        }
                        else {
                            newString += letter
                        }
                    }
                    displayTextView.text = newString
                }
            }
            override fun afterTextChanged(p0: Editable?) {}

        })
    }
}