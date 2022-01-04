package com.example.kumat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MateriPembagianActivity extends AppCompatActivity {
    TextView tvdeskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_pembagian);

        ImageView lefticon = findViewById(R.id.lefticon);
        TextView title = findViewById(R.id.toolbartitle);

        lefticon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MateriKelas2Activity.class));
            }
        });
        title.setText("Pembagian");

        tvdeskripsi=(TextView) findViewById(R.id.pengertian);
        tvdeskripsi.setText("Pembagian merupakan pengurangan berulang dari bilangan yang sama sampai habis.\n" +
                "Contoh :");

        tvdeskripsi=(TextView) findViewById(R.id.operasi);
        tvdeskripsi.setText("Operasi perkalian dan pembagian saling berhubungan. Jika bilangan hasil bagi dikalikan dengan pembagi, akan diperoleh bilangan yang dibagi. Perhatikan contoh berikut!");

        tvdeskripsi=(TextView) findViewById(R.id.hasil);
        tvdeskripsi.setText("Hasil pembagian juga dapat ditentukan dengan menggunakan tabel perkalian. Perhatikan contoh\n" +
                "berikut!\n");
    }
    public void btnKembali(View view){
        Intent myIntent = new Intent(this, MateriKelas2Activity.class);
        startActivity(myIntent);
    }
}