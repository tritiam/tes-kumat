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

public class MateriPenyajianDataActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_penyajian_data);

        deskripsi1 = (TextView) findViewById(R.id.mean1);
        deskripsi2 = (TextView) findViewById(R.id.mean2);
        deskripsi3 = (TextView) findViewById(R.id.mean4);
        deskripsi4 = (TextView) findViewById(R.id.batang);
        deskripsi5 = (TextView) findViewById(R.id.garis);
        deskripsi6 = (TextView) findViewById(R.id.lingkaran);
        deskripsi7 = (TextView) findViewById(R.id.lingkaran2);

        deskripsi1.setText("Sebelum menyajikan sebuah data, harus dilakukan proses pengumpulan data terlebih dahulu. Ada beberapa cara yang biasa dilakukan untuk mendapatkan data, diantaranya melalui:" +
                "\n" +
                "- Penelitian" +
                "\n" +
                "- Wawancara" +
                "\n" +
                "- Polling/angket" +
                "\n" +
                "- Perhitungan Langsung.");

        deskripsi2.setText("Data dapat digambarkan dengan menggunakan tabel. Berikut contoh tabel data nilai matematika siswa SD kelas VI Tunas Mekar:");
        deskripsi3.setText("Dari data table diatas diketahui bahwa:" +
                "\n" +
                "Ada 5 siswa yang memperoleh nilai 65" +
                "\n" +
                "Ada 9 siswa yang memperoleh nilai 70" +
                "\n" +
                "Ada 14 siswa yang memperoleh nilai 75" +
                "\n" +
                "Ada 10 siswa yang memperoleh nilai 80" +
                "\n" +
                "Ada 5 siswa yang memperoleh nilai 85" +
                "\n" +
                "Ada 7 siswa yang memperoleh nilai 90");
        deskripsi4.setText("Kita dapat mengubah data pada tabel diatas ke dalam bentuk diagram batang seperti berikut:");
        deskripsi5.setText("Hampir sama menyerupai diagram batang hanya saja bentuknya diubah menjadi garis seperti berikut:");
        deskripsi6.setText("Untuk membuat diagram lingkaran, kita harus mencari persentase besar sudutnya telebih dahulu.");
        deskripsi7.setText("Nilai 65 = 5/50 x 3600 = 360" +
                "\n" +
                "Nilai 70 = 9/50 x 3600 = 64.80" +
                "\n" +
                "Nilai 75 = 14/50 x 3600 = 100.80" +
                "\n" +
                "Nilai 80 = 10/50 x 3600 = 720" +
                "\n" +
                "Nilai 85 = 5/50 x 3600 = 360" +
                "\n" +
                "Nilai 90 = 7/50 x 3600 = 50.40" +
                "\n\n" +
                "Maka gambar diagramnya akan menjadi seperti ini:");

        //Inisialisasi VideoView, MediaController dan Button
        mVideoView = findViewById(R.id.mVideoView);
        play = findViewById(R.id.play1);
        mediaController = new MediaController(this);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Variable Uri untuk menentukan lokasi Resource Video yang akan ditampilkan
                Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.penyajian_data);

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
                        Toast.makeText(MateriPenyajianDataActivity.this, "You clicked in left icon", Toast.LENGTH_SHORT).show();
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