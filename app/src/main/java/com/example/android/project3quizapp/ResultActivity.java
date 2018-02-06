package com.example.android.project3quizapp;

import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.Collection;
import java.util.Arrays;

public class ResultActivity extends AppCompatActivity {
    //GLOBAL VARIABLES
    private TextView SummaryView;
    private TextView AnswerView;
    private Button Answer;
    private Button Retake;
    private Button Share;
    int answerClickCount=0;
    static final String ANSWERS_TEXT="Answers";

    //ON CREATE METHOD
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        SummaryView = (TextView) findViewById(R.id.resultdiplay);
        AnswerView = (TextView) findViewById(R.id.answerdiplay);
        Retake = (Button) findViewById(R.id.retake);
        Share = (Button) findViewById(R.id.share);
        Answer = (Button) findViewById(R.id.answers);
        Bundle extras = getIntent().getExtras();
        String summaryResult = extras.getString("summary");
        String answers = extras.getString("answers");
        SummaryView.setText(summaryResult);
        //ANSWER BUTTON
        Answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerClickCount=answerClickCount+1;

                AnswerView.setText(answers);

            }

        });
        //RETAKE BUTTON
        Retake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Bundle extras = getIntent().getExtras();
                String name=extras.getString("name");

                Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                intent.putExtra("Name", name);
                startActivity(intent);

            }

        });
        //SHARE BUTTON
        Share.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Bundle extras = getIntent().getExtras();
                String summaryResult = extras.getString("summary");

                final String answers = extras.getString("answers");
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_SUBJECT, "T20 World Cup Cricket Quiz Result!");
                intent.putExtra(Intent.EXTRA_TEXT,summaryResult+"\n"+answers);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
    //SAVED INSTANCE STATE
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        if(answerClickCount>0){
            Bundle extras = getIntent().getExtras();
            final String answers = extras.getString("answers");
            savedInstanceState.putString(ANSWERS_TEXT,answers);
        }


        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }
    //RESTORE INSTANCE STATE
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);
        String answers=savedInstanceState.getString(ANSWERS_TEXT);
        AnswerView.setText(answers);
        answerClickCount=answerClickCount+1;

    }

}
