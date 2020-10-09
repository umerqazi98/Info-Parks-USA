package com.CS440.infoparksusa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        final Button button = (Button) findViewById(R.id.done_button);
        final EditText userName = (EditText) findViewById(R.id.editTextTextPersonName);
        final EditText userAddress = (EditText) findViewById(R.id.editTextTextPersonName4);
        final EditText userPhone = (EditText) findViewById(R.id.editTextTextPersonName6);
        final EditText userEmail = (EditText) findViewById(R.id.editTextTextPersonName5);
        final EditText userPassword = (EditText) findViewById(R.id.editTextTextPersonName7);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = userName.getText().toString();
                String address = userAddress.getText().toString();
                String phone = userPhone.getText().toString();
                String email = userEmail.getText().toString();
                String password = userPassword.getText().toString();
                if (name.matches("") ||
                        address.matches("") ||
                        phone.matches("") ||
                        email.matches("") ||
                        password.matches("")
                ) {
                    try {
                        Toast.makeText(UserInfoActivity.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Log.e("error:UserinfoActivity", e.toString());
                    }

                } else {
                    Intent intent = new Intent(UserInfoActivity.this, ChooseYourParkListView.class);
                    startActivity(intent);
                }
            }


        });

    }
}