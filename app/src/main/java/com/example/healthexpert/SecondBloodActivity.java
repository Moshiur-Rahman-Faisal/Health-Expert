package com.example.healthexpert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class SecondBloodActivity extends AppCompatActivity {

    RecyclerView recview;
    myadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_blood);

        recview = (RecyclerView) findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<ModelClass> options =
                new FirebaseRecyclerOptions.Builder<ModelClass>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("users"), ModelClass.class)
                        .build();

        adapter = new myadapter(options);
        recview.setAdapter(adapter);

    }


    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }


    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.searchbloodmenu, menu);

        MenuItem item = menu.findItem(R.id.search);


        SearchView searchView = (SearchView)item.getActionView();



        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                ProcessSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                ProcessSearch(newText);
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

    private void ProcessSearch(String newText) {

        FirebaseRecyclerOptions<ModelClass> options =
                new FirebaseRecyclerOptions.Builder<ModelClass>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("users").orderByChild("blood").startAt(newText)
                                .endAt(newText+"\uf8ff"), ModelClass.class)
                        .build();

        adapter = new myadapter(options);
        adapter.startListening();
        recview.setAdapter(adapter);


    }
}