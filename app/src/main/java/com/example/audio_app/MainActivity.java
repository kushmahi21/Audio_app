package com.example.audio_app;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    TextView currentstate;

    private static int songCounter = 0;
    private List<Integer> songList;
    private ListView songView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        songList = new ArrayList<>();
        songView = findViewById(R.id.song_list);
        currentstate = findViewById(R.id.current_state);

        songList.add(R.raw.ab);
        songList.add(R.raw.cd);
        songList.add(R.raw.de);
        songList.add(R.raw.fg);
        songList.add(R.raw.hi);
        songList.add(R.raw.jk);
        songList.add(R.raw.lm);

    }

    public void Pause(View view) {
        if(mediaPlayer != null) {
            mediaPlayer.pause();
            currentstate.setText("Media Paused");
        }
    }

    public void Play(View view) {
        mediaPlayer = MediaPlayer.create(this,songList.get(songCounter));
        mediaPlayer.start();
        currentstate.setText("Media Playing");
    }

    public void next(View view) {
       if(mediaPlayer != null) {
           mediaPlayer.stop();

        }
        if(songCounter+1 < 7){
            songCounter += 1;
            mediaPlayer = MediaPlayer.create(this,songList.get(songCounter));
            mediaPlayer.start();
            currentstate.setText("Playing Next Song");
        }
        else {
            songCounter = 0;
            mediaPlayer = MediaPlayer.create(this,songList.get(songCounter));
           mediaPlayer.start();
            currentstate.setText("Playing First Song");
        }

    }

    public void Stop(View view) {
        if(mediaPlayer != null) {
            mediaPlayer.stop();
            currentstate.setText("Media Stoped");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();
        currentstate.setText("Media Stopped");
    }
}