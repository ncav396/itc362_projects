package com.cave.countapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var counter_txt : TextView
    private lateinit var button_click : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    counter_txt = findViewById(R.id.counter_txt)
        button_click = findViewById(R.id.btn_click)
        var timesClicked = 0
        button_click.setOnClickListener {
            timesClicked += 1
            counter_txt.text = timesClicked.toString()
        }
    }
}

