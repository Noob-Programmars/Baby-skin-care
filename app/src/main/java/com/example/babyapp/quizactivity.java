package com.example.babyapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class quizactivity extends AppCompatActivity implements View.OnClickListener{
    TextView quiztotalQues,questions;
    Button ansA,ansB,ansC,ansD,submit;
    int quizscore=0,quiztotalquestions=QuestionAnswers.questions.length,quizcurrentquestionindex=0;
    String selectedans="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizactivity);
        quiztotalQues = findViewById(R.id.quiztotalquestions);
        questions=findViewById(R.id.quizquestiontext);
        ansA = findViewById(R.id.ans_a);
        ansB = findViewById(R.id.ans_b);
        ansC = findViewById(R.id.ans_c);
        ansD = findViewById(R.id.ans_d);
        submit = findViewById(R.id.quizsubmitbutton);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submit.setOnClickListener(this);

        quiztotalQues.setText("Total Questions: "+quiztotalquestions);
        loadnewquestion();

    }

    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedbutton = (Button) view;
        if(clickedbutton.getId()==R.id.quizsubmitbutton){
            if(selectedans.equals(QuestionAnswers.correctans[quizcurrentquestionindex])){
                quizscore++;
            }
            quizcurrentquestionindex++;
            loadnewquestion();

        }else{
            selectedans=clickedbutton.getText().toString();
            clickedbutton.setBackgroundColor(Color.MAGENTA);
        }
    }
    void loadnewquestion(){
        if(quizcurrentquestionindex==quiztotalquestions){
            finishQuiz();
            return;
        }
        questions.setText(QuestionAnswers.questions[quizcurrentquestionindex]);
        ansA.setText(QuestionAnswers.choices[quizcurrentquestionindex][0]);
        ansB.setText(QuestionAnswers.choices[quizcurrentquestionindex][1]);
        ansC.setText(QuestionAnswers.choices[quizcurrentquestionindex][2]);
        ansD.setText(QuestionAnswers.choices[quizcurrentquestionindex][3]);
    }
    void finishQuiz(){
        String passStatus = "";
        if(quizscore>quiztotalquestions*0.60)
        {
            passStatus="Passed";
        }else
        {
            passStatus="Failed";
        }
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(quizactivity.this);
        builder.setTitle(passStatus);
        builder.setMessage("Score " + quizscore + " out of " + quiztotalquestions + " is: ");

        //Button One
        builder.setPositiveButton("Show answers", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(quizactivity.this,quizshowanswers.class);
                startActivity(intent);
            }
        });
        AlertDialog diag = builder.create();
        diag.show();

        builder.setNegativeButton("Restart",(dialogInterface, i) -> restartQuiz()).setCancelable(true).show();
        diag.dismiss();


    }
    void restartQuiz() {
        quizscore=0;
        quizcurrentquestionindex=0;
        loadnewquestion();

}
}