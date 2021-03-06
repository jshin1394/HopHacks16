package com.example.jsk.hophacks17;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JSK on 10/22/16.
 */

public class RegisterActivity extends AppCompatActivity {

    private User newUser = new User();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText fname = (EditText) findViewById(R.id.fname_field);
        final EditText lname = (EditText) findViewById(R.id.lname_field);
        final EditText DOB = (EditText) findViewById(R.id.DOB_field);
        final EditText email = (EditText) findViewById(R.id.email_field);
        final EditText password = (EditText) findViewById(R.id.password_field);
        // Attach an listener to read the data at our posts reference
        final Button button = (Button) findViewById(R.id.register);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String fn = fname.getText().toString();
                final String ln = lname.getText().toString();
                final String dob = DOB.getText().toString();
                final String em = email.getText().toString();
                final String pw = password.getText().toString();

                newUser = new User(em,fn,ln,dob,pw); //new user to be added to server

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
