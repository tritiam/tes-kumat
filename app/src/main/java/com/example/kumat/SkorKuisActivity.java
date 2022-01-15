package com.example.kumat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SkorKuisActivity extends AppCompatActivity {

    // QuestionModel scores;
    TextView txtBenar, txtSalah, txtNilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skor_kuis);

        SharedPreferences sharedPref = SkorKuisActivity.this.getSharedPreferences("Settings", Context.MODE_PRIVATE);
        int _correct = sharedPref.getInt("_CORRECT", 0);
        int _wrong = sharedPref.getInt("_WRONG", 0);
        int _score = sharedPref.getInt("_SCORE", 0);

        // scores = new QuestionModel();

        txtBenar = findViewById(R.id.txtBenar);
        txtSalah = findViewById(R.id.txtSalah);
        txtNilai = findViewById(R.id.txtNilai);

        txtBenar.setText("Benar : " + _correct);
        txtSalah.setText("Salah : " + _wrong);
        txtNilai.setText("Nilai : " + _score);
    }

    public void btnHome(View view) {
        Intent myIntent = new Intent(this, MenuActivity.class);
        startActivity(myIntent);
    }

    public void ulangiKuis(View view) {
        Intent myIntent = new Intent(this, MenuKuisActivity.class);
        startActivity(myIntent);
    }
}