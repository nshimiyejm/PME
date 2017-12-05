package com.pme.sse.pme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DisplayHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
    }

    //This method calls the message activity
    public void messages(View view){
        Intent startNewActivity = new Intent(this, DisplayMessage.class);
        startActivity(startNewActivity);

    }

    //This method calls the request friend form activity
    public void addFriend(View view){
        Intent startNewActivity = new Intent(this, DisplayMessage.class);
        startActivity(startNewActivity);

    }

    //This method calls the create schedule form
    public void creatSchedule(View view){
        Intent startNewActivity = new Intent(this, DisplayCreateSchedule.class);
        startActivity(startNewActivity);

    }

    //This method calls the more options activity
    public void other(View view){
        Intent startNewActivity = new Intent(this, DisplayMore.class);
        startActivity(startNewActivity);

    }


}
