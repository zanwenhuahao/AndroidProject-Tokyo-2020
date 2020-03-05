package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.androidproject.model.User;

public class HomeActivity extends AppCompatActivity {

    private TextView tvUser;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        user = (User) getIntent().getSerializableExtra("User");
        tvUser = findViewById(R.id.text);
        if (user !=null){

            tvUser.setText("Welcome" + user.getUserName());


        }

    }
}
