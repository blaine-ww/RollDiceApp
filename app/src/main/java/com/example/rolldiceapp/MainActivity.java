package com.example.rolldiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView diceImg1 = findViewById(R.id.myDice1);
        final ImageView diceImg2 = findViewById(R.id.myDice2);

        final int [] diceImages = {R.drawable.dice1,
                            R.drawable.dice2,
                            R.drawable.dice3,
                            R.drawable.dice4,
                            R.drawable.dice5,
                            R.drawable.dice6};

        //int myBox = 10;

        //float myFloatBox = 4.2f;

        //double myDoubleBox = 3.14591;

        Button btnRoll = findViewById(R.id.btnRollTheDice);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_roll_sound);

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Log.i("RollDiceApp","btnRoll is tapped!");

                Random rndObj = new Random();

                int myRandomNum1 = rndObj.nextInt(6);    //0 ...5 indices for diceImages []
                int myRandomNum2 = rndObj.nextInt(6);

                Log.i("RollDiceApp","The generated random num1 is " + myRandomNum1);
                Log.i("RollDiceApp","The generated random num1 is " + myRandomNum2);

                //diceImg1.setImageResource(R.drawable.dice2);
                diceImg1.setImageResource(diceImages[myRandomNum1]);

                diceImg2.setImageResource(diceImages[myRandomNum2]);

                YoYo.with(Techniques.Shake)
                        .duration(400) //ms
                        .repeat(0)
                        .playOn(diceImg1);

                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(diceImg2);

                mp.start();
            }
        });





    }
}