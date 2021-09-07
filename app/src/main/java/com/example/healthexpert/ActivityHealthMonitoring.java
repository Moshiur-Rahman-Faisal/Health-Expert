package com.example.healthexpert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ActivityHealthMonitoring extends AppCompatActivity {

    android.widget.Button mCheck;

    RelativeLayout mFeverYes, mFeverNo, mDryYes, mDryNo, mTiredYes, mTiredNo, mBreathYes, mBreathNo, mChestYes, mChestNo, mMoveYes, mMoveNo;
    String typeofans1 = "0";
    String typeofans2 = "0";
    String typeofans3 = "0";
    String typeofans4 = "0";
    String typeofans5 = "0";
    String typeofans6 = "0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_monitoring);


        mFeverYes = findViewById(R.id.feveryes);
        mFeverNo = findViewById(R.id.feverno);
        mDryYes = findViewById(R.id.drycoughyes);
        mDryNo = findViewById(R.id.drycoughno);
        mTiredYes = findViewById(R.id.tirednessyes);
        mTiredNo = findViewById(R.id.tirednessno);
        mBreathYes = findViewById(R.id.breathingyes);
        mBreathNo = findViewById(R.id.breathingno);
        mChestYes = findViewById(R.id.chestpainyes);
        mChestNo = findViewById(R.id.chestpainno);
        mMoveYes = findViewById(R.id.movementyes);
        mMoveNo = findViewById(R.id.movementno);

        mCheck = findViewById(R.id.checkcondition);


        //fever
        mFeverYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFeverYes.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemale_focus));
                mFeverNo.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemale_notfocus));
                typeofans1 = "Fever";
            }
        });

        mFeverNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFeverNo.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemale_focus));
                mFeverYes.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemale_notfocus));
                typeofans1 = "Not Fever";
            }
        });


        //dry cough
        mDryYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDryYes.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemale_focus));
                mDryNo.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemale_notfocus));
                typeofans2 = "Dry Cough";
            }
        });

        mDryNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDryNo.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemale_focus));
                mDryYes.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemale_notfocus));
                typeofans2 = "Not Dry Cough";
            }
        });


        //tiredness
        mTiredYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTiredYes.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemale_focus));
                mTiredNo.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemale_notfocus));
                typeofans3 = "Tired";
            }
        });

        mTiredNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTiredNo.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemale_focus));
                mTiredYes.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemale_notfocus));
                typeofans3 = "Not Tired";
            }
        });


        //Breathing
        mBreathYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBreathYes.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemale_focus));
                mBreathNo.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemale_notfocus));
                typeofans4 = "Breathing problem";
            }
        });

        mBreathNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBreathNo.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemale_focus));
                mBreathYes.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemale_notfocus));
                typeofans4 = "No breathing Problem";
            }
        });


        //chestpain
        mChestYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mChestYes.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemale_focus));
                mChestNo.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemale_notfocus));
                typeofans5 = "Chest pain";
            }
        });

        mChestNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mChestNo.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemale_focus));
                mChestYes.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemale_notfocus));
                typeofans5 = "No Chest Pain";
            }
        });



        //movement
        mMoveYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMoveYes.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemale_focus));
                mMoveNo.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemale_notfocus));
                typeofans6 = "Loss of Speech or Movement";
            }
        });

        mMoveNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMoveNo.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemale_focus));
                mMoveYes.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemale_notfocus));
                typeofans6 = "No Problem";
            }
        });




        mCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (typeofans1.equals("0")){
                    Toast.makeText(getApplicationContext(),"Select Your Fever Condition", Toast.LENGTH_SHORT).show();
                }
                else if(typeofans2.equals("0")){
                    Toast.makeText(getApplicationContext(),"Select Your Dry Cough Condition", Toast.LENGTH_SHORT).show();

                }
                else if(typeofans3.equals("0")){
                    Toast.makeText(getApplicationContext(),"Select Your Stress Condition", Toast.LENGTH_SHORT).show();

                }
                else if(typeofans4.equals("0")){
                    Toast.makeText(getApplicationContext(),"Select Your Breathing Condition", Toast.LENGTH_SHORT).show();

                }
                else if(typeofans5.equals("0")){
                    Toast.makeText(getApplicationContext(),"Select Your Chest pain Condition", Toast.LENGTH_SHORT).show();

                }
                else if(typeofans6.equals("0")){
                    Toast.makeText(getApplicationContext(),"Select Your Speech or Movement Condition", Toast.LENGTH_SHORT).show();

                }

                else{
                    Toast.makeText(getApplicationContext(), "Checking You Health Condition", Toast.LENGTH_SHORT).show();
                    Intent checkmonitor = new Intent(ActivityHealthMonitoring.this, ResultHeathMonitoring.class);

                    checkmonitor.putExtra("fever", typeofans1);
                    checkmonitor.putExtra("dry", typeofans2);
                    checkmonitor.putExtra("stress", typeofans3);
                    checkmonitor.putExtra("breath", typeofans4);
                    checkmonitor.putExtra("chest", typeofans5);
                    checkmonitor.putExtra("move", typeofans6);

                    startActivity(checkmonitor);

                }


            }
        });
    }
}