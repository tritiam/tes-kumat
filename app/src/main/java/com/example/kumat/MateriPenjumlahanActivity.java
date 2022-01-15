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

public class MateriPenjumlahanActivity extends AppCompatActivity {
    VideoView mVideoView;
    MediaController mediaController;
    Button play;
    TextView tvDescripsi;
    TextView ttDescripsi;
    TextView tiDescripsi;
    TextView tuDescripsi;
    TextView taDescripsi;
    TextView tcDescripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_penjumlahan);

        ttDescripsi = (TextView) findViewById(R.id.textView3);
        tvDescripsi = (TextView) findViewById(R.id.textView5);
        tiDescripsi = (TextView) findViewById(R.id.textView7);
        tuDescripsi = (TextView) findViewById(R.id.textView9);
        taDescripsi = (TextView) findViewById(R.id.textView10);
        tcDescripsi = (TextView) findViewById(R.id.textView12);

        ttDescripsi.setText("Penjumlahan adalah proses menjumlahkan total dua bilangan a dan b " +
                "atau lebih menggunakan simbol (+).");
        tvDescripsi.setText("Andi memiliki bola berwarna merah lalu Ibu membelikan Andi 1 buah bola berwarna biru, Berapakah jumlah bola yang " +
                "dimiliki Andi?" +
                "\n\n " +
                "Jumlah bola Andi dapat di hitung dengan cara: ");
        tiDescripsi.setText("Dani memiliki 13 buah balon berwarna merah lalu Nenek membawakan ia 9 buah balon berwarna biru berapakah " +
                "jumlah keseluruhan balon Dani?");
        tuDescripsi.setText("Selesaikan penjumlahan 2 + 3 dengan menggunakan garis bilangan?" +
                "\n\n Penyelesaian :");
        taDescripsi.setText("Garis bilangan penjumlahan." +
                "\n\n Langkah - langkah" +
                "\n\n" +
                "1. Buat garis bilangan" +
                "\n" +
                "2. Buat garis I : Tarik garis dari angka nol sepanjang 2 satuan (2)" +
                "\n" +
                "3. Buat garis II : Tarik gatis dari akhir garis I sepanjang 3 satuan (3)" +
                "\n" +
                "4. Buat garis III : Tarik garis dari angka nol hingga akhir garis II" +
                "\n" +
                "5. Hasil penjumlahan ditunjukkan oleh garis III, 2 + 3 = 5.");
        tcDescripsi.setText("Berapakah hasil penjumlahan bilangan 125 + 117?" +
                "\n\n" +
                "Berikut adalah cara penyelesaian dengan metode bersusun.");

        //Inisialisasi VideoView, MediaController dan Button
        mVideoView = findViewById(R.id.mVideoView);
        play = findViewById(R.id.play1);
        mediaController = new MediaController(this);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Variable Uri untuk menentukan lokasi Resource Video yang akan ditampilkan
                Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/kumat-93eda.appspot.com/o/raw%2Fnovi1.mp4?alt=media&token=77cd99f9-8116-4229-99fe-7427d1a69598");

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
                        Toast.makeText(MateriPenjumlahanActivity.this, "You clicked in left icon", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
    public void btnKembali(View view){
        Intent myIntent = new Intent(this, MateriKelas1Activity.class);
        startActivity(myIntent);
    }
}