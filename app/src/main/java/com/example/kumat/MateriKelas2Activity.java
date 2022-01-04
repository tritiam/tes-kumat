package com.example.kumat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MateriKelas2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_kelas2);
    }
    public void btnPerkalian(View view){
        Intent myIntent = new Intent(this, MateriPerkalianActivity.class);
        startActivity(myIntent);
    }
    public void btnPembagian(View view){
        Intent myIntent = new Intent(this, MateriPembagianActivity.class);
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