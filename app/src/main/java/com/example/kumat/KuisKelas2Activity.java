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

public class KuisKelas2Activity extends AppCompatActivity {

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
                        Toast.makeText(KuisKelas2Activity.this, "Please select an option", Toast.LENGTH_LONG).show();
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
                radio1.setTextColor(Color.GREEN);
                break;
            case 3:
                radio4.setTextColor(Color.GREEN);
                break;
            case 4:
                radio3.setTextColor(Color.GREEN);
                break;
            case 5:
                radio2.setTextColor(Color.GREEN);
                break;
            case 6:
                radio3.setTextColor(Color.GREEN);
                break;
            case 7:
                radio3.setTextColor(Color.GREEN);
                break;
            case 8:
                radio4.setTextColor(Color.GREEN);
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
                "4 x 7 =",0,
                "A. 18", 0,
                "B. 28", 0,
                "C. 30",0,
                "D. 38", 0,
                1));
        questionsList.add(new QuestionModel(
                "Gambar di atas jika dijadikan bentuk perkalian adalah", R.drawable.nodua,
                "A. 4 x 2", 0,
                "B. 3 x 4", 0,
                "C. 4 x 4", 0,
                "D. 4 x 6", 0,
                2));
        questionsList.add(new QuestionModel(
                "6 + 6 + 6 + 6 + 6 =", 0,
                "A. 7 x 6", 0,
                "B. 4 x 6", 0,
                "C. 8 x 6", 0,
                "D. 5 x 6", 0,
                3));
        questionsList.add(new QuestionModel(
                "Putri membawa 4 keranjang buah apel, setiap keranjang berisi 8 buah apel. Berapa jumlah semua buah apel Putri?", 0,
                "A. 16", 0,
                "B. 24", 0,
                "C. 32", 0,
                "D. 38", 0,
                4));

        questionsList.add(new QuestionModel(
                "36 : 6 =", 0,
                "A. 4", 0,
                "B. 6", 0,
                "C. 8", 0,
                "D. 10", 0,
                5));

        questionsList.add(new QuestionModel(
                "Bentuk penjumlahan dari perkalian 3 x 4 adalah", 0,
                "A. 3+3+3", 0,
                "B. 3+3+3+3", 0,
                "C. 4+4+4", 0,
                "D. 4+4+4+4", 0,
                6));

        questionsList.add(new QuestionModel(
                "Ibu mempunyai 25 permen. Ibu memberikannya kepada 5 orang anaknya. Berapa permen yang didapat masing-masing anak?", 0,
                "A. 3", 0,
                "B. 4", 0,
                "C. 5", 0,
                "D. 6", 0,
                7));

        questionsList.add(new QuestionModel(
                "16 : 4 =", 0,
                "A. 1", 0,
                "B. 2", 0,
                "C. 3", 0,
                "D. 4", 0,
                8));

        questionsList.add(new QuestionModel(
                "Toni memiliki 54 buah rambutan. Lalu, ia bagikan kepada 6 temannya. Berapa buah rambutan yang diperoleh oleh masing-masing anak?", 0,
                "A. 3", 0,
                "B. 6", 0,
                "C. 9", 0,
                "D. 12", 0,
                9));

        questionsList.add(new QuestionModel(
                "Pak guru membawa 24 lembar tugas yang akan dibagikan kepada 12 orang siswanya. Masing-masing siswa mendapat.....lembar tugas",0,
                "A. 2", 0,
                "B. 3", 0,
                "C. 4", 0,
                "D. 5", 0,
                10));
    }
    public void btnMenuKuis(View view){
        Intent myIntent = new Intent(this, MenuKuisActivity.class);
        startActivity(myIntent);
    }
}