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
        this.gender = gender;
        this.rollNumber = rollNumber;
        this.mobileNumber = mobileNumber;
    }



    public String getName() {
            return name;
    }

    public String getGender() {
            return gender;
    }

    public CharSequence getRollNumber() {
            return rollNumber;
    }

    public CharSequence getMobileNumber() {
            return mobileNumber;
    }

}
