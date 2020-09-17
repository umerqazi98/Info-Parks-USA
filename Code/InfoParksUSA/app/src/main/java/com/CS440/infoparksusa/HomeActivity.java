package com.CS440.infoparksusa;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;

import android.os.Handler;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Timer().schedule(
                new TimerTask(){

                    @Override

                    public void run(){
                        startActivity(new Intent(HomeActivity.this,MainActivity.class));
                        finish();

                        //if you need some code to run when the delay expires
                    }

                }, 1000);

    }

}
