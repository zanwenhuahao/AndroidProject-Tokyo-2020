package com.example.androidproject.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.androidproject.model.Attraction;

@Database(entities =  {Attraction.class},version =1)
public abstract class AttractionDatabase extends RoomDatabase{
        public abstract AttractionDAO aDAO();
    }
