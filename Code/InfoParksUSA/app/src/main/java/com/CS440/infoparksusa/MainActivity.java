package com.CS440.infoparksusa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText loginInfo = (EditText) findViewById(R.id.loginInfo);
        final EditText passwordInfoEdit = (EditText) findViewById(R.id.editTextPassword);

        final Button button = (Button) findViewById(R.id.create_account_button);
        final Button loginButton = (Button) findViewById(R.id.button);
        final Button testbutton = (Button) findViewById(R.id.testbutton);

        testbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MainActivity.this,CalendarActivity.class);
                    intent.putExtra("yas",loginInfo.getText().toString());
                    startActivity(intent);
                }catch (Exception e){
                    Log.e("error:", e.toString());
                }
            }
        });

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

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loginText = loginInfo.getText().toString();
                String passwordText = passwordInfoEdit.getText().toString();
                if(loginText.matches("") || passwordText.matches("")){
                    Toast.makeText(MainActivity.this, "You did not enter a username or password",Toast.LENGTH_SHORT).show();
                }else {
                    try {
                        Intent intent = new Intent(MainActivity.this, ChooseYourParkListView.class);
                        startActivity(intent);
                    } catch (Exception e) {
                        Log.e("Error:", e.toString());
                    }
                }
            }
        });



    }

    public void startUserInfoActivity(View v){
        Intent intent = new Intent(MainActivity.this,UserInfoActivity.class);
        startActivity(intent);
    }
}
