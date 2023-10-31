package com.example.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText name, email, phone;
    private Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);

        saveBtn = findViewById(R.id.save);

        saveBtn.setOnClickListener((event) -> {
            String nameText = name.getText().toString();
            String emailText = email.getText().toString();
            String phoneText = phone.getText().toString();

            // get your shared preferences
            SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);

            // create your editor
            SharedPreferences.Editor editor = sharedPreferences.edit();

            // write data in the background
            editor.putString("name", nameText);
            editor.putString("email", emailText);
            editor.putString("phone", phoneText);

            // Asynchronously saves the data in the background
            editor.apply();

            // OR
            // editor.commit(); // Synchronously saves the data, which is less efficient


            // Move to display Page
            Intent intent = new Intent(getBaseContext(), DisplayPage.class);
            startActivity(intent);
        });
    }
}