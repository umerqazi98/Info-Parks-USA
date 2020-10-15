package com.CS440.infoparksusa;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ChooseYourParkListView extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setListAdapter(new ArrayAdapter<String>(this,
                R.layout.activity_choose_your_park_list_view,
                getResources().getStringArray(R.array.national_parks)));
    }


    public void onListItemClick(ListView parent, View view,
                                int position, long id) {

//        try {
//
//            // Process text for network transmission
//            final TextView textView = (TextView) view;
//            String address = (String) textView.getText();
//            address = address.replace(' ', '+');
//
//            // Create Intent object for starting Google Maps application
//            Intent geoIntent = new Intent(
//                    Intent.ACTION_VIEW,
//                    Uri.parse("geo:0,0?q=" + address));
//
//            if(geoIntent.resolveActivity(getPackageManager()) != null) {
//                // Use the Intent to start Google Maps application using Activity.startActivity()
//                startActivity(geoIntent);
//
//                Log.i("joder" + " From Ugo", "Map activity just started");
//            }
//        } catch (Exception e) {
//            // Log any error messages to LogCat using Log.e()
//            Log.e("catch", e.toString());
//        }

        try{
            Intent intent = new Intent(this,ParkMenu.class);
            startActivity(intent);
        }
        catch (Exception e){
            Log.e("catch", e.toString());
        }

    }


}