package com.hackathon.chegg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hackathon.chegg.Fragments.Analysis_Fragment;
import com.hackathon.chegg.Fragments.Profile_Fragment;
import com.hackathon.chegg.Fragments.Study_Fragment;
import com.hackathon.chegg.Fragments.tests.Test_Fragment;

import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Study_Fragment()).commit();


        SmoothBottomBar bottomNavigationView = (SmoothBottomBar) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onItemSelect(int i) {
                switch (i){
                    case 0:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Study_Fragment()).commit();
                        break;
                    case 1:

                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Analysis_Fragment()).commit();
                        break;
                    case 3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Profile_Fragment()).commit();
                        break;

                    case 2:
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