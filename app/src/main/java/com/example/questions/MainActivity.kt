package com.example.questions

import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_question.setOnClickListener {
            val intent = Intent(this,Second::class.java)
            startActivity(intent)
        }
        btnRateApp.setOnClickListener {
            var uri = Uri.parse("https://play.google.com/store/apps/details?id=com.microsoft.todos")
            var gotToMarket = Intent(Intent.ACTION_VIEW)
            gotToMarket.data = uri /*market://details?id com.microsoft.todos*/
            startActivity(gotToMarket)


        }
    }
}