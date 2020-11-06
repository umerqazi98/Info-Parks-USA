package com.CS440.infoparksusa;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

public class CalendarActivity extends AppCompatActivity {

    private  static final String TAG = "CalendarActivity";
    private CalendarView mCalendarView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        mCalendarView = (CalendarView) findViewById(R.id.calendarView);
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView CalendarView, int year, int month, int dayOfMonth) {
                String date = month + " " ;
                Log.d(TAG, "onSelectedDayChange: yyyy/mm/dd:" + date);
                Intent intent = new Intent(CalendarActivity.this,PackingList.class);
                intent.putExtra("date",date);
                startActivity(intent);

            }
        });
    }
}