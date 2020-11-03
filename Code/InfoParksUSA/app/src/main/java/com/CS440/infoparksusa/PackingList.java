package com.CS440.infoparksusa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PackingList extends AppCompatActivity {
    private ArrayList<String> items;
    private ArrayList<String> sugItems;
    private ArrayAdapter<String> itemsAdapter;
    private ArrayAdapter<String> sugAdapter;
    private ListView lvItems;
    private ListView suggestedList;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packing_list);
        lvItems = (ListView) findViewById(R.id.lvItems); // get access to the listview
        suggestedList = (ListView) findViewById(R.id.suggestedList);
        String fromI = getIntent().getStringExtra("yas");
        sugItems = new ArrayList<>();

        sugAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, sugItems);

        items = new ArrayList<String>();
        //readItems();
        itemsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);
        //if(i == 0) {
            items.add("Tent");
            items.add("Bear Spray");
            items.add(fromI);
            i++;
        //}
        // will need to setup listview for items
        setupListViewListener();

    }
    private void readItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            items = new ArrayList<String>(FileUtils.readLines(todoFile));
        } catch (IOException e) {
            items = new ArrayList<String>();
        }
    }

    private void writeItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            FileUtils.writeLines(todoFile, items);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                        writeItems();
                        return true;
                    }

                });
    }

    public void onAddItem(View v){
        EditText eT = (EditText) findViewById(R.id.etNewItem);
        String e = eT.getText().toString();
        itemsAdapter.add(e);
        writeItems();
        eT.setText("");
    }
}