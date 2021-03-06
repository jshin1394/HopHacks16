package com.example.jsk.hophacks17;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TimePicker;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity {
    private int day;
    private int month;
    private int year;
    private int hour;
    private int min;
    private String event;
    private String userName;
    private int houseID;
    private List<Member> members;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addingevents);

        //Get information from login page.
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                userName = null;
                houseID = 0;
                members = null;
            } else {
                userName = extras.getString("userName");
                houseID = extras.getInt("houseID");
                members = (List<Member>) extras.getSerializable("members");
            }
        } else {
            userName = savedInstanceState.getString("userName");
            houseID = savedInstanceState.getInt("houseID");
            members = (List<Member>) savedInstanceState.getSerializable("members");
        }

        final EditText event_name = (EditText) findViewById(R.id.name);
        final DatePicker datess = (DatePicker) findViewById(R.id.dates);
        final TimePicker timess = (TimePicker) findViewById(R.id.times);


        // Attach an listener to read the data at our posts reference
        final Button done = (Button) findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View v) {
                event = event_name.getText().toString();
                day= datess.getDayOfMonth();
                month = datess.getMonth();
                year = datess.getYear();
                hour = timess.getHour();
                min = timess.getMinute();
                addCalendarEvent();
            }
        });
    }

    public void addCalendarEvent(){
        Calendar cal = Calendar.getInstance();
        Intent intent = new Intent(EventsActivity.this, CalendarDisplayActivity.class);
        intent.putExtra("event", this.event);
        intent.putExtra("day", this.day);
        intent.putExtra("month", this.month);
        intent.putExtra("year", this.year);
        intent.putExtra("hour", this.hour);
        intent.putExtra("min", this.min);
        intent.putExtra("userName", userName);
        intent.putExtra("houseID", houseID);
        intent.putExtra("members", (Serializable) members);
        startActivity(intent);
    }

}
