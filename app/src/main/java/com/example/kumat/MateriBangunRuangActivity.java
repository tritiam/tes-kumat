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

public class MateriBangunRuangActivity extends AppCompatActivity {
    VideoView mVideoView2;
    TextView nDeskripsi;
    TextView oDeskripsi;
    TextView pDeskripsi;
    TextView qDeskripsi;
    TextView rDeskripsi;
    TextView sDeskripsi;
    TextView tDeskripsi;
    TextView uDeskripsi;
    MediaController mediaController;
    Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_bangun_ruang);

        nDeskripsi=(TextView) findViewById(R.id.textView4);
        nDeskripsi.setText("a.Semua sisi kubus berbentuk persegi panjang\n"+ "b.Memiliki 8 buah titik sudut.\n"+"c.Memiliki 12 rusuk sama panjang\n"+
                "d.Memiliki 12 buah diagonal bidang(diagonal sisi)sama panjang\n"+"e.Memiliki 4 buah diagonal yang sama panjang\n"+"f.Memiliki 6 buah bidang sisi\n"+"g.Memiliki 6 buah bidang diagonal berbentuk persegi panjang.");

        oDeskripsi=(TextView) findViewById(R.id.textView5);
        oDeskripsi.setText("a.Memiliki sisi dengan bentuk persegi panjang.\n"+"b.Memiliki rusuk-rusuk sejajar dengan ukuran yang sama panjang.\n"+"c.Memiliki diagonal bidang yang berhadapan dan sama panjang.\n"+
                "d.Memiliki diagonal ruang yang sama panjang.");

        pDeskripsi= (TextView) findViewById(R.id.textView6);
        pDeskripsi.setText("a.Memiliki atap dan alas yang kongruen sebanyak 3 buah.\n"+"b.Setiap sisi sampingnya seperti jajar genjang dan persegi panjang.\n"+"c.Umumnya memiliki rusuk yang tegak(beberapa ada yang tidak tegak)\n"+
                "d.Setiap diagonal bidang pada sisi yang sama, memiliki ukuran yang sama.");

        qDeskripsi=(TextView) findViewById(R.id.textView7);
        qDeskripsi.setText("a.Memiliki alas berbentuk segiempat.\n"+"b. Memiliki bidang sisi yang tegak dan berbentuk segitiga,dan bertumpu pada satu titik karena berpotongan.");

        rDeskripsi=(TextView) findViewById(R.id.textView8);
        rDeskripsi.setText("a.Memiliki alas berbentuk segitiga.Biasanya limas memiliki bidang sisi yang tegak dan berbentuk segitiga,dan bertumpu pada satu titik karena berpotongan.");

        sDeskripsi=(TextView)  findViewById(R.id.textView9);
        sDeskripsi.setText("a.Memiliki 12 buah rusuk\n"+"b.Memiliki titik sudut satu sebagai pertemuan dari titik sudutnya\n"+"c.Memiliki 2 buah bidang sisi(bidang sisi dari lingkaran terdiri dari satu dan sebagai alas serta bidang selimut  satu.");

        tDeskripsi=(TextView) findViewById(R.id.textView10);
        tDeskripsi.setText("a.Memiliki alas dan tutup berukuran sama\n"+"b.Memiliki 2 rusuk\n"+"c.Memiliki 3 bidang(2 lingkaran dan 1 persegi panjang) tidak memiliki titik sudut.");

        uDeskripsi=(TextView) findViewById(R.id.textView11);
        uDeskripsi.setText("a.Tidak memiliki titik sudut dan rusuk.\n"+"b.Mempunyai jarak yang sama ke titik pusat pada titik bidang lengkungnya.");

        //Inisialisasi VideoView, MediaController dan Button
        mVideoView2 = findViewById(R.id.mVideoView);
        play = findViewById(R.id.play2);
        mediaController = new MediaController(this);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Variable Uri untuk menentukan lokasi Resource Video yang akan ditampilkan
                Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.penyajian_data);

                mVideoView2.setVideoURI(uri);

                //Memasang MediaController untuk menampilkan tombol play, pause, dsb
                mVideoView2.setMediaController(mediaController);
                mediaController.setAnchorView(mVideoView2);

                //Menjalankan Video
                mVideoView2.start();

                ImageView lefticon = findViewById(R.id.lefticon);
                TextView title = findViewById(R.id.toolbartitle);

                lefticon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MateriBangunRuangActivity.this, "You clicked in left icon", Toast.LENGTH_SHORT).show();
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