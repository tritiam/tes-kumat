package com.example.kumat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MateriKelas4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_kelas4);
    }
    public void btnPerpangkatan(View view){
        Intent myIntent = new Intent(this, MateriPerpangkatanActivity.class);
        startActivity(myIntent);
    }
    public void btnFaktor(View view){
        Intent myIntent = new Intent(this, MateriFaktorActivity.class);
        startActivity(myIntent);
    }
    public void btnAkarpangkat(View view){
        Intent myIntent = new Intent(this, MateriAkarPangkatActivity.class);
        startActivity(myIntent);
    }
    public void btnKembali(View view){
        Intent myIntent = new Intent(this, MenuMateriActivity.class);
        startActivity(myIntent);
    }
    public void btnHome(View view){
        Intent myIntent = new Intent(this, MenuActivity.class);
        startActivity(myIntent);
    }
}