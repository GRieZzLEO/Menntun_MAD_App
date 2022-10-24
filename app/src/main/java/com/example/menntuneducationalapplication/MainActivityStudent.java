package com.example.menntuneducationalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivityStudent extends AppCompatActivity {

    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_student);

        name = findViewById(R.id.nameOfStd);
        name.setText(GlobalStudent._NAME);
    }

    public void toForum(View view){
        Intent X=new Intent(this, CreateForums.class);
        startActivity(X);
    }
    public void toQuiz(View view){
        Intent i =  new Intent(this, Quizzes.class);
        startActivity(i);
    }

    public void toPassPapers(View view){
        Intent z =  new Intent(this, PastPapers.class);
        startActivity(z);
    }
    public void toProfile(View view){
        Intent z =  new Intent(this, StudentProfile.class);
        startActivity(z);
    }
}