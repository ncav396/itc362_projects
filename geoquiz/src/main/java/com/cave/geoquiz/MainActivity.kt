package com.cave.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
// import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)

        trueButton.setOnClickListener {
            val snackBar = Snackbar.make(
                it,
                "Correct",
                Snackbar.LENGTH_LONG
            )
            snackBar.show()

        }
        falseButton.setOnClickListener {
            val snackBar = Snackbar.make(
                it,
                "Incorrect",
                Snackbar.LENGTH_LONG
            )
            snackBar.show()
        }
    }
}

/*        trueButton.setOnClickListener { view: View ->
           Toast.makeText(
                this,
               R.string.correct_toast,
               Toast.LENGTH_SHORT)
               .show()

          falseButton.setOnClickListener { view: View ->
           Toast.makeText(
               this,
               R.string.incorrect_toast,
                Toast.LENGTH_SHORT)
               .show()
    }*/
