package com.scoop.scoopiio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by Andreas on 10.09.2015.
 */
public class Splash extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash); //link to the xml file named splash

        final ImageView iv = (ImageView) findViewById(R.id.imageView); //reference to the desert image I want to display in few seconds
        final Animation an = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotating); //The picture gonna rotate + the anim directory and the xml file, source: Mariusz Nowostawski lecture 1.september.
        final Animation an1 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out);


        iv.startAnimation(an);
        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();//When the animation ends, the splash screen will ends and start the Main Activity
                Intent i = new Intent(getBaseContext(),MainActivity.class);// call over to the MainActivity class
                startActivity(i); //Starting the activity includes i parameter
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

} //End bracket
