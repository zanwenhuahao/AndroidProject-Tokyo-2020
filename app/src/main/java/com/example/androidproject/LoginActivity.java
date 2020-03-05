package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidproject.data.UserDataBase;
import com.example.androidproject.model.User;

public class LoginActivity extends AppCompatActivity {

    EditText editEmail, editPassword;
    Button buttonLogin;
    TextView textViewRegister;

    //Start Database
    //Database USER
    public static UserDataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Setting the login fields to global variables
        editEmail = findViewById(R.id.editTextEmail);
        editPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        textViewRegister = findViewById(R.id.textViewRegister);

        dataBase = Room.databaseBuilder(getApplicationContext(),UserDataBase.class,"users").allowMainThreadQueries().build();
    }

    public void signUpPressed(View view) {
        //intent
        Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(i);
    }

    public void signInPressed(View view) {
        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();

        User curUser = dataBase.getUserDao().getUser(email, password);

        if (curUser != null) {

            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            //@TODO: Implement user login
            //i.putExtra("Current User", (Parcelable) curUser);
            startActivity(i);

        } else {

            Toast.makeText(LoginActivity.this, "Not Registered OR Incorrect Username or Password", Toast.LENGTH_SHORT).show();

        }
    }

    //Guest login for debugging
    public void GuestPressed(View view) {
        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();

        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        //i.putExtra("User", user);
        startActivity(i);
    }
}
