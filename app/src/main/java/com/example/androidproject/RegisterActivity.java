package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidproject.data.UserDAO;
import com.example.androidproject.data.UserDataBase;
import com.example.androidproject.model.User;

public class RegisterActivity extends AppCompatActivity {


        EditText editTextUsername, editTestEmail, editTestPassword,editTextCnfPassword;
        Button buttonRegister;
        TextView textViewLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        editTextUsername = findViewById(R.id.editTextUsername);
        editTestEmail = findViewById(R.id.editTextEmail);
        editTestPassword = findViewById(R.id.editTextPassword);
        editTextCnfPassword = findViewById(R.id.editTextCnfPassword);

        buttonRegister = findViewById(R.id.buttonRegister);

        textViewLogin = findViewById(R.id.textViewLogin);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

            }
        });

//        userDAO = Room.databaseBuilder(this, UserDataBase.class,"User").allowMainThreadQueries().build().getUserDao();

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            String userName = editTextUsername.getText().toString().trim();
                String email = editTestEmail.getText().toString().trim();
                String password = editTestPassword.getText().toString().trim();
                String passwordConf = editTextCnfPassword.getText().toString().trim();


                     // if password

                if (password.equals(passwordConf)){

                  User user = new User(userName,password,email);
                  LoginActivity.dataBase.getUserDao().insert(user);

                  Toast.makeText(RegisterActivity.this, "Registration Complete", Toast.LENGTH_SHORT).show();

                  Intent moveToLogin = new Intent (RegisterActivity.this, LoginActivity.class);
                  startActivity(moveToLogin);
                }

                else {

                    Toast.makeText(RegisterActivity.this, "Password not matching", Toast.LENGTH_SHORT).show();

                }
            }
        });



    }
}
