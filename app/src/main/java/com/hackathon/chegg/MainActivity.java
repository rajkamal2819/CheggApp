package com.hackathon.chegg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hackathon.chegg.Fragments.Analysis_Fragment;
import com.hackathon.chegg.Fragments.Profile_Fragment;
import com.hackathon.chegg.Fragments.SignUpFragment;
import com.hackathon.chegg.Fragments.Study_Fragment;
import com.hackathon.chegg.Fragments.Test_Fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Study_Fragment()).commit();


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