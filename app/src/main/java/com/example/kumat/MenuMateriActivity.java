package com.example.kumat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MenuMateriActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_materi);

        ImageView btnKelas1 = findViewById(R.id.btnKelas1);
        ImageView btnKelas2 = findViewById(R.id.btnKelas2);
        ImageView btnKelas3 = findViewById(R.id.btnKelas3);
        ImageView btnKelas4 = findViewById(R.id.btnKelas4);
        ImageView btnKelas5 = findViewById(R.id.btnKelas5);
        ImageView btnKelas6 = findViewById(R.id.btnKelas6);

        btnKelas1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuMateriActivity.this, MateriKelas1Activity.class));
            }
        });
        btnKelas2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuMateriActivity.this, MateriKelas2Activity.class));
            }
        });
        btnKelas3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuMateriActivity.this, MateriKelas3Activity.class));
            }
        });
        btnKelas4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuMateriActivity.this, MateriKelas4Activity.class));
            }
        });
        btnKelas5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuMateriActivity.this, MateriKelas5Activity.class));
            }
        });
        btnKelas6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuMateriActivity.this, MateriKelas6Activity.class));
            }
        });
    }
    public void btnKembali(View view){
        Intent myIntent = new Intent(this, MenuActivity.class);
        startActivity(myIntent);
    }
}