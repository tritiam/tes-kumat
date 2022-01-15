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

public class KuisKelas6Activity extends AppCompatActivity {

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
                        Toast.makeText(KuisKelas6Activity.this, "Please select an option", Toast.LENGTH_LONG).show();
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
                radio3.setTextColor(Color.GREEN);
                break;
            case 2:
                radio2.setTextColor(Color.GREEN);
                break;
            case 3:
                radio2.setTextColor(Color.GREEN);
                break;
            case 4:
                radio1.setTextColor(Color.GREEN);
                break;
            case 5:
                radio4.setTextColor(Color.GREEN);
                break;
            case 6:
                radio2.setTextColor(Color.GREEN);
                break;
            case 7:
                radio4.setTextColor(Color.GREEN);
                break;
            case 8:
                radio3.setTextColor(Color.GREEN);
                break;
            case 9:
                radio1.setTextColor(Color.GREEN);
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
                "Cari modus dari data hasil penimbangan berat badan (kg) siswa kelas V SD Putra Bangsa berikut.\n 25, 28, 30, 37, 30, 37, 24, 35, 23, 24, 35, 38, 25, 30, 35, 24, 37, 30, 38, 29", 0,
                "A. 37", 0,
                "B. 25", 0,
                "C. 30",0,
                "D. 24", 0,
                1));
        questionsList.add(new QuestionModel(
                "Cari median dari data pembuatan roti di sebuah pabrik dalam beberapa hari berikut.\n 20, 30, 25, 32, 26, 33, 36, 34, 28, 29", 0,
                "A. 29", 0,
                "B. 29,5", 0,
                "C. 30", 0,
                "D. 28,5", 0,
                2));
        questionsList.add(new QuestionModel(
                "Hasil panen kakek selama 5 bulan dalam ton adalah 10, 6, 7, 9, 8. Rata-rata hasil panen kakek tiap bulan adalah", 0,
                "A. 7", 0,
                "B. 8", 0,
                "C. 9", 0,
                "D. 10", 0,
                3));
        questionsList.add(new QuestionModel(
                "Rata-rata dan median dari data di atas adalah", R.drawable.gambart,
                "A. Rata-rata = 7,5 dan median = 7", 0,
                "B. Rata-rata = 7,5 dan median = 7,5", 0,
                "C. Rata-rata = 7 dan median = 7,5", 0,
                "D. Rata-rata = 7,5 dan median = 8", 0,
                4));
        questionsList.add(new QuestionModel(
                "Modus data tersebut pada gaji adalah", R.drawable.gambarti,
                "A. 4 Juta", 0,
                "B. 7 Juta", 0,
                "C. 5 Juta", 0,
                "D. 3 Juta", 0,
                5));
        questionsList.add(new QuestionModel(
                "Garis EF memiliki koordinat titik E(2, 3) dan titik F(2, -7). Garis tersebut akan", 0,
                "A. Sejajar sumbu X", 0,
                "B. Sejajar sumbu Y", 0,
                "C. Memotong sumbu X", 0,
                "D. Memotong sumbu Y", 0,
                6));
        questionsList.add(new QuestionModel(
                "Koordinat titik-titik sudut trapesium PQRS berturut-turut adalah", R.drawable.gambartia,
                "A. (-2, 4), (-2, 2), (5, -2), (2, 4)", 0,
                "B. (2, 4), (2, 2), (5, 2), (2, 4)", 0,
                "C. (2, 4), (-2, -2), (5, -2), (2, 4)", 0,
                "D. (-2, 4), (-2, -2), (5, -2), (2, 4)", 0,
                7));
        questionsList.add(new QuestionModel(
                "Koordinat titik P adalah", R.drawable.gambartiar,
                "A. (-2, -2)", 0,
                "B. (-1, 2)", 0,
                "C. (-2, 1)", 0,
                "D. (1, -2)", 0,
                8));
        questionsList.add(new QuestionModel(
                "Koordinat titik R (-4, 2). Titik R berada disebelah ... sumbu X", 0,
                "A. Atas", 0,
                "B. Bawah", 0,
                "C. Kanan", 0,
                "D. Kiri", 0,
                9));
        questionsList.add(new QuestionModel(
                "Koordinat titik P adalah", R.drawable.gambartiara,
                "A. (3, 2)", 0,
                "B. (3, -2)", 0,
                "C. (2, 3)", 0,
                "D. (2, -3)", 0,
                10));
    }
    public void btnMenuKuis(View view){
        Intent myIntent = new Intent(this, MenuKuisActivity.class);
        startActivity(myIntent);
    }
}