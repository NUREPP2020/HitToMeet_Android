package com.example.hittomeet;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends Activity {

    Button createButton;

    SessionManager session;

    EditText textName, textEmail, textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textName = (EditText) findViewById(R.id.editTextTextPersonName);
        textEmail = (EditText) findViewById(R.id.editTextTextEmailAddress);
        textPassword = (EditText) findViewById(R.id.editTextTextPassword);

        createButton = (Button) findViewById(R.id.button);

        createButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = textName.getText().toString().trim();
                String email = textEmail.getText().toString().trim();
                String password = textPassword.getText().toString().trim();

                boolean validName = Pattern.matches("[A-Za-zА-Яа-яЁёІіЇїЄє ]+", name);
                boolean validEmail = Pattern.matches("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", email);
                boolean validPass = Pattern.matches("(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#$%^&*]).{8,16}$", password);

                if(validName && validEmail && validPass){

                    session = new SessionManager(getApplicationContext());
                    session.createLoginSession(name, email, password);

                    Intent i = new Intent(getApplicationContext(), test.class);
                    startActivity(i);
                    finish();

                }else{

                    Toast.makeText(getApplicationContext(),"Введите данные в нужном формате", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }



}