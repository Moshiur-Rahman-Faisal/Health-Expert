package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    android.widget.Button mCalculateBMI;

    TextView mCurrentHeight, mCurrentWeight, mCurrentAge;
    ImageView mIncrementAge, mIncrementWeight, mDecrementAge, mDecrementWeight;
    SeekBar mSeekbarforheight;
    RelativeLayout mMale,mFemale;

    int intWeight = 55;
    int intAge = 22;
    int currentprogress;
    String mintprogress = "170";
    String typeofuser = "0";
    String weight2 = "55";
    String age2 = "22";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        mCalculateBMI = findViewById(R.id.calculatebmi);
        mCurrentAge = findViewById(R.id.currentAge);
        mCurrentHeight = findViewById(R.id.currentheight);
        mCurrentWeight = findViewById(R.id.currentweight);
        mIncrementAge = findViewById(R.id.incrementAge);
        mDecrementAge = findViewById(R.id.decrementAge);
        mIncrementWeight = findViewById(R.id.incrementweight);
        mDecrementWeight = findViewById(R.id.decrementweight);

        mSeekbarforheight = findViewById(R.id.seekbarforheight);
        mMale = findViewById(R.id.male);
        mFemale = findViewById(R.id.female);


        mMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemale_focus));
                mFemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemale_notfocus));
                typeofuser = "Male";
            }
        });


        mFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemale_focus));
                mMale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemale_notfocus));
                typeofuser = "Female";
            }
        });


        mSeekbarforheight.setMax(400);
        mSeekbarforheight.setProgress(170);

        mSeekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentprogress = progress;
                mintprogress = String.valueOf(currentprogress);
                mCurrentHeight.setText(mintprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        mIncrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intAge = intAge+1;
                age2 = String.valueOf(intAge);
                mCurrentAge.setText(age2);
            }
        });

        mDecrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intAge = intAge-1;
                age2 = String.valueOf(intAge);
                mCurrentAge.setText(age2);
            }
        });


        mIncrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeight = intWeight+1;
                weight2 = String.valueOf(intWeight);
                mCurrentWeight.setText(weight2);
            }
        });

        mDecrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeight = intWeight-1;
                weight2 = String.valueOf(intWeight);
                mCurrentWeight.setText(weight2);
            }
        });



        mCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (typeofuser.equals("0")){
                    Toast.makeText(getApplicationContext(),"Select Your Gender", Toast.LENGTH_SHORT).show();
                }

                else if(mintprogress.equals("0")){
                    Toast.makeText(getApplicationContext(),"Select Your Height", Toast.LENGTH_SHORT).show();
                }
                else if(intAge == 0 || intAge < 0){
                    Toast.makeText(getApplicationContext(),"Enter Your Valid Age", Toast.LENGTH_SHORT).show();
                }
                else if(intWeight == 0 || intWeight < 0){
                    Toast.makeText(getApplicationContext(),"Enter Your Valid Weight", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Calculating Your BMI", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, BMIActivity.class);

                    intent.putExtra("gender", typeofuser);
                    intent.putExtra("height", mintprogress);
                    intent.putExtra("weight", weight2);
                    intent.putExtra("age", age2);

                    startActivity(intent);
                }

            }
        });
    }
}