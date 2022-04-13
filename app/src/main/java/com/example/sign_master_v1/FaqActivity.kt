package com.example.sign_master_v1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class FaqActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faq)

        val bkBtnFaq = findViewById<ImageButton>(R.id.bk_btn_dic2)

        bkBtnFaq.setOnClickListener {
            val FAQ_bkBtn = Intent(this, Help::class.java)
            startActivity(FAQ_bkBtn)
        }
    }
}