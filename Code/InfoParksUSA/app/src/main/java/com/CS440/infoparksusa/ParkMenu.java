package com.CS440.infoparksusa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ParkMenu extends AppCompatActivity {
    private static String [] web_array;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_menu);

        final TextView textView = findViewById(R.id.park_title);
        final Button map = (Button) findViewById(R.id.park_map);
        final Button web = (Button) findViewById(R.id.web);
        final Button packingList = (Button) findViewById(R.id.packing_list);
        final Button campingGrounds = (Button) findViewById(R.id.camping_grounds);
        final Intent intent = getIntent();
        final String park = getParkName(intent);
        textView.setText(park);
        web_array = getResources().getStringArray(R.array.national_parks_web);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String address = park.replace(" ", "+");
                    Intent geoIntent = new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("geo:0,0?q=" + address));
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

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int pos = intent.getIntExtra("pos",-1);
                    String web_address = web_array[pos];
                    Uri web_page = Uri.parse(web_address);
                    Intent webIntent = new Intent(
                            Intent.ACTION_VIEW,
                            web_page);
                    if (webIntent.resolveActivity(getPackageManager()) != null) {
                        // Use the Intent to start Google Maps application using Activity.startActivity()
                        startActivity(webIntent);

                        Log.i("joder" + " CJ", "Map activity just started");
                    }
                } catch (Exception e) {
                    Log.e("catch", e.toString());
                }
            }
        });

        packingList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

    public String getParkName(Intent intent) {
        return intent.getStringExtra("park");

    }


}