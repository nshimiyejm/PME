package com.pme.sse.pme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DisplayRegistration extends AppCompatActivity implements View.OnClickListener {
    Button regisBtn, cancelBtn;
    EditText uNmane, eMail, passw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_main);

        uNmane = (EditText) findViewById(R.id.uName);
        eMail = (EditText) findViewById(R.id.eMail);
        passw = (EditText) findViewById(R.id.passw);

        regisBtn = (Button) findViewById(R.id.regisBtn);
        cancelBtn = (Button) findViewById(R.id.cancelBtn);

        regisBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.regisBtn:
                    String username = uNmane.getText().toString();
                    String email = uNmane.getText().toString();
                    String password = uNmane.getText().toString();

                    Student RegisteredStudent = new Student(username,email, password);



                break;

            case R.id.cancelBtn:
                startActivity(new Intent(this, MainActivity.class));
                break;


        }
    }
}
