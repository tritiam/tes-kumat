package com.example.kumat;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class MateriFaktorActivity extends AppCompatActivity {
    VideoView mVideoView;
    MediaController mediaController;
    Button play;
    TextView penyelesaian;
    TextView textfak;
    TextView prima;
    TextView akhir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_faktor);

        penyelesaian = (TextView) findViewById(R.id.penyelesaian);
        penyelesaian.setText("1 x 4 = 4\n" +
                "2 x 4 = 4 + 4 = 8\n"+
                "3 x 4 = 4 + 4 + 4 = 12\n"+
                "4 x 4 = 4 + 4 + 4 + 4 = 16\n"+
                "Jadi, kelipatan dari 4 adalah 4, 8, 12, 16, .... dan seterusnya.");

        textfak = (TextView) findViewById(R.id.textfak);
        textfak.setText("Jadi faktor dari 24 adalah 1,2,3,4,6,8,12 dan 24\n" +
                "Jadi faktor dari 32 adalah 1,2,4,8,16 dan 32");

        prima = (TextView) findViewById(R.id.prima);
        prima.setText("Faktor dari 20 adalah 1, 2, 4, 5, 10, dan 20\n" +
                "Faktor prima dari 20 adalah 2 dan 5.");

        akhir = (TextView) findViewById(R.id.akhir);
        akhir.setText("30    = 2 x 3 x 5\n\n" +
                "42    = 2 x 3 x 7\n\n"+
                "FPB = 2 x 3\n\n"+
                "KPK = 2 x 3 x 5 x 7\n");

        //Inisialisasi VideoView, MediaController dan Button
        mVideoView = findViewById(R.id.mVideoView);
        play = findViewById(R.id.play1);
        mediaController = new MediaController(this);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Variable Uri untuk menentukan lokasi Resource Video yang akan ditampilkan
                Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/kumat-93eda.appspot.com/o/raw%2Fbangun_ruang.m4v?alt=media&token=f8d58f8c-8b65-4f21-a4c8-339b3fd01058");

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
                        Toast.makeText(MateriFaktorActivity.this, "You clicked in left icon", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
    public void btnKembali(View view){
        Intent myIntent = new Intent(this, MateriKelas4Activity.class);
        startActivity(myIntent);
    }
}