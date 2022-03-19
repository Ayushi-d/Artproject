package com.example.art_stationary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.art_stationary.Activity.MainActivity;

import java.util.regex.Pattern;

public class Signup extends AppCompatActivity {

     TextView text_haveacc;
     EditText et_email;
     EditText et_password;
     EditText et_name;
     Button button_signup;
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +
                    //"(?=.*[a-z])" +
                    //"(?=.*[A-Z])" +
                    "(?=.*[a-zA-Z])" +
                    "(?=.*[@#$%^&+=])" +
                    "(?=\\S+$)" +
                    ".{4,}" +
                    "$");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        et_name = findViewById(R.id.et_name);
        button_signup = findViewById(R.id.button_signup);
        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //add confirm input
                confirmInput(view);
            }
        });
        text_haveacc = findViewById(R.id.text_haveacc);
        text_haveacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent(Signup.this, Singin.class);
                startActivity(send);
            }
        });
    }
    private boolean validateEmail() {
        String emailInput = et_email.getText().toString().trim();

        if (emailInput.isEmpty()) {
            et_email.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            et_email.setError("Please enter a valid email address");
            return false;
        } else {
            et_email.setError(null);
            return true;
        }
    }

    private boolean validateUsername() {
        String usernameInput = et_name.getText().toString().trim();

        if (usernameInput.isEmpty()) {
            et_name.setError("Field can't be empty");
            return false;
        } else if (usernameInput.length() > 15) {
            et_name.setError("Username too long");
            return false;
        } else {
            et_name.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = et_password.getText().toString().trim();

        if (passwordInput.isEmpty()) {
            et_password.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            et_password.setError("Password too weak");
            return false;
        } else {
            et_password.setError(null);
            return true;
        }
    }

    public void confirmInput(View v) {
        if (!validateEmail() | !validateUsername() | !validatePassword()) {
            return;
        }

        String input = "Email: " + et_email.getText().toString();
        input += "\n";
        input += "Username: " + et_name.getText().toString();
        input += "\n";
        input += "Password: " + et_password.getText().toString();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }
}
