package com.example.hittomeet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class test extends Activity {

    SessionManager session;

    String name, email, password;

    TextView nameText, emailText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        session = new SessionManager(getApplicationContext());

        session.checkLogin();

        Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();

        HashMap<String, String> userinfo = session.getUserDetails();

        name = userinfo.get("name");

        email = userinfo.get("email");

        password = userinfo.get("password");

        nameText = (TextView) findViewById(R.id.textView4);
        emailText = (TextView) findViewById(R.id.textView2);
        passwordText = (TextView) findViewById(R.id.textView3);

        nameText.setText("name: " + name);
        emailText.setText("email: " + email);
        passwordText.setText("pass: " + password);

    }
}