package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.ml.Android;
import com.example.myapplication.ml.AndroidV2;

import org.tensorflow.lite.support.image.TensorImage;

import java.io.IOException;
import java.net.URI;

public class MainActivity2 extends AppCompatActivity {

    Bitmap bitmap;
    ImageView imgview;
    TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cam);

        imgview = findViewById(R.id.camView);
        label = findViewById(R.id.textView7);

        Button select = (Button) findViewById(R.id.button7);

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");

                startActivityForResult(intent, 100);
            }
        });

        Button predict = (Button) findViewById(R.id.button6);

        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap resized =  Bitmap.createScaledBitmap(bitmap, 320,320,true);

                try {
                    AndroidV2 model = AndroidV2.newInstance(getApplicationContext());

                    // Creates inputs for reference.
                    TensorImage image = TensorImage.fromBitmap(resized);

                    // Runs model inference and gets result.
                    AndroidV2.Outputs outputs = model.process(image);
                    AndroidV2.DetectionResult detectionResult = outputs.getDetectionResultList().get(0);

                    // Gets result from DetectionResult.
                    float location = detectionResult.getScoreAsFloat();
                    RectF category = detectionResult.getLocationAsRectF();
                    String score = detectionResult.getCategoryAsString();
                    label.setText("\n " + score );

                    // Releases model resources if no longer used.
                    model.close();
                } catch (IOException e) {
                    // TODO Handle the exception
                }

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        imgview.setImageURI(data.getData());

        Uri uri = data.getData();

        try {
            bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}