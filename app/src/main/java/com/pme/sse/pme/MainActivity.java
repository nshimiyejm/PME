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

import android.widget.ImageButton;


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

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Button login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.home_screen);

                final Button friend_requests = findViewById(R.id.friend_requests);
                friend_requests.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        setContentView(R.layout.accept_friend_requests);

                        final Button back_1 = findViewById(R.id.back_btn_frnd_rqt);
                        back_1.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                setContentView(R.layout.home_screen);

                            }
                        });
                    }
                });
                final Button send_msg = findViewById(R.id.messages);
                send_msg.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        setContentView(R.layout.send_text);
                    }
                });
                final Button schedule = findViewById(R.id.enter_schedule);
                schedule.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        setContentView(R.layout.schedule);

                    }
                });
                final Button my_profile = findViewById(R.id.my_profile);
                my_profile.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        setContentView(R.layout.profile_screen);
                    }
                });
            }
        });

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

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