package com.example.androidproject.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.androidproject.model.User;

@Dao

public interface UserDAO {
    //query to select user from table
    @Query("SELECT * FROM users WHERE email =:email and password = :password")
    User getUser(String email , String password);

    @Insert
    void insert (User user);
}
