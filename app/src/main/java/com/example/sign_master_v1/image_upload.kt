package com.example.sign_master_v1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView

class image_upload : AppCompatActivity() {

    lateinit var upload_image:ImageView
    lateinit var upload_button:Button

    val pick_image = 100

    var imageUri:Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_upload)

        upload_image = findViewById(R.id.up_img)
        upload_button = findViewById(R.id.upload_button)

        upload_button.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pick_image)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pick_image) {
            imageUri = data?.data
            upload_image.setImageURI(imageUri)
        }
    }
}