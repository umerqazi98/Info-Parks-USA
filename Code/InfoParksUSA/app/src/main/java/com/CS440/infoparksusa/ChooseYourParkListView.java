package com.CS440.infoparksusa;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseYourParkListView extends AppCompatActivity {
    private static String[] parks;
    private AutoCompleteTextView parkTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        parks = getResources().getStringArray(R.array.national_parks);

        setContentView(R.layout.activity_choose_your_park_list_view);

        parkTextView = findViewById(R.id.actv);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, parks);
        parkTextView.setAdapter(adapter);

        parkTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                try{
                    final TextView textView = (TextView) view;
                    final String address = (String) textView.getText();
                    final int pos = indexOf(address,parks);
                    Intent intent = new Intent(view.getContext(), ParkMenu.class);
                    intent.putExtra("park", address);
                    intent.putExtra("pos", pos);
//                    Log.e("AutoCompleateOnclick", "pos:" + pos);
//                    Log.e("AutoCompleateOnclick", "long:" + l);
                    startActivity(intent);
                }
                catch (Exception e){
                    Log.e("catch", e.toString());
                }
            }
        });


    }

    @Override
    protected void onPause() {
        super.onPause();
        parkTextView.setText("");

    }

    public int indexOf(String s, String[] strings){
        int size = strings.length;
        for (int i = 0; i < size; i++){
            if (strings[i] == s && s.length() == strings[i].length()){
                return i;
            }
        }
        return -1;

    }

}