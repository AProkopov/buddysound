package com.example.android.buddysound;

import android.content.res.AssetManager;
import android.content.res.AssetFileDescriptor;
import android.media.SoundPool;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

public class ButtonActivity extends AppCompatActivity {

    private SoundPool mSoundPool;
    private AssetManager mAssetManager;
    private int trombonSound;
    private int nuzhdikiSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);

        mAssetManager = getAssets();
        trombonSound = loadSound("trombon.ogg");
        nuzhdikiSound = loadSound("nuzhdiki.ogg");
    }

    public void onDislikeClick (View view) {
        playSound(trombonSound);
    }

    public void onLikeClick (View view) {
        playSound(nuzhdikiSound);
    }

    //присваиваем звукам ID (int)
    private int loadSound(String fileName) {
        AssetFileDescriptor afd = null;
        try {
            afd = mAssetManager.openFd(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Couldn't load file '" + fileName + "'", Toast.LENGTH_SHORT).show();
            return -1;
        }
        return mSoundPool.load(afd, 1);
    }

    protected void playSound(int sound) {
        if (sound > 0)
            mSoundPool.play(sound, 1, 1, 1, 0, 1);
    }
}
