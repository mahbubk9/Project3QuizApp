package com.example.android.project3quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import java.text.DecimalFormat;

import android.widget.CheckBox;
import android.widget.Toast;


public class QuizActivity extends AppCompatActivity {

    //GLOBAL VARIABLES
    private float score=0;
    public String summaryResult="";
    public String q3Ans="";
    public String fullResult="T20 WORLD CUP QUIZ RESULT:";
    private TextView WelcomeView;
    private int q1click=0;
    private int q2click=0;
    private int q3click=0;
    private int q4click=0;
    private int q5click=0;
    private int q6click=0;
    private int q7click=0;
    private CheckBox q1cb1,q1cb2,q1cb3,q1cb4;
    private RadioButton q2r1,q2r2,q2r3, q2r4,q4r1,q4r2,q4r3,q4r4,q5r1,q5r2,q5r3,q5r4,q6r1,q6r2,q6r3,q6r4,q7r1,q7r2,q7r3,q7r4;
    private EditText q3;
    private Button ViewResult;

    //ON CREATE METHOD
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        WelcomeView=(TextView)findViewById(R.id.helloUser) ;
        q1cb1=(CheckBox)findViewById(R.id.q1cb1);
        q1cb2=(CheckBox)findViewById(R.id.q1cb2);
        q1cb3=(CheckBox)findViewById(R.id.q1cb3);
        q1cb4=(CheckBox)findViewById(R.id.q1cb4);
        q2r1=(RadioButton)findViewById(R.id.q2r1);
        q2r2=(RadioButton)findViewById(R.id.q2r2);
        q2r3=(RadioButton)findViewById(R.id.q2r3);
        q2r4=(RadioButton)findViewById(R.id.q2r4);
        q3=(EditText)findViewById(R.id.q3ans);
        q4r1=(RadioButton)findViewById(R.id.q4r1);
        q4r2=(RadioButton)findViewById(R.id.q4r2);
        q4r3=(RadioButton)findViewById(R.id.q4r3);
        q4r4=(RadioButton)findViewById(R.id.q4r4);
        q5r1=(RadioButton)findViewById(R.id.q5r1);
        q5r2=(RadioButton)findViewById(R.id.q5r2);
        q5r3=(RadioButton)findViewById(R.id.q5r3);
        q5r4=(RadioButton)findViewById(R.id.q5r4);
        q6r1=(RadioButton)findViewById(R.id.q6r1);
        q6r2=(RadioButton)findViewById(R.id.q6r2);
        q6r3=(RadioButton)findViewById(R.id.q6r3);
        q6r4=(RadioButton)findViewById(R.id.q6r4);
        q7r1=(RadioButton)findViewById(R.id.q7r1);
        q7r2=(RadioButton)findViewById(R.id.q7r2);
        q7r3=(RadioButton)findViewById(R.id.q7r3);
        q7r4=(RadioButton)findViewById(R.id.q7r4);
        ViewResult = (Button) findViewById(R.id.resultView);
        //GETTING NAME
        Bundle extras=getIntent().getExtras();
        String name=extras.getString("Name");
        WelcomeView.setText("Welcome "+name+"!"+"\n"+"CheckOut Your T20 World Cup Knowledge !");

        //RESULT BUTTON
        ViewResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countScore();

                if(q1click!=2){
                    Toast toast = Toast.makeText(getApplicationContext(), "Please Check Two Boxes For Question 1.", Toast.LENGTH_LONG);
                    toast.show(); // display the Toast

                }
                if(q2click!=1){
                    Toast toast = Toast.makeText(getApplicationContext(), "Please Answer Question 2.", Toast.LENGTH_LONG);
                    toast.show(); // display the Toast
                }


                if(TextUtils.isEmpty(q3.getText().toString())){
                    Toast toast = Toast.makeText(getApplicationContext(), "Please Answer Question 3.", Toast.LENGTH_LONG);
                    toast.show(); // display the Toast

                }
                else{
                    q3click=1;

                }

                if(q4click!=1){
                    Toast toast = Toast.makeText(getApplicationContext(), "Please Answer Question 4.", Toast.LENGTH_LONG);
                    toast.show(); // display the Toast

                }
                if(q5click!=1){
                    Toast toast = Toast.makeText(getApplicationContext(), "Please Answer Question 5.", Toast.LENGTH_LONG);
                    toast.show(); // display the Toast

                }
                if(q6click!=1){
                    Toast toast = Toast.makeText(getApplicationContext(), "Please Answer Question 6.", Toast.LENGTH_LONG);
                    toast.show(); // display the Toast

                }
                if(q7click!=1){
                    Toast toast = Toast.makeText(getApplicationContext(), "Please Answer Question 7.", Toast.LENGTH_LONG);
                    toast.show(); // display the Toast

                }
                if(q1click==2&&q2click==1&&q3click==1&&q4click==1&&q5click==1&&q6click==1&&q7click==1) {


                    saveSummary();
                    launchResult();
                }


                };















    });}
    //SCORING METHOD
    private void countScore() {
        fullResult = fullResult +"\n"+ "Q1. Which Two Countries Played In The Finals Of The Last T20 World Cup in 2016?";
        if (q1cb1.isChecked() && q1cb2.isChecked()) {
            score = 0;
            q1click = 2;
            fullResult = fullResult + "\n" + "Your Ans 1. South Africa and West Indies" + "\n" + "Correct Answer: West Indies and England";
        }
        if (q1cb1.isChecked() && q1cb3.isChecked()) {
            score = 0;
            q1click = 2;
            fullResult = fullResult + "\n" + "Your Ans 1. South Africa and India" + "\n" + "Correct Answer: West Indies and England";
        }
        if (q1cb1.isChecked() && q1cb4.isChecked()) {
            score = 0;
            q1click = 2;
            fullResult = fullResult + "\n" + "Your Ans 1. South Africa and England" + "\n" + "Correct Answer: West Indies and England";
        }
        if (q1cb2.isChecked() && q1cb3.isChecked()) {
            score = 0;
            q1click = 2;
            fullResult = fullResult + "\n" + "Your Ans 1. West Indies and India" + "\n" + "Correct Answer: West Indies and England";
        }
        if (q1cb2.isChecked() && q1cb4.isChecked()) {
            score = 1;
            q1click = 2;
            fullResult = fullResult + "\n" + "Your Ans 1. West Indies and England" + "\n" + "Correct Answer: West Indies and England, Well done!";
        }
        if (q1cb3.isChecked() && q1cb4.isChecked()) {
            score = 0;
            q1click = 2;
            fullResult = fullResult + "\n" + "Your Ans 1. India and England" + "\n" + "Correct Answer: West Indies and England";
        }
        fullResult = fullResult + "\n" + "Q2. Who Is The Current Cricket World T20   Champion?";
        if (q2r1.isChecked()) {
            score = score + 0;
            q2click = 1;
            fullResult = fullResult + "\n" + "Your Ans 2. South Africa" + "\n" + "Correct Answer: West Indies";
        }

        if (q2r2.isChecked()) {
            score = score + 1;
            q2click = 1;
            fullResult = fullResult + "\n" + "Your Ans 2. West Indies" + "\n" + "Correct Answer: West Indies,Well done!";
        }
        if (q2r3.isChecked()) {
            score = score + 0;
            q2click = 1;
            fullResult = fullResult + "\n" + "Your Ans 2. India" + "\n" + "Correct Answer: West Indies";
        }
        if (q2r4.isChecked()) {
            score = score + 0;
            q2click = 1;
            fullResult = fullResult + "\n" + "Your Ans 2. Australia" + "\n" + "Correct Answer: West Indies";
        }
        fullResult = fullResult + "\n" + "Q3. Who Was The Man Of The Tournament In 2016 World Cup?";
        q3Ans = q3.getText().toString();
        String correctAns = "Virat Kohli";
        if (q3Ans.equals(correctAns)) {
            score = score + 1;
            fullResult = fullResult + "\n" + "Your Ans 3." + q3Ans + "\n" + "Correct Answer: Virat Kohli, Well done!";
        } else {
            score = score + 0;

            fullResult = fullResult + "\n" + "Your Ans 3." + q3Ans + "\n" + "Correct Answer: Virat Kohli";
        }
        fullResult = fullResult + "\n" + "Q4. Who Scored The Most Runs In All T20 World Cups?";

        if (q4r1.isChecked()) {
            score = score + 0;
            q4click = 1;
            fullResult = fullResult + "\n" + "Your Ans 4. Chris Gayle" + "\n" + "Correct Answer: DPMD Jayawardene";
        }
        if (q4r2.isChecked()) {
            score = score + 0;
            q4click = 1;
            fullResult = fullResult + "\n" + "Your Ans 4. Virat Kohli" + "\n" + "Correct Answer: DPMD Jayawardene";
        }
        if (q4r3.isChecked()) {
            score = score + 1;
            q4click = 1;
            fullResult = fullResult + "\n" + "Your Ans 4. DPMD Jayawardene " + "\n" + "Correct Answer: DPMD Jayawardene, Well done!";
        }
        if (q4r4.isChecked()) {
            score = score + 0;
            q4click = 1;
            fullResult = fullResult + "\n" + "Your Ans 4. AB de Villiers" + "\n" + "Correct Answer: DPMD Jayawardene";
        }
        fullResult = fullResult + "\n" + "Q5. Who Took The Most Wickets In All T20 World Cups?";
        if (q5r1.isChecked()) {
            score = score + 0;
            q5click = 1;
            fullResult = fullResult + "\n" + "Your Ans 5. Dale Steyn" + "\n" + "Correct Answer: Shahid Afridi";
        }
        if (q5r2.isChecked()) {
            score = score + 0;
            q5click = 1;
            fullResult = fullResult + "\n" + "Your Ans 5. Lasith Malinga" + "\n" + "Correct Answer: Shahid Afridi";
        }
        if (q5r3.isChecked()) {
            score = score + 1;
            q5click = 1;
            fullResult = fullResult + "\n" + "Your Ans 5. Shahid Afridi" + "\n" + "Correct Answer: Shahid Afridi, Well done!";
        }
        if (q5r4.isChecked()) {
            score = score + 0;
            q5click = 1;
            fullResult = fullResult + "\n" + "Your Ans 5. Saeed Ajamal" + "\n" + "Correct Answer: Shahid Afridi";
        }
        fullResult = fullResult + "\n" + "Q6. Who Took The Most Catches In All T20 World Cups?";
        if (q6r1.isChecked()) {
            score = score + 0;
            q6click = 1;
            fullResult = fullResult + "\n" + "Your Ans 5. MJ Guptil" + "\n" + "Correct Answer: AB de Villiers";
        }
        if (q6r2.isChecked()) {
            score = score + 1;
            q6click = 1;
            fullResult = fullResult + "\n" + "Your Ans 5. AB de Villiers" + "\n" + "Correct Answer: AB de Villiers,Well done!";
        }
        if (q6r3.isChecked()) {
            score = score + 0;
            q6click = 1;
            fullResult = fullResult + "\n" + "Your Ans 5. DA Warner" + "\n" + "Correct Answer: AB de Villiers";
        }
        if (q6r4.isChecked()) {
            score = score + 0;
            q6click = 1;
            fullResult = fullResult + "\n" + "Your Ans 5. DJ Bravo" + "\n" + "Correct Answer: AB de Villiers";
        }
        fullResult = fullResult + "\n" + "7. Who Hit The Most Sixes In All T20 World Cups?";
        if (q7r1.isChecked()) {
            score = score + 0;
            q7click = 1;
            fullResult = fullResult + "\n" + "Your Ans 5. Yuvraj Singh" + "\n" + "Correct Answer: Chris Gayle";
        }
        if (q7r2.isChecked()) {
            score = score + 0;
            q7click = 1;
            fullResult = fullResult + "\n" + "Your Ans 5. SR Watson" + "\n" + "Correct Answer: Chris Gayle";
        }
        if (q7r3.isChecked()) {
            score = score + 1;
            q7click = 1;
            fullResult = fullResult + "\n" + "Your Ans 5. Chris Gayle " + "\n" + "Correct Answer: Chris Gayle, Well done!";
        }
        if (q7r4.isChecked()) {
            score = score + 0;
            q7click = 1;
            fullResult = fullResult + "\n" + "Your Ans 5. Yuvraj Singh" + "\n" + "Correct Answer: Chris Gayle";
            Log.i("QuizActivity",fullResult);
        }
    }



     //SAVING SUMMARY RESULT FOR RESULT PAGE
     private void saveSummary(){
        Bundle extras=getIntent().getExtras();
        String name=extras.getString("Name");


        float percent=(score/7)*100;
        percent=Math.round(percent);
        if(score<5){
            summaryResult=summaryResult+"Nice Try "+name+"!"+"\n"+"You Have Scored  "+Math.round(score)+" Out Of 7 Points In T20 World Cup Quiz!"+"\n"+"Your Score Is "+percent+" Percent!";

        }
        if(score>4){
            summaryResult=summaryResult+"Well Done "+name+"!"+"\n"+"You Have Scored  "+Math.round(score)+" Out Of 7 Points In T20 World Cup Quiz!"+"\n"+"Your Score Is "+percent+" Percent!";

        }
        //Log.i("QuizActivity",summaryResult);

    }
    //LAUNCHING RESULT PAGE
    private void launchResult() {

        Bundle extras=getIntent().getExtras();
        String name=extras.getString("Name");

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("summary",summaryResult);
        intent.putExtra("answers",fullResult);
        intent.putExtra("name",name);
        startActivity(intent);
    }
}
