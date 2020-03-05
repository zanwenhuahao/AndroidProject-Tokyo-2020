package com.example.androidproject.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "allAttractions")
public class Attraction {

    @PrimaryKey (autoGenerate = true)
    private int ID;
    private String name;
    private String address;
    private String description;
    private double admissionPrice;


    public Attraction(String name, String description, String address, double admissionPrice) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.admissionPrice = admissionPrice;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAdmissionPrice() {
        return admissionPrice;
    }

    public void setAdmissionPrice(double admissionPrice) {
        this.admissionPrice = admissionPrice;
    }


}
