package com.example.yasasweerasinghe.mobilecw01;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


 // Created by Yasas Weerasingh on 10-Mar-18.



public class Score extends GameWindow {

    //variable initialization
    private static String score;
    private static String level;
    //text view declaring
    private TextView tScore;
    private TextView tLevel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.score_popup);

        tScore =(TextView) findViewById(R.id.tScore);
        tLevel = (TextView) findViewById(R.id.tLevel);

        // get the valus from the GameWindow Score method
        Bundle bundle = getIntent().getExtras();
         score = bundle.getString("score");
         level = bundle.getString("difficulity");

        tScore.setText((String) bundle.get("score")); // set values to the textView
        tLevel.setText((String) bundle.get("difficulity")); // set values to the textView




    }

    public void bHome(View view){
        Intent intent=new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }

}
