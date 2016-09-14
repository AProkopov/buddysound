package com.example.android.buddysound;


import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import java.util.Random;
import android.util.Log;


public class ButtonActivity extends AppCompatActivity {

    //переменные likeSound и dislikeSound используются для определения
    //файла, который должен быть проигран
    //необходимо в связи с проигрыванием файлов по порядку и произвольно
    public int likeSound = 0;
    public int dislikeSound = 0;
    MediaPlayer mpLike;
    MediaPlayer mpDislike;
    Random random = new Random();


    //отрисовка Activity
    //выполнение действий, которые необходимо выполнить сразу при отрисовке Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        ((RadioButton)findViewById(R.id.orderRadio)).setChecked(true);
    }

    //вызывается при клике на кнопке (dislikeButton)
    public void onDislikeClick (View view) {

        Log.w("Before onLikeClick", "likeSound = " + dislikeSound);

        if (((RadioButton)findViewById(R.id.orderRadio)).isChecked()) {
            if(dislikeSound >= 8) {
                dislikeSound = 1;
            }
            else dislikeSound++;

            Log.w("Before play()", "likeSound = " + dislikeSound);
            playDisLike(dislikeSound);
        }
        else {
            dislikeSound = random.nextInt(7) + 1;
            Log.w("Before play()", "likeSound = " + dislikeSound);
            playDisLike(dislikeSound);
        }

    }

    //вызывается при клике на кнопке (likeButton)
    public void onLikeClick (View view) {

        Log.w("Before onLikeClick", "likeSound = " + likeSound);

        if (((RadioButton)findViewById(R.id.orderRadio)).isChecked()) {
            if(likeSound >= 8) {
                likeSound = 1;
            }
            else likeSound++;

            Log.w("Before play()", "likeSound = " + likeSound);
            playLike(likeSound);
        }
        else {
            likeSound = random.nextInt(7) + 1;
            Log.w("Before play()", "likeSound = " + likeSound);
            playLike(likeSound);
        }
    }

    //метод проигрывает звуковой файл в зависимости от порядкового номера файла,
    //опеределенного при отработке метода onLikeClick
    public void playLike(int x) {

        if (mpLike != null) {
            mpLike.stop();
        }

        switch (x) {
            case 1:
                mpLike = MediaPlayer.create(this, R.raw.applause);
                mpLike.start();
                break;
            case 2:
                mpLike = MediaPlayer.create(this, R.raw.benny);
                mpLike.start();
                break;
            case 3:
                mpLike = MediaPlayer.create(this, R.raw.burunduk);
                mpLike.start();
                break;
            case 4:
                mpLike = MediaPlayer.create(this, R.raw.chgk);
                mpLike.start();
            case 5:
                mpLike = MediaPlayer.create(this, R.raw.eralash);
                mpLike.start();
            case 6:
                mpLike = MediaPlayer.create(this, R.raw.laugh);
                mpLike.start();
            case 7:
                mpLike = MediaPlayer.create(this, R.raw.radiomax);
                mpLike.start();
            case 8:
                mpLike = MediaPlayer.create(this, R.raw.shurik);
                mpLike.start();
        }
    }

    //метод проигрывает звуковой файл в зависимости от порядкового номера файла,
    //опеределенного при отработке метода onDislikeClick
    public void playDisLike(int x) {

        if (mpDislike != null) {
            mpDislike.stop();
        }

        switch (x) {
            case 1:
                mpDislike = MediaPlayer.create(this, R.raw.cartoon);
                mpDislike.start();
                break;
            case 2:
                mpDislike = MediaPlayer.create(this, R.raw.pooo_1);
                mpDislike.start();
                break;
            case 3:
                mpDislike = MediaPlayer.create(this, R.raw.pooo_2);
                mpDislike.start();
                break;
            case 4:
                mpDislike = MediaPlayer.create(this, R.raw.pooo_3);
                mpDislike.start();
            case 5:
                mpDislike = MediaPlayer.create(this, R.raw.proval);
                mpDislike.start();
            case 6:
                mpDislike = MediaPlayer.create(this, R.raw.riot);
                mpDislike.start();
            case 7:
                mpDislike = MediaPlayer.create(this, R.raw.toilet);
                mpDislike.start();
            case 8:
                mpDislike = MediaPlayer.create(this, R.raw.trombon);
                mpDislike.start();
        }
    }

}
