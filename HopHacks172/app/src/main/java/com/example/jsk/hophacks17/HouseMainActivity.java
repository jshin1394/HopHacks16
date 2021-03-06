package com.example.jsk.hophacks17;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JSK on 10/22/16.
 */

public class HouseMainActivity extends AppCompatActivity {

    private String userName;
    private int houseID;
    private List<Member> members;

    //assume we have member list for a house

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_main);

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

        final Button moneyButton = (Button) findViewById(R.id.money_button);
        moneyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HouseMainActivity.this, MoneyActivity.class);
                intent.putExtra("userName", userName);
                intent.putExtra("houseID", houseID);
                intent.putExtra("members", (Serializable) members);
                startActivity(intent);
                finish();
            }
        });

        final Button choreButton = (Button) findViewById(R.id.chore_button);
        choreButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HouseMainActivity.this, HousekeepingActivity.class);
                intent.putExtra("userName", userName);
                intent.putExtra("houseID", houseID);
                intent.putExtra("members", (Serializable) members);
                startActivity(intent);
                finish();
            }
        });

        final Button stateButton = (Button) findViewById(R.id.state_button);
        stateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HouseMainActivity.this, StateActivity.class);
                intent.putExtra("userName", userName);
                intent.putExtra("houseID", houseID);
                intent.putExtra("members", (Serializable) members);
                startActivity(intent);
                finish();
            }
        });

        final Button calendarButton = (Button) findViewById(R.id.calendar_button);
        calendarButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HouseMainActivity.this, CalendarDisplayActivity.class);
                intent.putExtra("userName", userName);
                intent.putExtra("houseID", houseID);
                intent.putExtra("members", (Serializable) members);
                startActivity(intent);
                finish();
            }
        });

    }
}
