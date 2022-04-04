package com.example.sign_master_v1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WelcomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_page)

        findViewById<Button>(R.id.str_button).setOnClickListener{
            val homePage = Intent (this,MainActivity::class.java)
            startActivity(homePage)
        }
    }
}