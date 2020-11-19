package com.CS440.infoparksusa;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PackingList extends AppCompatActivity {
    private ArrayList<String> items;
    private ArrayList<String> Summer;
    private ArrayList<String> Spring;
    private ArrayList<String> Fall;
    private ArrayList<String> sugItems;
    private ArrayAdapter<String> itemsAdapter;
    private ArrayAdapter<String> sugAdapter;
    private ListView lvItems;
    private ListView suggestedList;
    private MyCustomAdapter e;
    int i = 0;
    List<String> summer = Arrays.asList("Shorts","Sunscreen", "Sunglasses","Baseball Cap");
    List<String> winter = Arrays.asList("Heavy Jacket","Gloves","Winter Hat","Boots");
    List<String> spring = Arrays.asList("Light Jacket","Bug repellent","Bear Spray","Umbrella");
    List<String> fall = Arrays.asList("Rain Jacket","Beanie","Light bottoms","Waterproof shoes");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packing_list);
        lvItems = (ListView) findViewById(R.id.lvItems); // get access to the listview
       // suggestedList = (ListView) findViewById(R.id.suggestedList);
        String date = getIntent().getStringExtra("date");

        Summer = new ArrayList<>();

        items = new ArrayList<String>();
        //readItems();
        itemsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);

        lvItems.setAdapter(new MyCustomAdapter(items,PackingList.this));
        //if(i == 0) {
        if(date.equals("10 ")||date.equals("11 ")||date.equals("0 ")||date.equals("1 ")){
            items.addAll(winter);
        }
        else if(date.equals("2 ")|| date.equals("3 ")||date.equals("4 ")){
            items.addAll(spring);
        }
        else if(date.equals("5 ") || date.equals("6 ") ||date.equals("7 ") ){
            items.addAll(summer);
        }
        else if(date.equals("8 ")||date.equals("9 ") ){
            items.addAll(fall);
        }

        setupListViewListener();

    }


    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter,
                                                   View item, int pos, long id) {
                        // Remove the item within array at position
                        items.remove(pos);
                        // Refresh the adapter
                        itemsAdapter.notifyDataSetChanged();
                        //writeItems();
                        return true;
                    }

                });
    }

    public void onAddItem(View v){
        EditText eT = (EditText) findViewById(R.id.etNewItem);
        String e = eT.getText().toString();
        itemsAdapter.add(e);
        //writeItems();
        eT.setText("");
    }
}