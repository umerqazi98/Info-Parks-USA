package com.CS440.infoparksusa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ChooseYourParkListView extends AppCompatActivity {
    private static String[] parks;
    private AutoCompleteTextView parkTextView;
    private Button campingGrounds;
    private final static Integer[] park_pics = {R.drawable.yosemite, R.drawable.yellowstone, R.drawable.teton, R.drawable.glacier,
            R.drawable.arches, R.drawable.carlsbad};
    private List<parkItem> parkList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_choose_your_park_list_view);
        parks = getResources().getStringArray(R.array.national_parks);
        campingGrounds = findViewById(R.id.camping_grounds);
        parkTextView = findViewById(R.id.actv);



        fillParkList();

        final AutoCompleteParkAdapter adapter = new AutoCompleteParkAdapter(this, parkList);

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1, parks);

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


        campingGrounds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String label = "campground";
                    Intent geoIntent = new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("geo:0,0?q=" + label));
                    if (geoIntent.resolveActivity(getPackageManager()) != null) {
                        // Use the Intent to start Google Maps application using Activity.startActivity()
                        startActivity(geoIntent);

                        Log.i("joder" + " CJ", "Map activity just started");
                    }
                } catch (Exception e) {
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

    protected int indexOf(String s, String[] strings){
        int size = strings.length;
        for (int i = 0; i < size; i++){
            if (strings[i] == s && s.length() == strings[i].length()){
                return i;
            }
        }
        return -1;

    }

    private void fillParkList(){
        parkList = new ArrayList<>();
        for (int i = 0; i < 6; i++){
            parkList.add(new parkItem(parks[i],park_pics[i]));
        }
    }

}