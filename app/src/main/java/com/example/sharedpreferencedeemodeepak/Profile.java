package com.example.sharedpreferencedeemodeepak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    SessionManager sessionManager;//get session manager
     TextView profile_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profile_name = (TextView) findViewById(R.id.profile_name);

        sessionManager = new SessionManager(getApplicationContext());
         String name  =sessionManager.getSessionDetail("KEY_SESSION_name");
         profile_name.setText(name);

          String email = sessionManager.getSessionDetail("KEY_SESSION_email");

    }

    public void logout(View view){
        sessionManager.logoutSession();
    }
}