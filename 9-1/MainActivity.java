package com.example.a202035309__mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    String url = "https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview116/v4/f6/66/98/f6669873-4a72-ed63-77ee-13746938c220/mzaf_16352020300822090516.plus.aac.p.m4a";

    MediaPlayer player;
    int position; // 일지 정지된 위치 저장

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // #1 play btn
        Button btn = findViewById(R.id.button_play);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio();
            }
        });

        // #2 stop btn
        Button btn2 = findViewById(R.id.button_stop);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAudio();
            }
        });

        // #3 play btn
        Button btn3 = findViewById(R.id.button_pause);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseAudio();
            }
        });

        // #4 restart btn
        Button btn4 = findViewById(R.id.button_restart);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartAudio();
            }
        });
    }


    // audio play function
    public void playAudio(){
        showToast("음악 파일 재생 호출됨");

        killPlayer();

        player = new MediaPlayer();
        try {
            player.setDataSource(url);
            player.prepare();
            player.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // audio stop function
    public void stopAudio() {
        showToast("음악 파일 재생 중지됨");
        if (player != null) {
            try {
                player.stop();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    // audio pause function
    public void pauseAudio(){
        showToast("음악 파일 재생 일시 중지됨");
        if (player != null) {
            try {
                position = player.getCurrentPosition();
                player.pause();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void restartAudio(){
        showToast("음악 파일 재생 다시 시작됨");
        if (player != null && !player.isPlaying()) {
            try {
                player.start();
                player.seekTo(position);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    // toast function
    public void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    // 여러번 동작 시도 or 기존에 플레이어가 동작중이라면 객체 자체 리소스 해제
    public void killPlayer(){
        if (player != null){
            try {
                player.release();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}