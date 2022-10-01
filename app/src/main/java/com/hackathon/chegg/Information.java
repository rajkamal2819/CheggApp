package com.hackathon.chegg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.hackathon.chegg.STEMSubject.AstoFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        LinearLayout main = findViewById(R.id.mainll);
        main.setVisibility(View.INVISIBLE);
        CircularProgressIndicator progressIndicator = findViewById(R.id.linearprogressbar);
        progressIndicator.setVisibility(View.VISIBLE);
        Intent i = getIntent();
        String model = i.getStringExtra("name_of_model");
        String name = i.getStringExtra("name_of_module");
       ExtendedFloatingActionButton fb = findViewById(R.id.extended_fab);
       fb.setVisibility(View.INVISIBLE);
//        LinearLayoutCompat l = findViewById(R.id.l);
        CollapsingToolbarLayout title = findViewById(R.id.ToolBarForTitle);
        TextView content = findViewById(R.id.content);
        InfoDataClass info = new InfoDataClass(this);
        info.getInfo( name, new InfoDataClass.VolleyResponseListener() {
            @Override
            public void onError(String message) {

            }

            @Override
            public void onResponse(String info) {
                try {
                    Log.d("Responsde",info);
                    JSONObject obj = new JSONObject(info);
                    JSONObject query = obj.getJSONObject("query");
                    JSONArray pages = query.getJSONArray("pages");
                    JSONObject first = pages.getJSONObject(0);
                    String title1 = first.getString("title");
                    String content1 = first.getString("extract");

                    title.setTitle(title1);

                    content.setText(content1);
                    progressIndicator.setVisibility(View.INVISIBLE);
                    main.setVisibility(View.VISIBLE);
                    fb.setVisibility(View.VISIBLE);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }


        });
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Augmented.class);
                intent.putExtra("model",model);

                startActivity(intent);
            }
        });



    }
}