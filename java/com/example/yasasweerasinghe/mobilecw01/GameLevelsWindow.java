package com.example.yasasweerasinghe.mobilecw01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Yasas Weerasingh on 26-Feb-18.
 */


public class GameLevelsWindow extends MainActivity {


    private GameWindow obj ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_levels_window);

        obj = new GameWindow(); // create a object of the GameWindow activity
    }


    //Novice gameLevel method
    public void gameLevelNovice(View view) {
        obj.setGameLevel(1); // set the difficulty level

        startActivity(new Intent(GameLevelsWindow.this, GameWindow.class));
    }

    //Easy gameLevel method
    public void gameLevelEasy(View view){
        obj.setGameLevel(2);    //set the difficulty level
        startActivity(new Intent(GameLevelsWindow.this, GameWindow.class));
    }

    //Medium gameLevel method
    public void gameLevelMediam(View view){
        obj.setGameLevel(3);    //set the difficulty level
        startActivity(new Intent(GameLevelsWindow.this, GameWindow.class));
    }

    //Giru gameLevel method
    public void gameLevelGuru(View view){
        obj.setGameLevel(4);    //set the difficulty level
        startActivity(new Intent(GameLevelsWindow.this, GameWindow.class));
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
