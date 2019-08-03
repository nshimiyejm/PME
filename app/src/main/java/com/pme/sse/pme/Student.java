package com.pme.sse.pme;

/**
 * Created by nshim on 12/5/2017.
 */

public class Student {
    String username, password, email;

    public Student(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Student(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
