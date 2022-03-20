package com.example.art_stationary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.art_stationary.Activity.ForgotPassword;
import com.example.art_stationary.Activity.MainActivity;

import java.util.regex.Pattern;

public class Singin extends AppCompatActivity {
    TextView txt_donthaveacc;
    TextView text_forgotpass;
    TextView button_signin;
    EditText et_email;
    EditText et_password;

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
        setContentView(R.layout.signin);
        txt_donthaveacc = findViewById(R.id.txt_donthaveacc);
        text_forgotpass = findViewById(R.id.text_forgotpass);
        button_signin = findViewById(R.id.button_signin);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);

        txt_donthaveacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent noaccintent = new Intent(getApplicationContext(), Signup.class);
                startActivity(noaccintent);
            }
        });

        button_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add confirm input
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                //confirmInput(view);
            }
        });
        text_forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forgotintent = new Intent(Singin.this, ForgotPassword.class);
                startActivity(forgotintent);
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
        if ( !validateEmail() | !validatePassword()) {
            return;
        }

        String input = "Email: " + et_email.getText().toString();
        input += "\n";
        input += "Password: " + et_password.getText().toString();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }

}