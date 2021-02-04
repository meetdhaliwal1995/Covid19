package com.example.coronavirusapi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DefalutActivity extends AppCompatActivity {

    TextView s, s1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        s = findViewById(R.id.text_fight);
        s1 = findViewById(R.id.text_Covid);

        final Animation fadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_animation);
        final Animation fadeout = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out_animation);
//        fadein.setDuration(5000);
        fadeout.setDuration(4000);

        s.setAnimation(fadeout);
        s1.setAnimation(fadeout);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(DefalutActivity.this, MainActivity2.class);
                startActivity(i);
                s1.setAnimation(fadeout);
                s.setAnimation(fadeout);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        }, 3000);
    }
}
