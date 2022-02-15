package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_view);

        Button button = (Button) findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity2();
            }
        });

        Button SignDbutton = (Button) findViewById(R.id.button4);

        SignDbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity3();
            }
        });
        
    }

    public void Activity2(){
        Intent intent =  new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

    public void Activity3(){
        Intent intent =  new Intent(this,SignActivity3.class);
        startActivity(intent);
    }
}