package com.example.kumat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splashActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN = 4000;

    //variables of animation
    Animation topAnim, bottomAnim;
    ImageView logo;
    ImageView kumat;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //animation
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //hooks
        logo = findViewById(R.id.logo);
        kumat = findViewById(R.id.kumat);
        textView = findViewById(R.id.text);

        logo.setAnimation(topAnim);
        kumat.setAnimation(bottomAnim);
        textView.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splashActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}