package com.pme.sse.pme;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button registerbtn, login;
    EditText email, password;

    StudentLocalStorage studentLocalStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        login = (Button) findViewById(R.id.login);
        registerbtn = (Button) findViewById(R.id.registerbtn);

        login.setOnClickListener(this);
        registerbtn.setOnClickListener(this);

        studentLocalStorage = new StudentLocalStorage(this);

    }

    @Override
    protected void onStart(){
        super.onStart();
        // Authenticate a Student each time the main statrs
        if (authenticate() == true){
            startActivity(new Intent(this, DisplayHome.class));
        }
    }

    // Display student details from DB
    public void displayDetails(){
        // Create lables (TextViews labels) that will hold the vales returned
        Student student = studentLocalStorage.getLoggedInUser();
        email.setText(student.email);
        
    }

    private boolean authenticate(){
        return studentLocalStorage.getStudentLoggedIn();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login:
                Student student = new Student(null, null);

                //Collect data from the server and validate
                studentLocalStorage.storeStudentData(student);
                //If the login is successful
                studentLocalStorage.setStudentLoggedIn(true);

                break;

                // Calls the registration page
            case R.id.registerbtn:
                startActivity(new Intent(this, DisplayRegistration.class));
                break;
        }

    }
}