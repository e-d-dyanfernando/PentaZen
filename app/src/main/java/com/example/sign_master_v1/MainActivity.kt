package com.example.sign_master_v1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val img_bt_camera = findViewById<ImageButton>(R.id.camera)
        val img_bt_image_upload = findViewById<ImageButton>(R.id.image_upload)
        val img_bt_dictionary = findViewById<ImageButton>(R.id.dictionary)
        val img_bt_help = findViewById<ImageButton>(R.id.help)

        img_bt_camera.setOnClickListener {
            val CAMERA = Intent(this, camera::class.java)
            startActivity(CAMERA)
        }
        img_bt_image_upload.setOnClickListener {
            val UPLOAD_IMAGE = Intent(this, image_upload::class.java)
            startActivity(UPLOAD_IMAGE)
        }
        img_bt_dictionary.setOnClickListener {
            val DICTIONARY = Intent(this, dictionary::class.java)
            startActivity(DICTIONARY)
        }
        img_bt_help.setOnClickListener {
            val HELP = Intent(this, Help::class.java)
            startActivity(HELP)
        }

        //bt_back.setOnClickListener {
           // val BACK = Intent(this, back::class.java)
            //startActivity(BACK)
        //}
    }
}