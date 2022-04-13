package com.example.sign_master_v1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Dictionary_page_two : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dictionary_page_two)

        val bkBtnDic2 = findViewById<ImageButton>(R.id.bk_btn_dic2)

        bkBtnDic2.setOnClickListener {
            val dic_bkBtn2 = Intent(this, dictionary::class.java)
            startActivity(dic_bkBtn2)
        }
    }
}