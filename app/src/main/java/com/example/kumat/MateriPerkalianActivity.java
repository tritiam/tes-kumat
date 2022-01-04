package com.example.kumat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MateriPerkalianActivity extends AppCompatActivity {
    TextView tvdeskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_perkalian);

        ImageView lefticon = findViewById(R.id.lefticon);
        TextView title = findViewById(R.id.toolbartitle);

        lefticon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MateriKelas2Activity.class));
            }
        });
        title.setText("Perkalian");
        tvdeskripsi=(TextView) findViewById(R.id.perkalian);
        tvdeskripsi.setText("Ada 3 kantong kelereng.\n" +
                "Setiap kantong berisi 10 kelereng.\n" +
                "Banyak kelereng seluruhnya dapat ditentukan dengan cara berikut.");

        tvdeskripsi=(TextView) findViewById(R.id.dari);
        tvdeskripsi.setText("Dari gambar dapat dilihat bahwa kedua kumpulan bola sama banyak. Jadi, 2 x 5 = 5 x 2 = 10\n" +
                "Hasil perkalian akan tetap sama walaupun kedua bilangan yang dikalikan ditukar posisinya.\n" +
                "Sifat ini dinamakan sifat pertukaran pada perkalian.");

        tvdeskripsi=(TextView) findViewById(R.id.contoh);
        tvdeskripsi.setText("Contoh :\n" +
                "Tentukan hasil dari 5 x 4.\n" +
                "Penyelesaian :\n" +
                "Carilah bilangan pada baris ke-5 yang sejajar\n" +
                "dengan kolom ke-4. Pertemuan antara baris dan\n" +
                "kolom merupakan hasil perkaliannya. Bilangan\n" +
                "yang dilingkari merupakan hasil dari 5 x 4.\n" +
                "Jadi 5 x 4 = 20");

        tvdeskripsi=(TextView) findViewById(R.id.bilangan);
        tvdeskripsi.setText("Bilangan 12 dapat dinyatakan dalam perkalian beberapa pasangan bilangan, yaitu 1x 12, 2x6, dan 3 x 4. \n" +
                "Perhatikan contoh lainnya berikut!\n" +
                "1. 18 = 1 x 18; 18 = 2 x 9; 18 = 6 x 3\n" +
                "2. 20 = 1 x 20; 20 = 2 x 10; 20 = 4 x 5");
    }
    public void btnKembali(View view){
        Intent myIntent = new Intent(this, MateriKelas2Activity.class);
        startActivity(myIntent);
    }
}