package com.example.oleg.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.LinearLayout;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static LinearLayout linearLayout;
    private static int COUNTER = 0;
    private static int COLOR = Color.DKGRAY;
    TextView textView;

    public static final String APP_PREFERENCES = "mySettings";
    public static final String APP_PREFERENCES_COLOR = "color";


    private SharedPreferences mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textCounter);
        textView.setText("Couner clicks = "+ COUNTER);

        linearLayout = (LinearLayout)findViewById(R.id.linLay);
        linearLayout.setBackgroundColor(COLOR);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        mSettings = getSharedPreferences(APP_PREFERENCES_COLOR, Context.MODE_PRIVATE);

    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(APP_PREFERENCES, COUNTER);
        editor.putInt(APP_PREFERENCES_COLOR, COLOR);
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mSettings.contains(APP_PREFERENCES)){
            COUNTER = mSettings.getInt(APP_PREFERENCES, 0);
            textView.setText("Counter cliks = " + COUNTER);
        }

        if (mSettings.contains(APP_PREFERENCES_COLOR)){
            COLOR = mSettings.getInt(APP_PREFERENCES_COLOR, 0);
            linearLayout.setBackgroundColor(COLOR);
        }
    }

    public void clickBtn (View view){
        linearLayout = (LinearLayout)findViewById(R.id.linLay);

        COUNTER++;
        textView.setText("Couner clicks = "+ COUNTER);
        switch (view.getId()) {
            case R.id.btnRed: linearLayout.setBackgroundColor(Color.RED);
                COLOR = Color.RED;
                break;
            case R.id.btnBlack: linearLayout.setBackgroundColor(Color.BLACK);
                COLOR = Color.BLACK;
                break;
            case R.id.btnGreen: linearLayout.setBackgroundColor(Color.GREEN);
                COLOR = Color.GREEN;
                break;
            case R.id.btnGray: linearLayout.setBackgroundColor(Color.GRAY);
                COLOR = Color.GRAY;
                break;
            case R.id.btnYellow: linearLayout.setBackgroundColor(Color.YELLOW);
                COLOR = Color.YELLOW;
                break;
            case R.id.btnBlue: linearLayout.setBackgroundColor(Color.BLUE);
                COLOR = Color.BLUE;
                break;
            case R.id.btnWhite: linearLayout.setBackgroundColor(Color.WHITE);
                COLOR = Color.WHITE;
                break;

        }

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Activity")
                .setMessage("Are you sure you wont close app?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}
