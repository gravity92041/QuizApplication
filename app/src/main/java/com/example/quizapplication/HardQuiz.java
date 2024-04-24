package com.example.quizapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HardQuiz extends AppCompatActivity {
    TextView quiztext,aans,bans,cans,dans;
    List<QuestionItem> questionItems,limitedList;
    int currentQuestion=0;
    int correct=0,wrong=0;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        quiztext =findViewById(R.id.quizText);
        aans=findViewById(R.id.aanswer);
        bans=findViewById(R.id.banswer);
        cans=findViewById(R.id.canswer);
        dans=findViewById(R.id.danswer);
        loadAllQuestions();
        int limit = 10;

        Collections.shuffle(questionItems);
        limitedList = questionItems.subList(0,Math.min(questionItems.size(),limit));
        setQuestionScreen(currentQuestion);
        Intent intentFrom = getIntent();
        String login = intentFrom.getStringExtra("login");

        aans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (limitedList.get(currentQuestion).getAnswer1().equals(limitedList.get(currentQuestion).getCorrect())){
                    correct++;
                    aans.setBackgroundResource(R.color.green);
                    aans.setTextColor(getResources().getColor(R.color.white));
                }
                else {
                    wrong++;
                    aans.setBackgroundResource(R.color.red);
                    aans.setTextColor(getResources().getColor(R.color.white));
                }
                if (currentQuestion<limitedList.size()-1){
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestion++;
                            setQuestionScreen(currentQuestion);
                            aans.setBackgroundResource(R.color.white);
                            aans.setTextColor(getResources().getColor(R.color.text_secondary_color));
                        }
                    },500);
                }else {
                    Intent intent = new Intent(HardQuiz.this,ResultActivity.class);
                    intent.putExtra("correct",correct);
                    intent.putExtra("wrong",wrong);
                    intent.putExtra("login",login);
                    startActivity(intent);
                    finish();
                }
            }
        });
        bans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (limitedList.get(currentQuestion).getAnswer2().equals(limitedList.get(currentQuestion).getCorrect())){
                    correct++;
                    bans.setBackgroundResource(R.color.green);
                    bans.setTextColor(getResources().getColor(R.color.white));
                }
                else {
                    wrong++;
                    bans.setBackgroundResource(R.color.red);
                    bans.setTextColor(getResources().getColor(R.color.white));
                }
                if (currentQuestion<limitedList.size()-1){
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestion++;
                            setQuestionScreen(currentQuestion);
                            bans.setBackgroundResource(R.color.white);
                            bans.setTextColor(getResources().getColor(R.color.text_secondary_color));
                        }
                    },500);
                }else {
                    Intent intent = new Intent(HardQuiz.this,ResultActivity.class);
                    intent.putExtra("correct",correct);
                    intent.putExtra("wrong",wrong);
                    intent.putExtra("login",login);
                    startActivity(intent);
                    finish();
                }
            }
        });
        cans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (limitedList.get(currentQuestion).getAnswer3().equals(limitedList.get(currentQuestion).getCorrect())){
                    correct++;
                    cans.setBackgroundResource(R.color.green);
                    cans.setTextColor(getResources().getColor(R.color.white));
                }
                else {
                    wrong++;
                    cans.setBackgroundResource(R.color.red);
                    cans.setTextColor(getResources().getColor(R.color.white));
                }
                if (currentQuestion<limitedList.size()-1){
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestion++;
                            setQuestionScreen(currentQuestion);
                            cans.setBackgroundResource(R.color.white);
                            cans.setTextColor(getResources().getColor(R.color.text_secondary_color));
                        }
                    },500);
                }else {
                    Intent intent = new Intent(HardQuiz.this,ResultActivity.class);
                    intent.putExtra("correct",correct);
                    intent.putExtra("wrong",wrong);
                    intent.putExtra("login",login);
                    startActivity(intent);
                    finish();
                }
            }
        });
        dans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (limitedList.get(currentQuestion).getAnswer4().equals(limitedList.get(currentQuestion).getCorrect())){
                    correct++;
                    dans.setBackgroundResource(R.color.green);
                    dans.setTextColor(getResources().getColor(R.color.white));
                }
                else {
                    wrong++;
                    dans.setBackgroundResource(R.color.red);
                    dans.setTextColor(getResources().getColor(R.color.white));
                }
                if (currentQuestion<limitedList.size()-1){
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestion++;
                            setQuestionScreen(currentQuestion);
                            dans.setBackgroundResource(R.color.white);
                            dans.setTextColor(getResources().getColor(R.color.text_secondary_color));
                        }
                    },500);
                }else {
                    Intent intent = new Intent(HardQuiz.this,ResultActivity.class);
                    intent.putExtra("correct",correct);
                    intent.putExtra("wrong",wrong);
                    intent.putExtra("login",login);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void setQuestionScreen(int currentQuestion) {
        quiztext.setText(limitedList.get(currentQuestion).getQuestions());
        aans.setText(limitedList.get(currentQuestion).getAnswer1());
        bans.setText(limitedList.get(currentQuestion).getAnswer2());
        cans.setText(limitedList.get(currentQuestion).getAnswer3());
        dans.setText(limitedList.get(currentQuestion).getAnswer4());
    }

    private void loadAllQuestions(){
        questionItems=new ArrayList<>();

        String jsonquiz = loadJsonFromAsset("hardquestions.json");
        try {
            JSONObject jsonObject = new JSONObject(jsonquiz);
            JSONArray questions = jsonObject.getJSONArray("hardquestions");
            for (int i = 0; i <questions.length(); i++) {
                JSONObject question = questions.getJSONObject(i);

                String questionsString = question.getString("question");
                String answer1String = question.getString("answer1");
                String answer2String = question.getString("answer2");
                String answer3String = question.getString("answer3");
                String answer4String = question.getString("answer4");
                String correctString = question.getString("correct");

                questionItems.add(new QuestionItem(questionsString,answer1String,answer2String,answer3String,answer4String,correctString));
            }
        }catch (JSONException e ){
            e.printStackTrace();
        }
    }

    private String loadJsonFromAsset(String s){
        String json = "";
        try {
            InputStream inputStream = getAssets().open(s);
            int size = inputStream.available();
            byte[] buffer=new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json=new String(buffer,"UTF-8");
        }catch (IOException e){
            e.printStackTrace();
        }
        return json;
    }

    @Override
    public void onBackPressed() {
        Intent intentFrom = getIntent();
        String login = intentFrom.getStringExtra("login");
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(HardQuiz.this);
        materialAlertDialogBuilder.setTitle(R.string.app_name);
        materialAlertDialogBuilder.setMessage("Вы уверены что хотите перстать отвечать на вопросы?");
        materialAlertDialogBuilder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        materialAlertDialogBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent1 = new Intent(HardQuiz.this,MainActivity.class);
                intent1.putExtra("login",login);
                startActivity(intent1);
                finish();
            }
        });
        materialAlertDialogBuilder.show();
    }
}