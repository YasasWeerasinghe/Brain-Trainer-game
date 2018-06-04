package com.example.yasasweerasinghe.mobilecw01;

import android.os.Bundle;
import android.util.DisplayMetrics;

import com.example.yasasweerasinghe.mobilecw01.MainActivity;
import com.example.yasasweerasinghe.mobilecw01.R;

/**
 * Created by Yasas Weerasingh on 26-Feb-18.
 */

public class PopWindow extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popup);

        // give a size for the pop Up window
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;
            //window size
        getWindow().setLayout((int) (width * .8), (int) (height * .6));

    }
}
