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

public class MateriKoordinatKartesiusActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_materi_koordinat_kartesius);

        deskripsi1 = (TextView) findViewById(R.id.soal);
        deskripsi2 = (TextView) findViewById(R.id.kor2);
        deskripsi3 = (TextView) findViewById(R.id.titik1);
        deskripsi4 = (TextView) findViewById(R.id.titik2);
        deskripsi5 = (TextView) findViewById(R.id.titik3);
        deskripsi6 = (TextView) findViewById(R.id.titik4);
        deskripsi7 = (TextView) findViewById(R.id.cara1);
        deskripsi8 = (TextView) findViewById(R.id.cara2);

        deskripsi1.setText("Sistem koordinat kartesius digunakan untuk menentukan posisi atau letak dari sebuah titik pada suatu bidang datar. Posisi titik tersebut ditentukan oleh dua buah garis yang ditarik secara vertikal (tegak lurus) dan horizontal (mendatar) yang berpusat pada sebuah titik pusat koordinat (0) yang merupakan perpotongan antara keduanya." +
                "\n\n" +
                "Garis horizontal pada bidang kartesius disebut sebagai sumbu x (absis), sedangkan garis vertikal dinamakan sumbu y (ordinat). Sumbu x yang berada di kanan titik 0 bernilai positif (x positif), sedangkan sumbu x yang berada di kiri titik 0 bernilai negatif (x negatif)." +
                "\n\n" +
                "Sementara itu, sumbu y yang berada di atas titik 0 bernilai posisit (y positif) dan sumbu y yang berada di bawah titik 0 bernilai negatif (y negatif). Untuk lebih jelasnya, perhatikan gambar berikut ini:");
        deskripsi2.setText("Penjelasan dari gambar di atas adalah sebagai berikut:" +
                "\n\n" +
                "- Sumbu x merupakan sumbu mendatar yang disebut absis\n" +
                "- Sumbu y merupakan sumbu tegak lurus yang disebut ordinat\n" +
                "- Titik 0 merupakan titik pusat koordinat atau titik awal\n" +
                "- Kuadran I merupakan tempat x negatif dan y positif (-x, y)\n" +
                "- Kuadran II merupakan tempat x posisif dan y posisif (x, y)\n" +
                "- Kuadran III merupakan tempat x negatif dan y negatif (-x, -y)\n" +
                "- Kuadran IV merupakan tempat x positif dan y negatif (x, -y)");
        deskripsi3.setText("Untuk memahami bagaimana cara membaca suatu titik pada bidang koordinat kartesius, silahkan perhatikan gambar berikut ini:");
        deskripsi4.setText("Gambar di atas merupakan sebuah bidang koordinat yang dibuat oleh dua buah garis, yakni garis sumbu x (mendatar) dan garis sumbu y (tegak lurus). Kedua garis tersebut berpotongan pada satu titik yang disebut sebagai pusat koordinat (titik 0).\n\n" +
                "Bidang koordinat di atas disebut sebagai bidang koordinat kartesius yang digunakan untuk membaca posisi atau letak dari suatu titik yang dinyatakan dalam pasangan angka pada sumbu x dan sumbu y.");
        deskripsi5.setText("Perhatikan tiitk A,B,C, dan D yang ada pada bidang tersebut. Untuk membaca letak dari titik-titik tersebut, langkah-langkahnya adalah sebagai berikut:\n" +
                "\n" +
                "- Mulailah membaca dari pusat koordinat (titik 0)\n" +
                "- Kemudian perhatikan angka yang ada pada sumbu x\n" +
                "- Setelah itu barulah melihat angka yang ada pada sumbu y\n" +
                "- Menuliskan pasangan angka dengan (x,y)");
        deskripsi6.setText("Sebagai contoh, dari gambar di atas kita dapat membaca pasangan angka untuk titik A, B, C, dan D sebagai berikut:\n" +
                "\n" +
                "Letak koordinat titik A = A (-3,5)\n" +
                "Letak koordinat titik B = B (3,1)\n" +
                "Letak koordinat titik C = C (4,-4)\n" +
                "Letak koordinat titik D = D (-4,-2)");
        deskripsi7.setText("Sebagai contoh, tentukan posisi atau letak titik koordinat pada bidang kartesius titik-titik koordinat di bawah ini dan sebutkan pola bangun apakah yang terbentuk!\n" +
                "Koordinat titik P (-4,2)\n" +
                "Koordinat titik Q (5,2)\n" +
                "Koordinat titik R (3,-3)\n" +
                "Koordinat titik S (-6,-3)\n" +
                "\n" +
                "Penyelesaian:");
        deskripsi8.setText("Dengan melihat polanya, maka bangun yang terbentuk oleh titik-titik koordinat P, Q, R, dan S adalah bangun datar jajar genjang.");

        //Inisialisasi VideoView, MediaController dan Button
        mVideoView = findViewById(R.id.mVideoView);
        play = findViewById(R.id.play1);
        mediaController = new MediaController(this);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Variable Uri untuk menentukan lokasi Resource Video yang akan ditampilkan
                Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.penyajian_data);

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
                        Toast.makeText(MateriKoordinatKartesiusActivity.this, "You clicked in left icon", Toast.LENGTH_SHORT).show();
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