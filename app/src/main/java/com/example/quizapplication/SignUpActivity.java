package com.example.quizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Properties;



public class SignUpActivity extends AppCompatActivity {

    EditText signupName,signupEmail,signupUsername,signupPassword;
    TextView loginRedirectText;
    Button signupButton;
    FirebaseDatabase database;
    DatabaseReference reference,reference2;
    DatabaseReference referenceApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signupUsername = findViewById(R.id.signup_username);
        signupPassword = findViewById(R.id.signup_password);
        loginRedirectText = findViewById(R.id.loginRedirectText);
        signupButton = findViewById(R.id.signup_button);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");
                reference2 = database.getReference("questions");
                String username = signupUsername.getText().toString().trim();
                String password = signupPassword.getText().toString().trim();
                HelperClass helperClass = new HelperClass(username,password);
                reference.child(username).setValue(helperClass);
                Toast.makeText(SignUpActivity.this,"Успешная регистрация", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);


            }
        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }}