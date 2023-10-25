package com.example.sharedpreferencedeemodeepak;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class SessionManager
{
    Context context;
    SharedPreferences sp; //SharedPreferences file create
    SharedPreferences.Editor  editor;//instance variable

    private final String PREF_FILE_NAME = "shopping";
    private final int PRIVATE_MODE = 0;

    //create kay
    private final String KEY_IF_LOGGED_IN = "false";
    private final String KEY_NAME = "KEY_SESSION_name";
    private final String KEY_EMAIL = "KEY_SESSION_email";
    private final String KEY_PHNO = "KEY_SESSION_phno";
    public SessionManager(Context context)
    {
        this.context = context;
        sp = context.getSharedPreferences(PREF_FILE_NAME,PRIVATE_MODE);
        editor =sp.edit();
    }

    public boolean checkSession(){
        if(sp.contains(KEY_IF_LOGGED_IN))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void createSession(String name , String email, String phon)
    {
        editor.putString(KEY_NAME,name);
        editor.putString(KEY_EMAIL,email);
        editor.putString(KEY_PHNO,phon );
        editor.putBoolean(KEY_IF_LOGGED_IN,true);
        editor.commit();
    }


    public String getSessionDetail(String key){
        String value =sp.getString(key,null);
         return value;
    }

    public void logoutSession()
    {
        editor.clear();
        editor.commit();

        Intent intent = new Intent(context,Login.class);
        context.startActivity(intent);
    }
}
