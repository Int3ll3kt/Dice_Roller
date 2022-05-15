package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
//import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var diceImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Initialize diceImage by attaching it to a view

        diceImage = findViewById(R.id.dice_image)

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

        //Randomly generate a number for each dice roll
        val randomInt: Int = (1..6).random()

        //Update variable drawableResource with a dice icon equivalent to number generated
        val drawableResource = when (randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.ic_vr_avatar
        }
        //Update ImageView with a dice icon equivalent to the random Integer generated.
        diceImage.setImageResource(drawableResource)
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