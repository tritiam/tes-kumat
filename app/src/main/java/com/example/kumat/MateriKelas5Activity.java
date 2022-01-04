package com.example.kumat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MateriKelas5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_kelas5);
    }
    public void btnOperasi(View view){
        Intent myIntent = new Intent(this, MateriOperasiHitungActivity.class);
        startActivity(myIntent);
    }
    public void btnBgndatar(View view){
        Intent myIntent = new Intent(this, MateriBangunDatarActivity.class);
        startActivity(myIntent);
    }
    public void btnBgnruang(View view){
        Intent myIntent = new Intent(this, MateriBangunRuangActivity.class);
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