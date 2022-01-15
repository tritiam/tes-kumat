package com.example.kumat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class KuisKelas1Activity extends AppCompatActivity {

    private List<QuestionModel> questionsList;
    private TextView txtQuestion, txtQuestionNo;
    private RadioGroup radioGroup;
    private RadioButton radio1, radio2, radio3, radio4;
    private Button btnNext;
    private ImageView imgNovi; //, imgRadio1, imgRadio2, imgRadio3, imgRadio4;


    int totalQuestion;
    int qCounter = 0;
    int correct, wrong, score;

    private QuestionModel currentQuestion;
    private QuestionModel scors;

    ColorStateList radioColor;
    boolean answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis);

        questionsList = new ArrayList<>();

        scors = new QuestionModel();

        txtQuestion = findViewById(R.id.txtQuestion);
        txtQuestionNo  = findViewById(R.id.txtQuestionNo);
        radioGroup  = findViewById(R.id.radioGroup);
        radio1  = findViewById(R.id.radio1);
        radio2  = findViewById(R.id.radio2);
        radio3  = findViewById(R.id.radio3);
        radio4  = findViewById(R.id.radio4);
        btnNext = findViewById(R.id.btnNext);
        imgNovi = findViewById(R.id.imgNovi);

        radioColor = radio1.getTextColors();

        addQuestions();

        totalQuestion = questionsList.size();
        showNextQuestion();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answered == false) {
                    if(radio1.isChecked() || radio2.isChecked() || radio3.isChecked() || radio4.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(KuisKelas1Activity.this, "Please select an option", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Log.e("tes","shownex");
                    showNextQuestion();
                }
            }
        });
    }

    private void checkAnswer() {
        answered = true;
        RadioButton radioSelected = findViewById(radioGroup.getCheckedRadioButtonId());
        int answerNo = radioGroup.indexOfChild(radioSelected) + 1;
        if(answerNo == currentQuestion.getCorrectAnswer()) {
            score++;
            correct++;
        } else {
            wrong++;
        }
        radio1.setTextColor(Color.RED);
        radio2.setTextColor(Color.RED);
        radio3.setTextColor(Color.RED);
        radio4.setTextColor(Color.RED);
        switch (currentQuestion.getCorrectAnswer()) {
            case 1:
                radio2.setTextColor(Color.GREEN);
                break;
            case 2:
                radio3.setTextColor(Color.GREEN);
                break;
            case 3:
                radio4.setTextColor(Color.GREEN);
                break;
            case 4:
                radio4.setTextColor(Color.GREEN);
                break;
            case 5:
                radio1.setTextColor(Color.GREEN);
                break;
            case 6:
                radio2.setTextColor(Color.GREEN);
                break;
            case 7:
                radio2.setTextColor(Color.GREEN);
                break;
            case 8:
                radio3.setTextColor(Color.GREEN);
                break;
            case 9:
                radio3.setTextColor(Color.GREEN);
                break;
            case 10:
                radio1.setTextColor(Color.GREEN);
                break;
        }

        if(qCounter < totalQuestion) {
            btnNext.setText("Next");
        } else {
            btnNext.setText("Score");
        }
    }

    private void showNextQuestion() {

        radioGroup.clearCheck();
        radio1.setTextColor(radioColor);
        radio2.setTextColor(radioColor);
        radio3.setTextColor(radioColor);
        radio4.setTextColor(radioColor);

        if(qCounter < totalQuestion) {

            currentQuestion = questionsList.get(qCounter);

            if(currentQuestion.getQuestion().length() > 0) {
                txtQuestion.setText(currentQuestion.getQuestion());
                txtQuestion.setVisibility(View.VISIBLE);
                // txtQuestion.setHeight(txtQuestion.getLayoutParams().WRAP_CONTENT);
            } else {
                txtQuestion.setVisibility(View.GONE);
                // txtQuestion.setHeight(0);
            }

            if(currentQuestion.getQuestionImage() > 0) {
                imgNovi.setImageResource(currentQuestion.getQuestionImage());
            } else {
                imgNovi.setImageDrawable(null);
            }

            if(currentQuestion.getOption1Image() > 0) {
                radio1.setBackgroundResource(currentQuestion.getOption1Image());
            } else {
                radio1.setText(currentQuestion.getOption1());
            }

            if(currentQuestion.getOption2Image() > 0) {
                radio2.setBackgroundResource(currentQuestion.getOption2Image());
            } else {
                radio2.setText(currentQuestion.getOption2());
            }

            if(currentQuestion.getOption3Image() > 0) {
                radio3.setBackgroundResource(currentQuestion.getOption3Image());
            } else {
                radio3.setText(currentQuestion.getOption3());
            }

            if(currentQuestion.getOption4Image() > 0) {
                radio4.setBackgroundResource(currentQuestion.getOption4Image());
            } else {
                radio4.setText(currentQuestion.getOption4());
            }

            qCounter++;
            btnNext.setText("Submit");
            txtQuestionNo.setText("Question: " + qCounter + "/" + totalQuestion);
            answered = false;

        } else {

            SharedPreferences sharedPref = this.getSharedPreferences("Settings", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("_CORRECT", correct);
            editor.putInt("_WRONG", wrong);
            editor.putInt("_SCORE", score);
            editor.commit();

            Intent intent = new Intent(this, SkorKuisActivity.class);
            startActivity(intent);
        }
    }


    private void addQuestions() {
        questionsList.add(new QuestionModel(
                "",R.drawable.image92,
                "A. 5", 0,
                "B. 7", 0,
                "C. 6",0,
                "D. 8", 0,
                1));
        questionsList.add(new QuestionModel(
                "", R.drawable.__5_,
                "A. 8", 0,
                "B. 9", 0,
                "C. 10", 0,
                "D. 11", 0,
                2));
        questionsList.add(new QuestionModel(
                "", R.drawable.novi45,
                "A. 400", 0,
                "B. 410", 0,
                "C. 429", 0,
                "D. 439", 0,
                3));
        questionsList.add(new QuestionModel(
                "Anggi memiliki 30 buah kelereng lalu si Agus memberikan kelereng yang dimilikinya " +
                        "kepada Anggi sebanyak 13 buah berapakah seluruh kelereng yang dimiliki Anggi?", 0,
                "A. 10", 0,
                "B. 30", 0,
                "C. 45", 0,
                "D. 43", 0,
                4));

        questionsList.add(new QuestionModel(
                "Dikota ada 2 macam taxsi, taxsi melati berjumlah 184 mobil" +
                        "taxsi Dahlia berjumlah 153 mobil berapakah jumlah taxsi di kota.", 0,
                "A. 337", 0,
                "B. 237", 0,
                "C. 117", 0,
                "D. 107", 0,
                5));

        questionsList.add(new QuestionModel(
                "", R.drawable.novi75,
                "A. 5", 0,
                "B. 2", 0,
                "C. 4", 0,
                "D. 8", 0,
                6));

        questionsList.add(new QuestionModel(
                "Nilai dari 4 - 7 =", R.drawable.novi22,
                "A. 3", 0,
                "B. -3", 0,
                "C. 4", 0,
                "D. -4", 0,
                7));

        questionsList.add(new QuestionModel(
                "", R.drawable.novi65,
                "A. 885", 0,
                "B. 776", 0,
                "C. 785", 0,
                "D. 985", 0,
                8));

        questionsList.add(new QuestionModel(
                " Andi memiliki 75 kelereng lalu saat bermain, kelereng Andi jatuh " +
                        "dalam selokan sebanyak 25 buah, berapakah jumlah kelereng Andi yang tersisa", 0,
                "A. 45", 0,
                "B. 30", 0,
                "C. 50", 0,
                "D. 35", 0,
                9));

        questionsList.add(new QuestionModel(
                "Ayah mempunyai bibit cabai sebanyak 86 batang pada hari senin " +
                        "di tanam sebanyak 64 batang, pada hari selasa di tanam sebanyak 12 batang berapakah " +
                        "jumlah bibit cabai yang belum di tanam?",0,
                "A. 10", 0,
                "B. 12", 0,
                "C. 22", 0,
                "D. 14", 0,
                10));
    }
    public void btnMenuKuis(View view){
        Intent myIntent = new Intent(this, MenuKuisActivity.class);
        startActivity(myIntent);
    }
}