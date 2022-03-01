package com.example.sign_master_v1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class help : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chat_whatsapp = findViewById<ImageView>(R.id.chat_Img)
        val chat_faq = findViewById<ImageView>(R.id.faq_Img)
        val chat_email = findViewById<ImageView>(R.id.email_Img)

        chat_whatsapp.setOnClickListener {
            val number = "940765703737"
            val whatsappUri = Uri.parse("http://api.whatsapp.com/send?phone=$number")
            val i = Intent(Intent.ACTION_VIEW, whatsappUri)
            startActivity(i)
        }

        chat_email.setOnClickListener {
            val i = Intent(Intent.ACTION_SEND)
            i.type = "text/plain"
            i.putExtra(Intent.EXTRA_EMAIL, arrayOf("Pentazen@gmail.com"))
            //i.putExtra(Intent.EXTRA_TEXT,"Hello , I think I found Your Dog")
            //i.putExtra(Intent.EXTRA_SUBJECT,"Your lost Dog")
            startActivity(i)
        }

    }
}