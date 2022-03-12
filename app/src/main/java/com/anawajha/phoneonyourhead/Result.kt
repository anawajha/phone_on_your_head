package com.anawajha.phoneonyourhead

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Result : AppCompatActivity() {
    private lateinit var score: TextView
    private lateinit var message: TextView
    private lateinit var backToHome: Button
    private lateinit var playAgain: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        score = findViewById(R.id.tv_final_score)
        message = findViewById(R.id.tv_message)
        backToHome = findViewById(R.id.btn_home)
        playAgain = findViewById(R.id.btn_again)

        val array = intent.getStringArrayListExtra("a") as ArrayList<String>
        val result = intent.getIntExtra("score", 0)

        printResults(array.size,result)


        playAgain.setOnClickListener {
            val i = Intent(this, Game::class.java)
            i.putStringArrayListExtra("a", array)
            startActivity(i)
            finish()
        }

        backToHome.setOnClickListener {
            startActivity(Intent(this, Main::class.java))
            finish()
        }

    }


    fun printResults(arraySize:Int,result:Int){
             score.text = "$result/$arraySize"
        if (result >= ((arraySize/3) *2)){
            message.text = "تهانينا"
        }else{
            message.text = "حظاً أوفر"
        }
    }


}

