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

public class MateriOperasiHitungActivity extends AppCompatActivity {
    VideoView mVideoView;
    TextView tvDeskripsi;
    TextView ttDeskripsi;
    MediaController mediaController;
    Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_operasi_hitung);

        tvDeskripsi = (TextView) findViewById(R.id.textView1);
        tvDeskripsi.setText("Operasi hitung campuran adalah penghitungan di mana terdapat lebih dari satu tanda penghitungan yang berbeda dalam satu soal.\n" + "Misalnya ada tanda tambah dan tanda kurang,atau bahkan ada penghitunganyang menggunakan empat jenis tanda penghitungan.\n\n" + "Dalam suatu operasi hitung campuran, urutan pengerjaannya adalah sebagai berikut:\n\n" +
                "Tanda kurung().Tanda kurung memiliki arti kerjakanlah terlebih dahulu,tanpa memperhitungkan operasi apa yang terdapat dalam tanda kurung tersebut\n"+ "operasi perkalian(x) dan pembagian(:).kedua operasi hitung ini sama kuat. jika mereka terletak berselang-seling, maka kerjakan keduanya sekaligus.tetapi jika mereka terletak berurutan, maka kerjakan mulai dari yang paling kiri terlebih dahulu.\n"+ "Operasi penjumlahan(+) dan pengurangan(-) sama kuat.Aturan pengerjaannya sama dengan perkalian.");

        ttDeskripsi=(TextView) findViewById(R.id.textView2);
        ttDeskripsi.setText("Contoh soal 1\n" +
                "Tentukanlah hasil dari operasi hitung : 45 + 56 x 48 – 216 : 9\n" +
                "\n" +
                "Jawab :\n" +
                "Pada soal diatas dapat kalian lihat bahwa tidak terdapat tanda kurung dalam operasi hitungnya. Maka urutan selanjutnya yang dikerjakan adalah perkalian dan pembagian.\n" +
                "Perkalian dan pembagian pada soal diatas terletak berselang seling. Berarti kita harus kerjakan kedunya sekaligus. Agar lebih mudah, keduanya akan saya kurung.\n" +
                "= 45 + 56 x 48 – 216 : 9\n" +
                "= 45 + (56 x 48) – (216 : 9)\n" +
                "=45 + 2688 – 24\n" +
                "Setelah itu, yang bersisa adalah operasi penjumlahan dan pengurangan. Karena letaknya berurutan, maka kita kerjakan mulai dari kiri.\n" +
                "= 45 +2688 – 24\n" +
                "= (45 + 2688) – 24\n" +
                "= 2733 – 24\n" +
                "= 2709\n" +
                "Hasil pegerjaan operasi hitung diatas adalah 2709.\n" +
                "\n"+
                "Contoh Soal 2\n" +
                "Tentukanlah hasil operasi hitung dari 168 : ((17 – 24) x (-19 + 15))!\n" +
                "\n"+
                "Jawab:\n" +
                "Pada soal operasi hitung diatas, terdapat dua buah tanda kurung. Maka keduanya harus diselesaikan secara bersamaan.\n" +
                "= 168 : ((17 – 24) x (-19 + 15))!\n" +
                "= 168 : ((-7) x (-4))\n" +
                "Setelah kita selesaikan, ternyata masih ada tanda kurung yaitu operasi perkalian -7 dengan -4. Maka operasi perkalian dalam tanda kurung itu yang harus kita selesaikan terlebih dahulu.\n" +
                "Ingat perkalian dua bilangan yang tandanya sama, hasilnya adalah positif.\n" +
                "= 168 : ((-7) x (-4))\n" +
                "= 168 : 28\n" +
                "= 6\n" +
                "Hasil pengerjaan operasi hitung diatas adalah 6.");

        //Inisialisasi VideoView, MediaController dan Button
        mVideoView = findViewById(R.id.mVideoView);
        play = findViewById(R.id.play1);
        mediaController = new MediaController(this);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Variable Uri untuk menentukan lokasi Resource Video yang akan ditampilkan
                Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/kumat-93eda.appspot.com/o/raw%2Foperasi_hitung.m4v?alt=media&token=310300b9-ab93-442b-9fb5-fe3138dab646");

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
                        Toast.makeText(MateriOperasiHitungActivity.this, "You clicked in left icon", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
    public void btnKembali(View view){
        Intent myIntent = new Intent(this, MateriKelas5Activity.class);
        startActivity(myIntent);
    }
}