package com.example.hittomeet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity2 extends Activity {

    Button createButton;

    EditText textEmail, textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textEmail = (EditText) findViewById(R.id.editTextTextEmailAddress);
        textPassword = (EditText) findViewById(R.id.editTextTextPassword);

        createButton = (Button) findViewById(R.id.button);

        createButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String email = textEmail.getText().toString().trim();
                String password = textPassword.getText().toString().trim();

                boolean validEmail = Pattern.matches("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", email);
                boolean validPass = Pattern.matches("(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#$%^&*]).{8,16}$", password);

                if(validEmail && validPass){

                    Intent i = new Intent(getApplicationContext(), test.class);
                    startActivity(i);
                    finish();

                } else {

                    Toast.makeText(getApplicationContext(),"Введите данные в нужном формате", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}