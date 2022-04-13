package com.example.sign_master_v1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class dictionary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dictionary)

        val bkBtnDic = findViewById<ImageButton>(R.id.bk_btn_dic)

        bkBtnDic.setOnClickListener {
            val Dic_bkBtn = Intent(this, MainActivity::class.java)
            startActivity(Dic_bkBtn)
        }

        val nextBtnDic2 = findViewById<Button>(R.id.next_btn_dic)

        nextBtnDic2.setOnClickListener {
            val Next_Dic_bkBtn = Intent(this, Dictionary_page_two::class.java)
            startActivity(Next_Dic_bkBtn)
        }

    }
}