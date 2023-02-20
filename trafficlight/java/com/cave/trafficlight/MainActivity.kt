package com.cave.trafficlight

import android.R
import android.os.Bundle
import android.view.View.*
import androidx.appcompat.app.AppCompatActivity



    class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
        update

        btn.setOnClickListener {
            if (isStop) {
                redlight.visibility = setvisibility
                yellowlight.visibility = INVISIBLE
                greenlight.visibility = INVISIBLE
                reset Boolean vars (isStop, isGo, isWait)

            } else if (isGo) {
                redlight.setVisibility = INVISIBLE
                yellowlight.setVisibility = INVISIBLE
                greenlight.setVisibility = VISIBLE
            } else {
                redlight.visibility = INVISIBLE
                yellowlight.visibility = VISIBLE
                greenlight.visibility = INVISIBLE

            }
        }


    }

    }}

