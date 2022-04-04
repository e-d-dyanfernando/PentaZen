package com.example.sign_master_v1

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.sign_master_v1.ml.Model
import org.tensorflow.lite.support.image.TensorImage
import java.io.File

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

            var  mBitmap_org = MediaStore.Images.Media.getBitmap(
                this.getContentResolver(),
                imageUri
            );

            val resizzed = Bitmap.createScaledBitmap(mBitmap_org!!, 224, 224, false)

            val model = Model.newInstance(applicationContext)

// Creates inputs for reference.
            val image = TensorImage.fromBitmap(resizzed)

// Runs model inference and gets result.
            val outputs = model.process(image)
            val probability = outputs.probabilityAsCategoryList

            //Log.i("OUTPUT",probability.toString())

            var max = 0.0000000000
            var cat = ""
            for (catergory in probability){
                var temp = catergory.toString().split("=")
                var newTemp = temp[2].replace(")","").replace(">","")
                var value = newTemp.toDouble()
                var name = temp[0].split(" ")[1].replace('"',' ')

                if(value > max){
                    max = value.toDouble()
                    cat = name
                }
            }

            Log.i("output ",cat+" "+ max.toString())

            findViewById<TextView>(R.id.upload_output).setText(cat+" "+ max.toString())

// Releases model resources if no longer used.
            model.close()
        }
    }
}