package com.example.sounds;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements SoundPool.OnLoadCompleteListener {

    private SoundPool mSoundPool;
    private int mClapSound, mVoiceSound;
    private int streamId1, streamId2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        mSoundPool.setOnLoadCompleteListener(this);
        mVoiceSound = mSoundPool.load(this, R.raw.kameramotor, 1);
        mClapSound = mSoundPool.load(this, R.raw.clappersound, 1);

    }

    public void clapperInit(View view) {
        streamId1 = mSoundPool.play(mVoiceSound,1,1,1,0,2);
        streamId2 = mSoundPool.play(mClapSound,1,1,0,1,1);
    }


    public void clickStopVoice(View view) {
        mSoundPool.stop(streamId1);
        mSoundPool.stop(streamId2);
    }

    @Override
    public void onLoadComplete(SoundPool soundPool, int i, int i1) {

    }
}