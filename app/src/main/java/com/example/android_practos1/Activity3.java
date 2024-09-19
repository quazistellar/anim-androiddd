package com.example.android_practos1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Activity3 extends AppCompatActivity {

    private ImageView imageView;
    private int currentImageIndex = 0;
    private Animation zoomInOut;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.anim2);

        zoomInOut = AnimationUtils.loadAnimation(this, R.anim.zoom_in_out);
        imageView.startAnimation(zoomInOut);


        Button buttonToBack = findViewById(R.id.buttonToBack);
        buttonToBack.setOnClickListener(view -> {
            finish();
        });


        buttonToBack.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_up));
    }
}
