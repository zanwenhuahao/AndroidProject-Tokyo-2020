package com.example.androidproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidproject.data.UserDAO;
import com.example.androidproject.data.UserDataBase;
import com.example.androidproject.fragments.MessageFragment;
import com.example.androidproject.fragments.OfficialSchedule;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // variable for notificaiton

    private final String CHANNEL_ID = "notification";
    private final int NOTIFICATION_ID = 001;


    //drawerlayout
    Toolbar toolbar;
    DrawerLayout drawer;
    NavigationView navigationView;

    //
    EditText editEmail, editPassword;
    Button buttonLogin;
    TextView textViewRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //to display notification

       /* public void displayNotification(View view) {

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
            builder.setSmallIcon(R.drawable.ic_sms_notification);
            builder.setContentTitle("Notification");
            builder.setContentText("Notification-");

            builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
            notificationManagerCompat.notify(NOTIFICATION_ID, builder.build())
        }; */

        // to use tool bar as the action bar :-

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Tokyo 2020");
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //drawer
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

            // 1. get a fragment manager & start a new transaction
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MessageFragment());
            ft.commit();

        /*editEmail = findViewById(R.id.editTextEmail);
        editPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        textViewRegister = findViewById(R.id.textViewRegister);*/


        /*dataBase = Room.databaseBuilder(this, UserDataBase.class, "User")
                .allowMainThreadQueries()
                .build();
        db = dataBase.getUserDao();*/

       /* textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //intent

                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);

            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = editEmail.getText().toString().trim();
                String password = editPassword.getText().toString().trim();

                User user = db.getUser(email, password);

                if (user != null) {

                    Intent i = new Intent(MainActivity.this, HomeActivity.class);
                    i.putExtra("User", user);
                    startActivity(i);
                    finish();

                } else {

                    Toast.makeText(MainActivity.this, "Not Registered OR Incorrect Username or Password", Toast.LENGTH_SHORT).show();


                }


            }
        });*/
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_message:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MessageFragment()).commit();
                break;
            case R.id.nav_attractions:
                Intent att = new Intent(MainActivity.this, AttractionListActivity.class);
                startActivity(att);
                break;
            case R.id.nav_schedule:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new OfficialSchedule()).commit();
                break;
            case R.id.nav_logout:
                Toast.makeText(this, "logged out", Toast.LENGTH_SHORT).show();
                Intent out = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(out);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
