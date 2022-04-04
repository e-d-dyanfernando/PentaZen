package com.example.sign_master_v1

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.FileProvider
import com.example.sign_master_v1.databinding.ActivityCameraBinding
import com.example.sign_master_v1.ml.Model
import org.tensorflow.lite.support.image.TensorImage
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class camera : AppCompatActivity() {

    val REQUEST_IMAGE_CAPTURE = 1
    var bitmap: Bitmap? = null
    lateinit var currentPhotoPath: String
    private lateinit var binding: ActivityCameraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        binding = ActivityCameraBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.camButton.setOnClickListener {
            dispatchTakePictureIntent()
        }

        var cam_button: Button = findViewById(R.id.cam_button)
        cam_button.setOnClickListener{
            dispatchTakePictureIntent()
        }
    }

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            // Ensure that there's a camera activity to handle the intent
            takePictureIntent.resolveActivity(packageManager)?.also {
                // Create the File where the photo should go
                val photoFile: File? = try {
                    createImageFile()
                } catch (ex: IOException) {
                    // Error occurred while creating the File
                    ex.message
                    null
                }
                // Continue only if the File was successfully created
                photoFile?.also {
                    val photoURI: Uri = FileProvider.getUriForFile(
                        this,
                        packageName + ".fileprovider",
                        it
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_IMAGE_CAPTURE) {
            var  mBitmap_org = MediaStore.Images.Media.getBitmap(
                this.getContentResolver(),
                Uri.fromFile(File(currentPhotoPath))
            );

            val resizzed = Bitmap.createScaledBitmap(mBitmap_org!!, 224, 224, false)
            findViewById<ImageView>(R.id.image).setImageBitmap(resizzed)

            val model = Model.newInstance(applicationContext)

            // Creates inputs for reference.
            val image = TensorImage.fromBitmap(resizzed)

            // Runs model inference and gets result.
            val outputs = model.process(image)
            val probability = outputs.probabilityAsCategoryList

            // Releases model resources if no longer used.
            model.close()

            Log.i("OUTPUT",probability.toString())

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
            findViewById<TextView>(R.id.camera_output).text = cat+" "+ max.toString();

        }
    }

    @Throws(IOException::class)
    private fun createImageFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File = this!!.getExternalFilesDir(Environment.DIRECTORY_PICTURES)!!
        return File.createTempFile(
            "JPEG_${timeStamp}_", /* prefix */
            ".jpg", /* suffix */
            storageDir /* directory */
        ).apply {
            // Save a file: path for use with ACTION_VIEW intents
            currentPhotoPath = absolutePath
        }

    }
}