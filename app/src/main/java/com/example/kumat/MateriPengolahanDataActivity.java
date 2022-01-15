package com.example.kumat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class MateriPengolahanDataActivity extends AppCompatActivity {
    VideoView mVideoView;
    MediaController mediaController;
    Button play;
    TextView deskripsi1;
    TextView deskripsi2;
    TextView deskripsi3;
    TextView deskripsi4;
    TextView deskripsi5;
    TextView deskripsi6;
    TextView deskripsi7;
    TextView deskripsi8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_pengolahan_data);

        deskripsi1 = (TextView) findViewById(R.id.mean1);
        deskripsi2 = (TextView) findViewById(R.id.mean2);
        deskripsi3 = (TextView) findViewById(R.id.mean3);
        deskripsi4 = (TextView) findViewById(R.id.mean4);
        deskripsi5 = (TextView) findViewById(R.id.modus);
        deskripsi6 = (TextView) findViewById(R.id.median1);
        deskripsi7 = (TextView) findViewById(R.id.median2);
        deskripsi8 = (TextView) findViewById(R.id.median3);

        deskripsi1.setText("Mean yaitu nilai rata-rata dari keseluruhan data yang di dapat.");
        deskripsi2.setText("Contoh tabel data nilai matematika siswa SD Tunas Mekar kelas VI:");
        deskripsi3.setText("Untuk mencari meannya dengan cara menjumlahkan nilai yang ada kemudian dibagi dengan jumlah siswa yang ada, seperti berikut:");
        deskripsi4.setText("Nilai rata-rata siswa kelas VI untuk pelajaran matematika di SD Tunas Mekar, yaitu 9.3.");
        deskripsi5.setText("Modus merupakan nilai yang paling sering muncul di dalam data tersebut. Bila dilihat dari contoh data nilai matematika siswa kelas VI SD Tunas Mekar, maka nilai yang paling sering muncul yaitu 75 karena terdapat 14 siswa yang mendapat nilai 75.");
        deskripsi6.setText("Median yaitu nilai tengah. Diperoleh dengan cara mengurutkan nilai-nilai yang ada dari yang terkecil hingga terbesar. Jika jumlah datanya ganjil maka:");
        deskripsi7.setText("Jika jumlah datanya genap ambil dua nilai yang ada ditengah kemudian dibagi dengan 2 seperti berikut:");
        deskripsi8.setText("Contoh nilai ulangan harian matematika kelas IV SD Tunas Harapan berturut-turut adalah: 5, 6, 7, 8, 9, 7, 8, 7, 10, 5." +
                "\n\n" +
                "Untuk mencari mediannya urutkan nilai-nilai tersebut dari yang terkecil : 5, 5, 6, 7, 7, 7, 8, 8, 9, 10 yang mana jumlah datanya ada 10." +
                "\n\n" +
                "Kemudian ambil nilai yang ada ditengah-tengah. Karena jumlah datanya genap (10) maka ambil dua nilai yang ada di tengah yaitu 7 dan 7." +
                "\n\n" +
                "7+7 : 2 = 14 : 2 = 7" +
                "\n\n" +
                "\n" +
                "Maka median dari data tersebut, yaitu 7.");

        //Inisialisasi VideoView, MediaController dan Button
        mVideoView = findViewById(R.id.mVideoView);
        play = findViewById(R.id.play1);
        mediaController = new MediaController(this);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Variable Uri untuk menentukan lokasi Resource Video yang akan ditampilkan
                // Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.penyajian_data);
                Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/kumat-93eda.appspot.com/o/raw%2Fpengolahan_data.m4v?alt=media&token=9bbe78a1-b49c-40c6-b464-bb644189f512");

                mVideoView.setVideoURI(uri);

                //Memasang MediaController untuk menampilkan tombol play, pause, dsb
                mVideoView.setMediaController(mediaController);
                mediaController.setAnchorView(mVideoView);

                //Menjalankan Video
                mVideoView.start();

                ImageView lefticon = findViewById(R.id.lefticon);
                TextView title = findViewById(R.id.toolbartitle);

                lefticon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MateriPengolahanDataActivity.this, "You clicked in left icon", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
    public void btnKembali(View view){
        Intent myIntent = new Intent(this, MateriKelas6Activity.class);
        startActivity(myIntent);
    }
}