package com.example.kumat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MateriKelas1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_kelas1);
    }
    public void btnPenjumlahan(View view){
        Intent myIntent = new Intent(this, MateriPenjumlahanActivity.class);
        startActivity(myIntent);
    }
    public void btnPengurangan(View view){
        Intent myIntent = new Intent(this, MateriPenguranganActivity.class);
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