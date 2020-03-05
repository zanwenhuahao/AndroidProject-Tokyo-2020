package com.example.androidproject.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.androidproject.data.UserDAO;
import com.example.androidproject.model.User;

@Database(entities =  {User.class},version =1)
public abstract class UserDataBase extends RoomDatabase {

    public abstract UserDAO getUserDao();

}
