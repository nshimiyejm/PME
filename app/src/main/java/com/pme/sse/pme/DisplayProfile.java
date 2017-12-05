package com.pme.sse.pme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class DisplayProfile extends AppCompatActivity {

    Button notifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_profil);

       // notifications = (ImageButton) findViewById(R.id.add_friend);

        //notifications.setOnClickListener((View.OnClickListener) this);

    }

    public void acceptFriend(View view){
        Intent startNewActivity = new Intent(this, DisplayAccepRequest.class);
        startActivity(startNewActivity);

    }


}
