package com.example.healthexpert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class BloodActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClassBlood>userlist;
    AdapterBlood adapterBlood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood);


        initData();
        initRecyclerView();




    }

    private void initData() {

        userlist = new ArrayList<>();

        userlist.add(new ModelClassBlood(R.drawable.profileimage, "Fahim", "B+", "abc@gmail.com"));
        userlist.add(new ModelClassBlood(R.drawable.profileimage, "Fahim", "B+", "abc@gmail.com"));
        userlist.add(new ModelClassBlood(R.drawable.profileimage, "Fahim", "B+", "abc@gmail.com"));
        userlist.add(new ModelClassBlood(R.drawable.profileimage, "Fahim", "B+", "abc@gmail.com"));
        userlist.add(new ModelClassBlood(R.drawable.profileimage, "Fahim", "B+", "abc@gmail.com"));
        userlist.add(new ModelClassBlood(R.drawable.profileimage, "Fahim", "B+", "abc@gmail.com"));
        userlist.add(new ModelClassBlood(R.drawable.profileimage, "Fahim", "B+", "abc@gmail.com"));



    }

    private void initRecyclerView() {

        recyclerView = findViewById(R.id.recyclerviewofblood);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapterBlood = new AdapterBlood(userlist);
        recyclerView.setAdapter(adapterBlood);
        adapterBlood.notifyDataSetChanged();

    }
}