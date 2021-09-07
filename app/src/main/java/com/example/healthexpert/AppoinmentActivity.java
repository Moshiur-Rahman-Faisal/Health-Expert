package com.example.healthexpert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class AppoinmentActivity extends AppCompatActivity {


    RecyclerView mrecyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClassDoctor> userList;
    AdapterDoctor docadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoinment);
        
        initdata();
        initRecyclerView();
        
        
    }

    private void initdata() {

        userList = new ArrayList<>();

        userList.add(new ModelClassDoctor(R.drawable.fahim2, "Dr. Istiak", "MBBS (USA)", "MW (9am - 5pm),", "RA (2pm - 5pm),", "Dhaka Medical College"));
        userList.add(new ModelClassDoctor(R.drawable.fahim, " Dr. Fahim", "MBBS (KMC)", "MW (9am - 5pm),", "RA (2pm - 5pm),", "Dhaka Medical College"));
        userList.add(new ModelClassDoctor(R.drawable.newaz1, "Dr. Ali Newaz", "MBBS (FMC)", "MW (9am - 5pm),", "RA (2pm - 5pm),", "Khulna Medical College"));
        userList.add(new ModelClassDoctor(R.drawable.sam1, "Dr. Sam", "MBBS (MMC)", "MW (9am - 5pm),", "RA (2pm - 5pm),", "Bangladesh Medical College"));
        userList.add(new ModelClassDoctor(R.drawable.faisal, "Dr. Moshiur", "MBBS (UK)", "MW (9am - 5pm),", "RA (2pm - 5pm),", "Mymensing Medical College"));
        userList.add(new ModelClassDoctor(R.drawable.faisal2, "Dr. Faisal", "MBBS (DMC)", "MW (9am - 5pm),", "RA (2pm - 5pm),", "Faridpur Medical College"));
        userList.add(new ModelClassDoctor(R.drawable.newaz2, "Dr. Joardar", "MBBS (DMC)", "MW (9am - 5pm),", "RA (2pm - 5pm),", "Satkhira Medical College"));
        userList.add(new ModelClassDoctor(R.drawable.sam2, "Dr. Zaman", "MBBS (Elakar Haspatal)", "MW (9am - 5pm),", "RA (2pm - 5pm),", "Satkhira Medical College"));





    }

    private void initRecyclerView() {


        mrecyclerView=findViewById(R.id.recyclerviewdoc);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mrecyclerView.setLayoutManager(layoutManager);
        docadapter=new AdapterDoctor(userList);
        mrecyclerView.setAdapter(docadapter);
        docadapter.notifyDataSetChanged();


    }
}