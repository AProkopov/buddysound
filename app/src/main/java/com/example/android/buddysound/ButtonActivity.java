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

        Log.w("Before onDislikeClick", "dislikeSound = " + dislikeSound);

        if (((RadioButton)findViewById(R.id.orderRadio)).isChecked()) {
            if(dislikeSound >= 8) {
                dislikeSound = 1;
            }
            else dislikeSound++;

            Log.w("Before play()", "dislikeSound = " + dislikeSound);
            playDisLike(dislikeSound);
        }
        else {
            dislikeSound = random.nextInt(7) + 1;
            Log.w("Before play()", "dislikeSound = " + dislikeSound);
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

        try {

            if (mpDislike != null) {
                mpDislike.stop();
            }

            if (mpLike != null) {
                mpLike.stop();
                mpLike.reset();
            }

            switch (x) {
                case 1:
                    mpLike = MediaPlayer.create(this, R.raw.radiomax);
                    break;
                case 2:
                    mpLike = MediaPlayer.create(this, R.raw.benny);
                    break;
                case 3:
                    mpLike = MediaPlayer.create(this, R.raw.burunduk);
                    break;
                case 4:
                    mpLike = MediaPlayer.create(this, R.raw.chgk);
                    break;
                case 5:
                    mpLike = MediaPlayer.create(this, R.raw.eralash);
                    break;
                case 6:
                    mpLike = MediaPlayer.create(this, R.raw.laugh);
                    break;
                case 7:
                    mpLike = MediaPlayer.create(this, R.raw.applause);
                    break;
                case 8:
                    mpLike = MediaPlayer.create(this, R.raw.shurik);
                    break;
            }

            mpLike.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //метод проигрывает звуковой файл в зависимости от порядкового номера файла,
    //опеределенного при отработке метода onDislikeClick
    public void playDisLike(int x) {

        try {

            if (mpLike != null) {
                mpLike.stop();
            }

            if (mpDislike != null) {
                mpDislike.stop();
                mpDislike.reset();
            }

            switch (x) {
                case 1:
                    mpDislike = MediaPlayer.create(this, R.raw.trombon);
                    break;
                case 2:
                    mpDislike = MediaPlayer.create(this, R.raw.pooo_1);
                    break;
                case 3:
                    mpDislike = MediaPlayer.create(this, R.raw.riot);
                    break;
                case 4:
                    mpDislike = MediaPlayer.create(this, R.raw.pooo_3);
                    break;
                case 5:
                    mpDislike = MediaPlayer.create(this, R.raw.proval);
                    break;
                case 6:
                    mpDislike = MediaPlayer.create(this, R.raw.pooo_2);
                    break;
                case 7:
                    mpDislike = MediaPlayer.create(this, R.raw.toilet);
                    break;
                case 8:
                    mpDislike = MediaPlayer.create(this, R.raw.cartoon);
                    break;
            }

            mpDislike.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
