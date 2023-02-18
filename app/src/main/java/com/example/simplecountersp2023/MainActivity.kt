package com.example.simplecountersp2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val upgradeButton = findViewById<Button>(R.id.upgradeBtn)
        val textView = findViewById<TextView>(R.id.textView)

        button.setOnClickListener {
            counter++
            textView.text = counter.toString()

            if (counter >= 100) {
                // show upgrade button and set onClickListener
                upgradeButton.visibility = View.VISIBLE
                upgradeButton.setOnClickListener {
                    button.text = "Add 2"

                    // update original button to add 2 instead of 1
                    button.setOnClickListener {
                        counter += 2
                        textView.text = counter.toString()
                    }

                    // hide upgrade button again
                    upgradeButton.visibility = View.INVISIBLE
                }
            }
        }
    }
}