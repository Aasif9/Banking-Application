package com.example.bankingapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {
    TextView designed, name, app_name,company;
    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        logo = findViewById(R.id.logo);
        designed = findViewById(R.id.designed);

        app_name = findViewById(R.id.app_name);
        company = findViewById(R.id.company);

        startEnterAnimation();
    

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(HomeScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }

    private void startEnterAnimation() {
        app_name.startAnimation(AnimationUtils.loadAnimation(HomeScreen.this, R.anim.bottom));
        logo.startAnimation(AnimationUtils.loadAnimation(HomeScreen.this, R.anim.p_in));


        logo.setVisibility(View.VISIBLE);
        designed.setVisibility(View.VISIBLE);

        app_name.setVisibility(View.VISIBLE);
        company.setVisibility(View.VISIBLE);
    }
}