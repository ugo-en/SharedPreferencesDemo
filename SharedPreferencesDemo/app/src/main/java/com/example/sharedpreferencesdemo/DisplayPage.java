package com.example.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayPage extends AppCompatActivity {
    TextView nameLabel, emailLabel, phoneLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_page);

        nameLabel = findViewById(R.id.nameLabel);
        emailLabel = findViewById(R.id.emailLabel);
        phoneLabel = findViewById(R.id.phoneLabel);

        // Initialize Shared Preferences
        SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);


        // Read data
        String name = sharedPreferences.getString("name", "DefaultUsername");
        String email = sharedPreferences.getString("email", "Sample@email.com");
        String phone = sharedPreferences.getString("phone", "+12345678910");

        // set the data on the screen
        nameLabel.setText("Name: "+name);
        emailLabel.setText("Email: "+email);
        phoneLabel.setText("Phone: "+phone);
    }
}