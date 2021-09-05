package com.example.healthexpert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SpalshScreenActivity extends AppCompatActivity {


    private static int SPLASH_SCREEN = 5000;

    Animation topAnim, bottomAnim;

    ImageView image;
    TextView name, moto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh_screen);


        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);


        image = findViewById(R.id.imageViewsplash);
        name = findViewById(R.id.textViewsplash);
        moto = findViewById(R.id.motosplash);

        image.setAnimation(topAnim);
        name.setAnimation(bottomAnim);
        moto.setAnimation(bottomAnim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SpalshScreenActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);


    }
}