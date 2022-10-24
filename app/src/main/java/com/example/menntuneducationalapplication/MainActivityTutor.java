package com.example.menntuneducationalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivityTutor extends AppCompatActivity {

    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tutor);

        name = findViewById(R.id.nameOfTut);
        name.setText(GlobalTutor._NAME);
    }

    public void toForum(View view){
        Intent X=new Intent(this, SubjectSelectorForForums.class);
        startActivity(X);
    }
    public void toQuiz(View view){
        Intent i =  new Intent(this, QuizzesTutor.class);
        startActivity(i);
    }

    public void toPassPapers(View view){
        Intent z =  new Intent(this, PastPaperTutor.class);
        startActivity(z);
    }
    public void toProfile(View view){
        Intent z =  new Intent(this, TutorProfile.class);
        startActivity(z);
    }
}