package com.CS440.infoparksusa;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;

public class AutoCompleteParkAdapter extends ArrayAdapter<parkItem> {

    private List<parkItem> parkListFull;


    public AutoCompleteParkAdapter(@NonNull Context context, @NonNull List<parkItem> parkList) {
        super(context, 0, parkList);
        parkListFull = new ArrayList<>(parkList);
    }


    @NonNull
    @Override
    public Filter getFilter() {
        return parkFilter;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.park_autocomplete_row,
                    parent,false);

        }
        TextView textView = convertView.findViewById(R.id.text_view_name);
        ImageView imageView = convertView.findViewById(R.id.image_view_park);
        final parkItem parkItem1 = getItem(position);

        if (parkItem1 != null){
            textView.setText(parkItem1.getParkName());
            imageView.setImageResource(parkItem1.getParkImage());
        }
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    final String address = parkItem1.getParkName();
                    final int resId = parkItem1.getParkImage();
                    final String webAddress= parkItem1.getWebAddress();
                    Intent intent = new Intent(view.getContext(), ParkMenu.class);
                    intent.putExtra("park", address);
                    intent.putExtra("pos", resId);
                    intent.putExtra("web", webAddress);
                    Log.e("AutoCompleateOnclick", "pos:" + resId);
                    Log.e("AutoCompleateOnclick", "address:" + address);
                    Log.e("AutoCompleateOnclick", "web:" + webAddress);
                    startActivity(getContext(), intent, null);
                }
                catch (Exception e){
                    Log.e("catch", e.toString());
                }
            }
        });
        return convertView;
    }

    private Filter parkFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults results = new FilterResults();
            List<parkItem> suggestions = new ArrayList<>();

            if (charSequence == null || charSequence.length() == 0){
                suggestions.addAll(parkListFull);
            }
            else{
                String filterPattern = charSequence.toString().toLowerCase().trim();
                for (parkItem item : parkListFull){
                    if (item.getParkName().toLowerCase().contains(filterPattern)){
                        suggestions.add(item);
                    }
                }
            }
            results.values = suggestions;
            results.count = suggestions.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {
            clear();
            addAll((List) results.values);
            notifyDataSetChanged();

        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return ((parkItem)resultValue).getParkName();
        }
    };
}
