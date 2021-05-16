package com.streamliners.sendingobject.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String gender;
    private String rollNumber;
    private String mobileNumber;

    public Student(String name, String gender, String rollNumber, String mobileNumber) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.rollNumber = rollNumber;
        this.gender = gender;
    }



    public String getName() {
            return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
            return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public CharSequence getRollNumber() {
            return rollNumber;
    }

    public CharSequence getMobileNumber() {
            return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
