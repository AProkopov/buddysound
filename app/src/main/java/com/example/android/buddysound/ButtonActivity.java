package com.example.android.buddysound;


import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import java.util.Random;


public class ButtonActivity extends AppCompatActivity {

    //переменные likeSound и dislikeSound используются для определения
    //файла, который должен быть проигран
    //необходимо в связи с проигрыванием файлов по порядку и произвольно
    public int likeSound = 0;
    public int dislikeSound = 0;
    MediaPlayer mp;
    Random random = new Random();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        ((RadioButton)findViewById(R.id.orderRadio)).setChecked(true);
    }

    public void onDislikeClick (View view) {


    }

    public void onLikeClick (View view) {
        //mp.stop();

        if (((RadioButton)findViewById(R.id.orderRadio)).isChecked()) {
            if(likeSound >= 4) {
                likeSound = 1;
            }
            else likeSound++;
            play(likeSound);
        }
        else {
            likeSound = random.nextInt(4);
            play(likeSound);
        }
    }

    public void play(int x) {

        if (mp != null) {
            mp.stop();
        }

        switch (x) {
            case 1:
                mp = MediaPlayer.create(this, R.raw.laugh_w);
                mp.start();
                break;
            case 2:
                mp = MediaPlayer.create(this, R.raw.benny);
                mp.start();
                break;
            case 3:
                mp = MediaPlayer.create(this, R.raw.radio_maximum);
                mp.start();
                break;
            case 4:
                mp = MediaPlayer.create(this, R.raw.applo);
                mp.start();
        }
    }


}
