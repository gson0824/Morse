package com.csc.counter

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.csc.model.Counter
import com.google.android.material.snackbar.Snackbar

const val MAXIMUM_OCCUPANCY = 5
const val CURRENT_OCCUPANCY = "current_occupancy"

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var occupancyTextView: TextView
    private lateinit var addButton: Button
    private lateinit var removeButton: Button
    private lateinit var statusImageView: ImageView
    private lateinit var container: ConstraintLayout

    private val counter = Counter(4, MAXIMUM_OCCUPANCY)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        occupancyTextView = findViewById(R.id.occupancy_textView)
        addButton = findViewById(R.id.add_button)
        removeButton = findViewById(R.id.remove_button)
        statusImageView = findViewById(R.id.status_imageView)
        container = findViewById(R.id.container)
        updateUI()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(CURRENT_OCCUPANCY, counter.cur)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        counter.cur = savedInstanceState.getInt(CURRENT_OCCUPANCY)
        updateUI()
    }

    private fun updateUI() {
        occupancyTextView.text = when (counter.cur) {
            0 -> getString(R.string.club_empty)
            in 1 until counter.max -> getString(R.string.occupancy_at) + " " + counter.cur
            else -> getString(R.string.club_full)
        }
        Log.d(TAG, "current count is: ${counter.cur}")

        if (counter.atMax()) {
            addButton.visibility = View.INVISIBLE
            statusImageView.setImageResource(R.drawable.barrier)
        } else {
            addButton.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.green_check)
        }

        if (counter.cur > 0) removeButton.visibility =
            View.VISIBLE else removeButton.visibility = View.INVISIBLE
    }

    private fun postToast() {
        // 1
//        val msg = getString(R.string.occupancy_at) + " " + counter.cur.toString()

        // 2
//        val msg = resources.getQuantityString(
//            R.plurals.patrons_in_club,
//            counter.cur,
//            counter.cur,
//            counter.roomLeft()
//        )

        val patron = resources.getQuantityString(
            R.plurals.patron, counter.roomLeft(), counter.roomLeft()
        )
        val msg = resources.getQuantityString(
            R.plurals.patrons_in_club_extended,
            counter.cur,
            counter.cur,
            counter.roomLeft(),
            patron
        )

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun showSnackbar() {
        val msg = getString(R.string.max_occupancy_reached, counter.cur)
        val snackbar = Snackbar.make(container, msg, Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction("???") {
            postToast()
        }
        snackbar.show()
    }

    fun onAdd(view: View) {
        counter.add()
        if (counter.atMax()) {
            showSnackbar()
        } else {
            postToast()
        }
        updateUI()
    }

    fun onRemove(view: View) {
        counter.remove()
        updateUI()
        postToast()
    }

    fun onReset(view: View) {
        counter.reset()
        updateUI()
    }
}