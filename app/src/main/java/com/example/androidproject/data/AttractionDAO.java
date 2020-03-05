package com.example.androidproject.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
import java.util.List;

import com.example.androidproject.model.Attraction;

@Dao
public interface AttractionDAO {

        @Insert
        public void addAttraction(Attraction A);

        //delete from database

        //@Delete
        //public  void deleteUser(Donut dough);

        @Query("Select * from allAttractions")
        public List<Attraction> getallAttractions();
    }


