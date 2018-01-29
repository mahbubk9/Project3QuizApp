package com.example.android.project3quizapp;

import android.content.res.Resources;
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
    private TextView SummaryView;
    private TextView AnswerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        SummaryView=(TextView)findViewById(R.id.resultdiplay) ;
        AnswerView=(TextView)findViewById(R.id.answerdiplay);
        Bundle extras=getIntent().getExtras();
        String summaryResult=extras.getString("summary");
        String answers=extras.getString("answers");
        SummaryView.setText(summaryResult);
        AnswerView.setText(answers);





    }
}
