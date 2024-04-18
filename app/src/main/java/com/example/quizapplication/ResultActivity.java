package com.example.quizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.card.MaterialCardView;

public class ResultActivity extends AppCompatActivity {
    MaterialCardView home;
    TextView corectt,wrongg,resultInfo,resultScore;
    ImageView resultImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        home = findViewById(R.id.returnHome);
        corectt = findViewById(R.id.correctScore);
        wrongg = findViewById(R.id.wrongScore);
        resultInfo = findViewById(R.id.resultInfo);
        resultScore = findViewById(R.id.resultScore);
        resultImage = findViewById(R.id.resultImage);
        int correct = getIntent().getIntExtra("correct",0);
        int wrong = getIntent().getIntExtra("wrong",0);
        int score = correct * 5;

        corectt.setText(""+correct);
        wrongg.setText(""+wrong);
        resultScore.setText("Итоговый счет: "+score);
        if (correct<wrong){
            resultInfo.setText("Тяжело.....");
            resultImage.setImageResource(R.drawable.sad_pon);
        }
        if (correct==wrong){
            resultInfo.setText("Ну такое....");
            resultImage.setImageResource(R.drawable.mediumsad_pon1);
        }
        if (correct>wrong){
            resultInfo.setText("Харош!!!");
            resultImage.setImageResource(R.drawable.smart_pon);
        }

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this,MainActivity.class));
                finish();
            }
        });
    }
    @Override
    public void onBackPressed(){
        startActivity(new Intent(ResultActivity.this,MainActivity.class));
        finish();
    }
}