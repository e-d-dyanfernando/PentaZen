package com.example.sign_master_v1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Help : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        val chatWhatsapp = findViewById<ImageView>(R.id.img2)
        val chatFaq = findViewById<ImageView>(R.id.img3)
        val chatEmail = findViewById<ImageView>(R.id.img4)

        chatWhatsapp.setOnClickListener {
            val number = "940765703737"
            val whatsappUri = Uri.parse("http://api.whatsapp.com/send?phone=$number")
            val i = Intent(Intent.ACTION_VIEW, whatsappUri)
            startActivity(i)
        }

        chatFaq.setOnClickListener {
            val faqPage = Intent(this, FaqActivity::class.java)
            startActivity(faqPage)
        }

        chatEmail.setOnClickListener {
            val i = Intent(Intent.ACTION_SEND)
            i.type = "text/plain"
            i.putExtra(Intent.EXTRA_EMAIL, arrayOf("Pentazen@gmail.com"))
            startActivity(i)
        }

    }
}