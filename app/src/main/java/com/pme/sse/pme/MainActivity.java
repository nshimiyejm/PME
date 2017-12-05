package com.pme.sse.pme;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
