package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BMIActivity extends AppCompatActivity {

    android.widget.Button mRecalculate;

    TextView mBMIdisplay, mBMIcategory, mGender;
    Intent intent;
    ImageView mImageView;
    String mBMI;
    float intBMI;

    String mHeight;
    String mWeight;
    float intHeight, intWeight;
    RelativeLayout mBackground;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#083863"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        mRecalculate = findViewById(R.id.gotomain);
        mImageView = findViewById(R.id.imageview);

        intent = getIntent();

        mBMIdisplay = findViewById(R.id.bmidisplay);
        mBMIcategory = findViewById(R.id.bmicategorydispaly);
        mGender = findViewById(R.id.genderdisplay);
        mBackground = findViewById(R.id.contentlayout);

        mGender.setText(intent.getStringExtra("gender"));

        mHeight = intent.getStringExtra("height");
        mWeight = intent.getStringExtra("weight");

        intHeight = Float.parseFloat(mHeight);
        intWeight = Float.parseFloat(mWeight);


        intHeight = intHeight/100;

        intBMI = intWeight/(intHeight*intHeight);

        mBMI = Float.toString(intBMI);

        if(intBMI < 16){
            mBMIcategory.setText("Underweight (Severe thinness)");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.crosss);
        }

        else if(intBMI <= 16.9 && intBMI >=  16){
            mBMIcategory.setText("Underweight (Moderate thinness)");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.crosss);
        }

        else if(intBMI <= 18.4 && intBMI > 16.9){
            mBMIcategory.setText("Underweight (Mild thinness)");
            mBackground.setBackgroundColor(Color.YELLOW);
            mImageView.setImageResource(R.drawable.warning);
        }

        else if(intBMI <= 24.9 && intBMI >= 18.5){
            mBMIcategory.setText("Normal");
            mBackground.setBackgroundColor(Color.GREEN);
            mImageView.setImageResource(R.drawable.ok);
        }

        else if(intBMI <= 29.9 && intBMI >= 25){
            mBMIcategory.setText("Overweight (Pre-obese");
            mBackground.setBackgroundColor(Color.YELLOW);
            mImageView.setImageResource(R.drawable.warning);
        }

        else if(intBMI <= 34.9 && intBMI >= 30){
            mBMIcategory.setText("Obese (Class I)");
            mBackground.setBackgroundColor(Color.YELLOW);
            mImageView.setImageResource(R.drawable.warning);
        }

        else if(intBMI <= 39.9 && intBMI >= 35){
            mBMIcategory.setText("Obese (Class II)");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.crosss);
        }

        else if(intBMI >= 40){
            mBMIcategory.setText("Obese (Class III)");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.crosss);
        }

        mBMIdisplay.setText(mBMI);


        mRecalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BMIActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}