package com.example.sharedpreferencedeemodeepak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText log_email1,log_pass1;
    SessionManager sessionManager; //getSessionManager

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        log_email1 = (EditText) findViewById(R.id.log_email1);
        log_pass1 = (EditText) findViewById(R.id.log_pass1);

        sessionManager = new SessionManager(getApplicationContext());


    }
    public void login(View view)
    {
         String email1 = log_email1.getText().toString();
         String pass1 = log_pass1.getText().toString();
         if(email1.equals("punitprem123@gmail.com") && pass1.equals("12345"))
         {
             sessionManager.createSession("name","punitprem123@gmail.com","8057265635");
             Intent intent = new Intent(this,Profile.class);
             startActivity(intent);
         }
         else {
             Toast.makeText(this, "Email and Password did'n matche", Toast.LENGTH_SHORT).show();
         }
    }
    public void openRegisterScreen(View view){
        Intent intent  = new Intent(getApplicationContext(),Register.class);
        startActivity(intent);
    }
}