package com.example.quizapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    MaterialCardView easycard,mediumcard,hardcard,scoreboard,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        easycard = findViewById(R.id.easyCard);
//        mediumcard = findViewById(R.id.mediumCard);
        hardcard = findViewById(R.id.hardCard);
        scoreboard = findViewById(R.id.scoreCard);
        logout=findViewById(R.id.logout);
        Intent intent = getIntent();
        String login = intent.getStringExtra("login").toString();

//        easycard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent1 = new Intent(MainActivity.this,BasicQuiz.class);
//                intent1.putExtra("login",login);
//                startActivity(intent1);
//                finish();
//            }
//        });

//        mediumcard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent1 = new Intent(MainActivity.this,MediumQuiz.class);
//                intent1.putExtra("login",login);
//                startActivity(intent1);
//                finish();
//            }
//        });
        hardcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,HardQuiz.class);
                intent1.putExtra("login",login);
                startActivity(intent1);
                finish();
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent1);
                finish();
            }
        });
        scoreboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ScoreActivity.class));

            }
        });
    }


}