package com.hackathon.chegg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.hackathon.chegg.Fragments.Analysis_Fragment;
import com.hackathon.chegg.Fragments.Profile_Fragment;
import com.hackathon.chegg.Fragments.Study_Fragment;
import com.hackathon.chegg.Fragments.tests.Test_Fragment;
import com.hackathon.chegg.services.authentication.AuthService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Study_Fragment()).commit();

        SharedPreferences sf=getSharedPreferences("ShredPref", Context.MODE_PRIVATE);


        //new AuthService(FirebaseAuth.getInstance(),FirebaseFirestore.getInstance()).saveUserDetails(emailText,name, FirebaseAuth.getInstance().getUid());

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Analysis:

                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Analysis_Fragment()).commit();
                        break;
                    case R.id.Profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Profile_Fragment()).commit();
                        break;
                    case R.id.Study:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Study_Fragment()).commit();
                        break;
                    case R.id.Test:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Test_Fragment()).commit();
                        break;
                    default:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Study_Fragment()).commit();

                }
                return true;
            }
        });



    }
}