package com.example.remake_diceroller

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rolldice: Button = findViewById(R.id.Roll_Button)
        rolldice.setOnClickListener {randomdicecollector()}

        val usernamebutton: Button = findViewById(R.id.Username_Button)
        usernamebutton.setOnClickListener { makeusername(it) }

    }

    private fun makeusername(view: View) {
        val username: TextView = findViewById(R.id.User_name)
        val typename: TextView = findViewById(R.id.Type_Your_name)

        username.text = typename.text
        typename.visibility = View.GONE
        username.visibility = View.VISIBLE

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun randomdicecollector() {
        val randomint = (1..6).random()
        val diceimage: ImageView = findViewById(R.id.Dice_Image)
        diceimage.setImageResource(
            when (randomint) {
                1 -> (R.drawable.dice_1)
                2 -> (R.drawable.dice_2)
                3 -> (R.drawable.dice_3)
                4 -> (R.drawable.dice_4)
                5 -> (R.drawable.dice_5)
                else -> (R.drawable.dice_6)
            }
        )
    }

}


