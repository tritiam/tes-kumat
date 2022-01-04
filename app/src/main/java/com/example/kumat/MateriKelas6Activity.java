package com.example.kumat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MateriKelas6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_kelas6);
    }
    public void btnPengolahan(View view){
        Intent myIntent = new Intent(this, MateriPengolahanDataActivity.class);
        startActivity(myIntent);
    }
    public void btnPenyajian(View view){
        Intent myIntent = new Intent(this, MateriPenyajianDataActivity.class);
        startActivity(myIntent);
    }
    public void btnSistem(View view){
        Intent myIntent = new Intent(this, MateriKoordinatKartesiusActivity.class);
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