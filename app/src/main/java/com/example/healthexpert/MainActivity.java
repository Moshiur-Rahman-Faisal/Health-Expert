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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    GoogleSignInClient mGoogleSignInClient;

    TextView NavName, NavEmail;
    ImageView NavImage;

    DatabaseReference mDatabaseUser;
    FirebaseAuth fAuth;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

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




// nav header starts
        View headerView = navigationView.getHeaderView(0);
        NavName = (TextView) headerView.findViewById(R.id.nav_name);
        NavEmail = (TextView) headerView.findViewById(R.id.nav_email);
        NavImage = (ImageView) headerView.findViewById(R.id.nav_pic);

        mDatabaseUser = FirebaseDatabase.getInstance().getReference().child("users").child(user.getUid());
        fAuth = FirebaseAuth.getInstance();

        mDatabaseUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                UserProfileInfo userProfileInfo = snapshot.getValue(UserProfileInfo.class);

                NavName.setText(userProfileInfo.getUsername());
                NavEmail.setText(userProfileInfo.getEmail());
                Picasso.get().load(userProfileInfo.Img_url).into(NavImage);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //nav header ends


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

            case R.id.bloodgroupmenu:
                Toast.makeText(getApplicationContext(),"Searching Blood", Toast.LENGTH_SHORT).show();
                Intent blood = new Intent(MainActivity.this, BloodActivity.class);
                startActivity(blood);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.healthmonitor:
                Toast.makeText(getApplicationContext(),"Monitor your health here", Toast.LENGTH_SHORT).show();
                Intent health = new Intent(MainActivity.this, ActivityHealthMonitoring.class);
                startActivity(health);
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