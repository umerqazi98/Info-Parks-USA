package com.CS440.infoparksusa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.create_account_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MainActivity.this,UserInfoActivity.class);
                    startActivity(intent);
                }
                catch (Exception e){
                    Log.e("error:", e.toString());
                }

            }
        });


    }

    public void startUserInfoActivity(View v){
        Intent intent = new Intent(MainActivity.this,UserInfoActivity.class);
        startActivity(intent);
    }
}
