package com.hackathon.chegg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.hackathon.chegg.Adapters.FragmentAdapter;
import com.hackathon.chegg.databinding.ActivityAuthenticationBinding;

public class Authentication extends AppCompatActivity {


    private static final String TAG = Authentication.class.getSimpleName();
    private ViewPager viewPager;
    private TabLayout tabLayout;
//done chatbot ar books api but mistakenly did it with other email thats why not showing in contrubtors but you can see my commits
    //in commit section as Anii232002
    ActivityAuthenticationBinding binding;
    FloatingActionButton googleAuthBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(FirebaseAuth.getInstance().getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }
        setContentView(R.layout.activity_authentication);
        binding = ActivityAuthenticationBinding.inflate(getLayoutInflater());

        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabLayout);
        googleAuthBtn = findViewById(R.id.google_auth_button);

        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        googleAuthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });


    }


}