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

        // Initialize the zoom animation
        zoomInOut = AnimationUtils.loadAnimation(this, R.anim.zoom_in_out);
        imageView.startAnimation(zoomInOut);

        imageView.setOnClickListener(view -> {
            currentImageIndex = (currentImageIndex + 1) % 3;
            switch (currentImageIndex) {
                case 0:
                    imageView.setImageResource(R.drawable.anim_1);
                    break;
                case 1:
                    imageView.setImageResource(R.drawable.anim2);
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.anim3);
                    break;
            }

            // Start zoom animation again
            zoomInOut.reset(); // Reset the animation
            imageView.startAnimation(zoomInOut);
        });

        Button buttonToBack = findViewById(R.id.buttonToBack);
        buttonToBack.setOnClickListener(view -> {
            finish();
        });

        // Start animation for the "Back" button
        buttonToBack.startAnimation(AnimationUtils.loadAnimation(this, R.anim.ss_slider));
    }
}
