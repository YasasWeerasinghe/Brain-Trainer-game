package com.example.yasasweerasinghe.mobilecw01;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;


/**
 * Created by Yasas Weerasingh on 03-Mar-18.
 */

public class GameWindow extends GameLevelsWindow {

    // variable declaring and initialization
    private static String tAnswerInput = "";
    private static String tExpression = "";
    private static String tStatusField = "";
    private static int difficulty = 0;
    private static String[] operators = {"+","-","*","/"};
    private Random randomNumber = new Random();
    private static int result = 0;
    private int count = 0;
    private CountDownTimer timer;
    private int seconds = 0 ;
    private int hintCount = 0;

    //text views
    private TextView expression;
    private TextView padInput;
    private TextView status;
    private TextView countDown;

    // Switch
    private Switch hints;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game_window);

        // textview initialization with the xml textviewss
        expression =(TextView) findViewById(R.id.tMathExpression);
        padInput =(TextView) findViewById(R.id.tInputAnswer);
        status =(TextView) findViewById(R.id.tStatus);
        countDown =(TextView) findViewById(R.id.tCountDown);

        // switch Event
        hints = findViewById(R.id.sHints);

        buttonClick(); // call the button ckick method
        Countdown(); // call the countdown method
        expression.setText(tExpression); // set the expression to the text view
    }

    // Countdown method
    public void Countdown(){
        timer = new CountDownTimer(10000, 1) { // countdown bound 9 to 0 (10)

            public void onTick(long millisUntilFinished) {
                seconds =  (int)millisUntilFinished / 1000;
                countDown.setText(seconds+1 + " Sec");
            }

            public void onFinish() {
                if(count<10){
                    createRandomNumbers();
                    expression.setText(tExpression);
                    timer.start();
                }else{
                    timer.cancel();
                }
            }
        }.start(); //  start the timer

    }

    // button click method
    public void buttonClick(){
        findViewById(R.id.b1).setOnClickListener(ButtonClick);
        findViewById(R.id.b2).setOnClickListener(ButtonClick);
        findViewById(R.id.b3).setOnClickListener(ButtonClick);
        findViewById(R.id.b4).setOnClickListener(ButtonClick);
        findViewById(R.id.b5).setOnClickListener(ButtonClick);
        findViewById(R.id.b6).setOnClickListener(ButtonClick);
        findViewById(R.id.b7).setOnClickListener(ButtonClick);
        findViewById(R.id.b8).setOnClickListener(ButtonClick);
        findViewById(R.id.b9).setOnClickListener(ButtonClick);
        findViewById(R.id.b0).setOnClickListener(ButtonClick);
        findViewById(R.id.bDel).setOnClickListener(ButtonClick);
        findViewById(R.id.bHash).setOnClickListener(ButtonClick);
        findViewById(R.id.bMinus).setOnClickListener(ButtonClick);
    }

    // button click method switch case
    private View.OnClickListener ButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.b1:
                    tAnswerInput = tAnswerInput + "1"; // initializing values to the String
                    padInput.setText(tAnswerInput); // set values to the text view
                    break;
                case R.id.b2:
                    tAnswerInput = tAnswerInput + "2";
                    padInput.setText(tAnswerInput);
                    break;
                case R.id.b3:
                    tAnswerInput = tAnswerInput + "3";
                    padInput.setText(tAnswerInput);
                    break;
                case R.id.b4:
                    tAnswerInput = tAnswerInput + "4";
                    padInput.setText(tAnswerInput);
                    break;
                case R.id.b5:
                    tAnswerInput = tAnswerInput + "5";
                    padInput.setText(tAnswerInput);
                    break;
                case R.id.b6:
                    tAnswerInput = tAnswerInput + "6";
                    padInput.setText(tAnswerInput);
                    break;
                case R.id.b7:
                    tAnswerInput = tAnswerInput + "7";
                    padInput.setText(tAnswerInput);
                    break;
                case R.id.b8:
                    tAnswerInput = tAnswerInput + "8";
                    padInput.setText(tAnswerInput);
                    break;
                case R.id.b9:
                    tAnswerInput = tAnswerInput + "9";
                    padInput.setText(tAnswerInput);
                    break;
                case R.id.b0:
                    tAnswerInput = tAnswerInput + "0";
                    padInput.setText(tAnswerInput);
                    break;
                case R.id.bDel:

                    if(tAnswerInput.isEmpty()) {

                    } else{ // else print the value to the tAnswerInput view
                        tAnswerInput = tAnswerInput.substring(0,tAnswerInput.length()-1); // delete the last digit
                        padInput.setText(tAnswerInput); //set text to view
                    }
                    break;

                case R.id.bHash:
                        // count the game play
                    if (count<9) {

                        if (tAnswerInput.isEmpty()) {   // if the tAnswerInput is empty
                            createRandomNumbers();      // create the random expression
                            tStatusField = tStatusField.substring(tStatusField.length());   // delete the current status
                            status.setText(tStatusField);   // set status
                            timer.start();

                        }else{  // else check the answer (if the field is not empty)

                            if(hints.isChecked()&& hintCount<3){
                                Hints(); // call the hints method
                                checkAnswer(); // call the checkAnswer method
                            }
                            else{
                                timer.cancel(); // stop the timer
                                checkAnswer(); // call the checkAnswer method
                            }

                            tAnswerInput = tAnswerInput.substring(tAnswerInput.length()); // when checking the answer clear the tAnswerInput field
                            status.setText(tStatusField);
                                                    }
                    }else{ // when count is 10 score window will open

                        ScorePopUp();
                    }

                    tStatusField = tStatusField.substring(tStatusField.length());   // always set the status empty

                    // set values to the text view
                    padInput.setText(tAnswerInput);
                    expression.setText(tExpression);

                    break;
                case R.id.bMinus:

                    if(tAnswerInput.equals("-")){
                        tAnswerInput = "-".substring(1,tAnswerInput.length()-0); // delete the hole typed answer without the minus mark
                    }else {
                        tAnswerInput = tAnswerInput.substring(tAnswerInput.length()); //prevent the ability to type minus mark after numbers
                    }

                    tAnswerInput = tAnswerInput + "-";
                    padInput.setText(tAnswerInput);
                    break;

            }
        }
    };


    // the method used to determine the game level
    public void setGameLevel(int difficulty){   // pass the difficulty as a parameter from the Game_Level_Window
        this.difficulty = difficulty;   // parameter value equal to difficulty
        createRandomNumbers();          // create random number according to the difficulty
    }


    //used to create random expressions according to the difficulty
    public  void createRandomNumbers(){


        // random number range (1 to 20)
        int rand =  randomNumber.nextInt(20)+1;

        tExpression = rand + "";    // default random number
        result = rand; // assign the random number to the result
        if(this.difficulty == 1){   // if difficulty 1 create random number
            randomNumbers();

        }else if(this.difficulty == 2){ // difficulty 2
            if((randomNumber.nextInt(4-2)+2)== 1){ //check random number bound is 2 to 3
                randomNumbers(); // create random number
            }else{
                for(int i=0;i<2;i++){   //else create one random numbers
                    randomNumbers();    // create random number
                }
            }

        }else if(this.difficulty == 3){ // difficulty 3
            int num = randomNumber.nextInt(5-2)+2; // random number bound is 2 to 4
            if(num==2){
                randomNumbers();    // create random number
            }else if(num==3){ // if num 3 create 2 random nubers from the for loop
                for(int i=0;i<2;i++){
                    randomNumbers();    // create random number
                }
            }else if(num== 4){
                for(int i=0;i<3;i++){ // if num 4 create 3 random nubers from the for loop
                    randomNumbers();    // create random number
                }
            }

        }else if(this.difficulty == 4){   // difficulty 4
            int num = randomNumber.nextInt(6-3)+3;  //check random number bound is 3 to 6
            if(num==3){
                for(int i=0;i<3;i++){  // if num 3 create 2 random nubers from the for loop
                    randomNumbers();    // create random number
                }
            }else if(num== 4){
                for(int i=0;i<4;i++){   // if num 4 create 3 random nubers from the for loop
                    randomNumbers();    // create random number
                }
            }else if(num==5) {
                for(int i=0;i<5;i++){   // if num 5 create 4 random nubers from the for loop
                    randomNumbers();    // create random number
                }
            }

        }
            count++; // every time the method call count increases
             hintCount = 0; // hint initialize as 0 every time the method call
    }

    // create random numbers and operators
    public void randomNumbers(){
        int randNum =randomNumber.nextInt(20)+1;    // random number bound  1 to 20
        int operatorSymbol = randomNumber.nextInt(4); // operator bound 4
        String oSymbol = operators[operatorSymbol]; //  initialize the 4 operators to the oSymbol variable
        tExpression += oSymbol+randNum; // add the random operator and the number to the expression
        calculate(randNum,oSymbol); // call the calculate method
    }

    // calculation method
    public void calculate(int randomNum , String operator){
        switch(operator){
            case "+":
                result = result + randomNum;
                break;
            case "-":
                result = result - randomNum;
                break;
            case "/":
                result = result / randomNum;
                break;
            case "*":
                result = result * randomNum;
                break;
        }
    }

private int score = 0; // initialize score
    // answer checking method
    public void checkAnswer(){
        // convert the result to string
        String  finalAnswer = Integer.toString(result);

        if(finalAnswer.equals(tAnswerInput)){   // if finalAnswer (result) equals to tAnswerInput
            score+=Math.round(100/(10-seconds)); // score logic (in specifications)
            tStatusField = tStatusField + "Correct"; // status show as Correct
            status.setTextColor(Color.parseColor("GREEN")); // set color to the status
            Log.i("Score",score+ "");

        }else{

            tStatusField = tStatusField + "Wrong!!";    // status show as Wrong
            status.setTextColor(Color.parseColor("RED"));  // set color to the status
        }
    }


    //Score window method
    public void ScorePopUp(){
        Intent intent = new Intent(GameWindow.this, Score.class);
        intent.putExtra("score", score+" "); // pass the score value to the score.java file
        intent.putExtra("difficulity",difficulty+""); //pass the gameleve to the score.java
        startActivity(intent);

    }

    //hints method
   public void Hints(){
       int answer = Integer.parseInt(tAnswerInput); // convert the string to int
       if (hintCount<4) {  // when the switch is on the hintCount less than 4 its show the answer is less than or greater than -
           if (hints.isChecked() == true) {                  // - from the answer
               if (answer < result) { //if the answer less than the answer
                   Toast.makeText(GameWindow.this, "Less", Toast.LENGTH_SHORT).show();

               } else {
                   Toast.makeText(GameWindow.this, "Greater", Toast.LENGTH_SHORT).show();
               }

           } else { // when the switch is off
               Toast.makeText(GameWindow.this, "Off", Toast.LENGTH_SHORT).show();
           }
           hintCount++; // increase the hint count
       }

    }

    // prevent immediate Phone back button press and show a dialog box
    @Override
    public void onBackPressed() {
        AlertDialog.Builder exitAlert = new AlertDialog.Builder(this);
        //dialog title
        exitAlert.setTitle("Confirm Exit");
        // dialog icon
        exitAlert.setIcon(R.drawable.qmark);
        // dialog message
        exitAlert.setMessage("Do you want to save?");
        exitAlert.setCancelable(false);
        //exit to the game level window
        exitAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                startActivity(new Intent(GameWindow.this, MainActivity.class)); // open the MainActivity
                Toast.makeText(GameWindow.this,"Game Saved",Toast.LENGTH_SHORT).show();
            }
        });
        // cancel the dialog (cancel the action)
        exitAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog alertDialog = exitAlert.create();
        alertDialog.show();
    }






}

