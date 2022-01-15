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

public class KuisKelas5Activity extends AppCompatActivity {

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
                        Toast.makeText(KuisKelas5Activity.this, "Please select an option", Toast.LENGTH_LONG).show();
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
                radio1.setTextColor(Color.GREEN);
                break;
            case 2:
                radio4.setTextColor(Color.GREEN);
                break;
            case 3:
                radio1.setTextColor(Color.GREEN);
                break;
            case 4:
                radio3.setTextColor(Color.GREEN);
                break;
            case 5:
                radio3.setTextColor(Color.GREEN);
                break;
            case 6:
                radio4.setTextColor(Color.GREEN);
                break;
            case 7:
                radio2.setTextColor(Color.GREEN);
                break;
            case 8:
                radio3.setTextColor(Color.GREEN);
                break;
            case 9:
                radio2.setTextColor(Color.GREEN);
                break;
            case 10:
                radio2.setTextColor(Color.GREEN);
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
                "Diketahui panjang EF adalah 6cm, maka luas bangun datar EFGH adalah.....cm?", R.drawable.image_kuis,
                "A. 36", 0,
                "B. 25", 0,
                "C. 49",0,
                "D. 16", 0,
                1));
        questionsList.add(new QuestionModel(
                "Luas lingkaran yang berjari-jari 14cm adalah.....cm?", 0,
                "A. 308", 0,
                "B. 154", 0,
                "C. 1232", 0,
                "D. 616", 0,
                2));
        questionsList.add(new QuestionModel(
                "Bangun kerucut sisi alasnya berbentuk?", 0,
                "A. lingkaran", 0,
                "B. persegi", 0,
                "C. persegi panjang", 0,
                "D. segitiga", 0,
                3));
        questionsList.add(new QuestionModel(
                "Luas persegi panjang jika diketahui panjangnya 30cm dan lebarnya 15cm adalah?", 0,
                "A. 132", 0,
                "B. 198", 0,
                "C. 450", 0,
                "D. 218", 0,
                4));
        questionsList.add(new QuestionModel(
                "Volume bangun tersebut adalah.....cm3?", 0,
                "A. 2.523", 0,
                "B. 2.325", 0,
                "C. 2.352", 0,
                "D. 2.532", 0,
                5));
        questionsList.add(new QuestionModel(
                "Sebuah tabung berdiameter 28cm dengan tinggi 10cm. Luas seluruh permukaan tabung adalah?", 0,
                "A. 1.056", 0,
                "B. 526", 0,
                "C. 4.224", 0,
                "D. 2.112", 0,
                6));
        questionsList.add(new QuestionModel(
                "(-18)-(-20)+ (-10)=?", 0,
                "A. 9", 0,
                "B. -8", 0,
                "C. 8", 0,
                "D. -9", 0,
                7));
        questionsList.add(new QuestionModel(
                "Suatu ruangan memiliki suhu -10 derajat celcius. sore harinya suhu diturunkan 22 derajat celcius.\n pagi hari keesokannya, suhu ruangan dinaikkan kembali 20 derajat celcius." +
                        "berapa suhu ruangan tersebut?", 0,
                "A. -4", 0,
                "B. -3", 0,
                "C. -2", 0,
                "D. -1", 0,
                8));
        questionsList.add(new QuestionModel(
                "1300 - (125 x 8) + 3=?", 0,
                "A. 324", 0,
                "B. 303", 0,
                "C. 333", 0,
                "D. 309", 0,
                9));
        questionsList.add(new QuestionModel(
                "( 255 : 5) + (-20)=.....", 0,
                "A. 41", 0,
                "B. 31", 0,
                "C. 51", 0,
                "D. 71", 0,
                10));
    }
    public void btnMenuKuis(View view){
        Intent myIntent = new Intent(this, MenuKuisActivity.class);
        startActivity(myIntent);
    }
}