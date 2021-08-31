package com.example.healthexpert;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    GoogleSignInClient mGoogleSignInClient;

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //drawer
        drawerLayout = findViewById(R.id.nav_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigation_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //drawer ends

        //navigation item click
        navigationView.setNavigationItemSelectedListener(this);
        //navigation item click ends

        //google signin option and effects on logging out
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        //// Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        //google signin option and effects on logging out ends
    }

    //menubar item select process
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.tracker:
                Toast.makeText(getApplicationContext(),"Opening Covid-19 Tracker", Toast.LENGTH_SHORT).show();
                Intent covidtracker = new Intent(MainActivity.this, CovidTrackerActivity.class);
                startActivity(covidtracker);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.bmicalculator:
                Toast.makeText(getApplicationContext(),"Opening BMI Calculator", Toast.LENGTH_SHORT).show();
                Intent bmicalculator = new Intent(MainActivity.this, BMI.class);
                startActivity(bmicalculator);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.profile:
                Toast.makeText(getApplicationContext(),"Opening Profile", Toast.LENGTH_SHORT).show();
                Intent profile = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(profile);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.logout:
                Toast.makeText(getApplicationContext(), "Logging Out", Toast.LENGTH_LONG).show();
                FirebaseAuth.getInstance().signOut();
                mGoogleSignInClient.signOut();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    //menubar item select process ends

    //drawer
    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }

        else{
            super.onBackPressed();
        }

    }
    //drawer end
}