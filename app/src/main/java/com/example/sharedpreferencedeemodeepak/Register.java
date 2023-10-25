package com.example.sharedpreferencedeemodeepak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    SessionManager sessionManager;
     EditText reg_name1,reg_email1,reg_pass1,reg_phon1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sessionManager = new SessionManager(getApplicationContext());

        setContentView(R.layout.activity_register);
        reg_name1 = (EditText) findViewById(R.id.reg_name1);
        reg_email1= (EditText) findViewById(R.id.reg_email1);
        reg_pass1= (EditText) findViewById(R.id.reg_pass1);
        reg_phon1= (EditText) findViewById(R.id.reg_phon1);
    }
    public void register(View view)
    {
         String name1 = reg_name1.getText().toString();
        String email1 = reg_email1.getText().toString();
        String pass1 = reg_pass1.getText().toString();
        String phno1 = reg_phon1.getText().toString();

        //insert into mysql database...............abhi nhi karere

        sessionManager.createSession(name1,email1,phno1);

        Intent intent = new Intent(this,Profile.class);
        startActivity(intent);
    }
    public void openLoginScreen(View view)
    {
        Intent intent = new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
    }
}