package com.example.android_practos1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.content.Intent;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.graphics.drawable.AnimationDrawable;


public class Activity2 extends AppCompatActivity {

    ImageView catImageView;
    FrameLayout layouttt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        catImageView = findViewById(R.id.catImageView);
        layouttt = findViewById(R.id.imageFrame);

        Button buttonToThird = findViewById(R.id.buttonToBack);
        buttonToThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity2.this, MainActivity.class);

                Slide slide = new Slide();
                slide.setDuration(700);
                slide.setSlideEdge(Gravity.START);

                getWindow().setExitTransition(slide);

                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(Activity2.this).toBundle());
            }
        });

        catImageView.setBackgroundResource(R.drawable.cat_animation);
        AnimationDrawable animation = (AnimationDrawable) catImageView.getBackground();
        animation.start();
        catImageView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.s_slider));

        TransitionManager.beginDelayedTransition((ViewGroup) layouttt.getParent());

        buttonToThird.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_out));

        Slide enterSlide = new Slide();
        enterSlide.setDuration(700);
        enterSlide.setSlideEdge(Gravity.END);
        getWindow().setEnterTransition(enterSlide);
    }
}
