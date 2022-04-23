package com.example.sign_master_v1

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.example.sign_master_v1.ml.Model
import org.tensorflow.lite.support.image.TensorImage
import java.io.File
import java.util.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.lang.StringBuilder
import java.net.HttpURLConnection

class image_upload : AppCompatActivity(),TextToSpeech.OnInitListener {

    lateinit var upload_image:ImageView
    lateinit var upload_button:Button

    val pick_image = 100

    var detect_sign = ""

    var imageUri:Uri? = null

    private var tts: TextToSpeech? = null
    private var buttonSpeak: ImageButton? = null
    private var editText: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_upload)

        val bkBtnUpload = findViewById<ImageButton>(R.id.bk_btn_upload)

        bkBtnUpload.setOnClickListener {
            val Upload_bkBtn = Intent(this, MainActivity::class.java)
            startActivity(Upload_bkBtn)
        }

        upload_image = findViewById(R.id.up_img)
        upload_button = findViewById(R.id.upload_button)

        upload_button.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pick_image)
        }

        buttonSpeak = findViewById(R.id.voice_upload)
        editText = findViewById(R.id.upload_output)

        buttonSpeak!!.isEnabled = false;
        tts = TextToSpeech(this, this)

        buttonSpeak!!.setOnClickListener { speakOut() }
    }

    override fun onInit(status: Int) {

        if (status == TextToSpeech.SUCCESS) {
            // set US English as language for tts
            val result = tts!!.setLanguage(Locale.UK)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS","The Language specified is not supported!")
            }
            else {
                buttonSpeak!!.isEnabled = true
            }
        } else {
            Log.e("TTS", "Initilization Failed!")
        }
    }

    private fun speakOut() {
        val text = detect_sign
            //editText!!.text.toString()
        tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, null,"")
    }

    public override fun onDestroy() {
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
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

            Log.i("output ",cat+" ")

            detect_sign = cat

            runBlocking {
                launch {
                    withContext(Dispatchers.IO){
                        val link = "https://iot.loopweb.lk/converter.php?word=${cat.trim()}"
                        val url = URL(link)
                        val con = url.openConnection() as HttpURLConnection
                        val stb = StringBuilder()
                        val bf = BufferedReader(InputStreamReader(con.inputStream))
                        var line:String? = bf.readLine()

                        while (line != null) {
                            stb.append(line + "\n")
                            line = bf.readLine()
                        }

                        Log.i("tag link", link)
                        Log.i("tag output", stb.toString())

                        runOnUiThread {
                            findViewById<TextView>(R.id.upload_output).setText(stb.toString())
                        }
                    }
                }
            }

            //findViewById<TextView>(R.id.upload_output).setText(cat+" ")

// Releases model resources if no longer used.
            model.close()
        }
    }
}