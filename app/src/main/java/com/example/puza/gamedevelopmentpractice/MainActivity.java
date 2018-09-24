package com.example.puza.gamedevelopmentpractice;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //play image button
    private ImageButton buttonPlay;

    //high score button
    private ImageButton buttonScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting the orientation to landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //getting the button
        buttonPlay = (ImageButton) findViewById(R.id.buttonPlay);

        //adding a click listener
        buttonPlay.setOnClickListener(this);

        //initializing the highScore button
        buttonScore = (ImageButton)findViewById(R.id.buttonScore);

        //seeting the on click listener to high score button
        buttonScore.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == buttonPlay){
            //starting game activity
            startActivity(new Intent(this, GameActivity.class));
        }
        if (v == buttonScore) {
            //the transition from MainActivity to HighScoreActivity
            startActivity(new Intent(MainActivity.this, HighScore.class));
        }
    }
}
