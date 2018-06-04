package com.example.yasasweerasinghe.mobilecw01;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //NewGame window method
    public void gameLevel(View view){
        startActivity(new Intent(MainActivity.this, GameLevelsWindow.class));
    }

    //PopUp window method
    public void popUp(View view){
        startActivity(new Intent(MainActivity.this, PopWindow.class));
    }

    //exit button method
    public void exitButton(View view){
        AlertDialog.Builder exitAlert = new AlertDialog.Builder(this);
        //  dialog title
        exitAlert.setTitle("Confirm Exit");
        //dialog icon
        exitAlert.setIcon(R.drawable.qmark);
        // dialog message
        exitAlert.setMessage("Do you want to exit?");
        exitAlert.setCancelable(false);

        // exit from the app( Main Activity)
        exitAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
            }
        });
            // cancel the dialog (cancel the action)
        exitAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = exitAlert.create();
        alertDialog.show();
    }

    @Override
    public void onBackPressed() { // prevent the score window open
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }
}




