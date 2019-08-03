package com.pme.sse.pme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DisplayCreateSchedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule);
    }


    //This method calls the message activity
    public void submitSch(View view){
        Intent startNewActivity = new Intent(this, DisplayProfile.class);
        startActivity(startNewActivity);

    }
}
