package com.example.healthexpert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultHeathMonitoring extends AppCompatActivity {

    android.widget.Button mRecheck;

    TextView mhealthconditions, mconsultdoctor;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_heath_monitoring);

        mhealthconditions = findViewById(R.id.healthconditions);
        mconsultdoctor = findViewById(R.id.consultdoctor);

        intent = getIntent();


        mhealthconditions.setText(intent.getStringExtra("fever"));
        mhealthconditions.setText(intent.getStringExtra("dry"));

        if(mhealthconditions == fever){

            mconsultdoctor.setText("Please Consult With Doctor");
        }
        else{
            mconsultdoctor.setText("No Worries");
        }



        mRecheck = findViewById(R.id.recheck);

        mRecheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(ResultHeathMonitoring.this, ActivityHealthMonitoring.class);
                startActivity(back);
                finish();
            }
        });
    }
}