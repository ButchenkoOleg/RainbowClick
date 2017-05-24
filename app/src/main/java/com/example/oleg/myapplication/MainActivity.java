package com.example.oleg.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static LinearLayout linearLayout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void clickBtn (View view){
        linearLayout = (LinearLayout)findViewById(R.id.linLay);
        switch (view.getId()) {
            case R.id.btnRed: linearLayout.setBackgroundColor(Color.RED);break;
            case R.id.btnBlack: linearLayout.setBackgroundColor(Color.BLACK);break;
            case R.id.btnGreen: linearLayout.setBackgroundColor(Color.GREEN);break;
        }

    }


}
