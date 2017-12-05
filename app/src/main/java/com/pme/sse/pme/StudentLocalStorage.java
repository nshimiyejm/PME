package com.pme.sse.pme;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by nshim on 12/5/2017.
 */

public class StudentLocalStorage {

    public static final String ST_NAME = "studentDetails"; // File that stores the details of the user on the phone
    SharedPreferences studentLocalDb;    // Sharedpreference allows for local storage of data

    public StudentLocalStorage(Context context){
        studentLocalDb = context.getSharedPreferences(ST_NAME, 0);
    }

    // Store user data by updating all content
    // Found in the Sharedpreference by the attributes of the student
    // passed to this method
    public void storeStudentData(Student student){
        SharedPreferences.Editor spEditor = studentLocalDb.edit();
        spEditor.putString("username", student.username);
        spEditor.putString("email", student.email);
        spEditor.putString("password", student.password);

        //Finish by comitting the changes
        spEditor.commit();
    }

    //Create a method that allows to get data of loged in user
    public Student  getLoggedInUser(){
        String username = studentLocalDb.getString("username","");
        String email = studentLocalDb.getString("email", "");
        String password = studentLocalDb.getString("password", "");

        Student storeedS = new Student (username, email, password);

        return storeedS;
    }

    //If a Student is loggedin the value is true else false
    //This info needed to be logged in the sharedp
    public void setStudentLoggedIn(boolean loggedin){
        SharedPreferences.Editor spEditor = studentLocalDb.edit();
        spEditor.putBoolean("loggedIn", loggedin);
        spEditor.commit();
    }

    public boolean getStudentLoggedIn(){
        if(studentLocalDb.getBoolean("loggedIn", false) == true){
            return true;
        }
        else
            return false;
    }

    public void clearUserData(){
        SharedPreferences.Editor spEditor = studentLocalDb.edit();
        spEditor.clear();
        spEditor.commit();
    }

}
