package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
//import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Get the Button view from the layout and assign a click listener to each
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }


        val countUpButton: Button = findViewById(R.id.count_up_button)
        countUpButton.setOnClickListener { increment() }

        //Get the Button view from the layout and set an onClick listener action
        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener{reset()}
    }

    //Click listener action for Reset Button
    private fun reset() {

        val resultText = findViewById<TextView>((R.id.result_test))
        resultText.text = "0"
    }

    //Click listener action for Roll Button
    private fun rollDice(){

        val randomInt: Int = (1..6).random()
//        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
        val resultText: TextView = findViewById(R.id.result_test)
        resultText.text = randomInt.toString()

    }
    //Click listener action for Count Up Button
    private fun increment(){
        val resultText: TextView = findViewById(R.id.result_test)

        //Check if Result TextView is at default, if yes covert to 1
        if (resultText.text.toString() == "Let's Start!"){
            resultText.text = "1"
        }

        //Otherwise increment Result TextView value by 1 otherwise if value is 6, let it be
        else {
        var resultInt: Int = resultText.text.toString().toInt()
            when (resultInt){
                1, 2, 3, 4, 5 -> resultInt += 1
                6 -> resultInt = resultInt
            }
            resultText.text = resultInt.toString()

        }
    }
}