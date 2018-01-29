package com.example.android.project3quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button StartQuizButton;
    private EditText NameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StartQuizButton = (Button) findViewById(R.id.starQuiz);
        NameField=(EditText) findViewById(R.id.nameField);

        StartQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchActivity();
            }
        });
    }


        private void launchActivity() {

            Intent intent = new Intent(this, QuizActivity.class);
            String name =NameField.getText().toString();
            intent.putExtra("Name",name);
            startActivity(intent);
        }




    }

