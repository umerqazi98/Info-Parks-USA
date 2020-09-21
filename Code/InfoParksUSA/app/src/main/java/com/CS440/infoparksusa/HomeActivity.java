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
                        //set up a small delay and then start the next activity
                        startActivity(new Intent(HomeActivity.this,MainActivity.class));
                        finish(); // necessary so this activity is compeltely destroyed (thus the user cant "back" into it)

                    }

                }, 1000);

    }

}
