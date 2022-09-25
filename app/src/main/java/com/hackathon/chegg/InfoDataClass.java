package com.hackathon.chegg;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

public class InfoDataClass {

    Context context;

    public InfoDataClass(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener{
        void onError(String message);
        void onResponse(String info);
    }

    public void getInfo(String name, VolleyResponseListener volleyResponseListener){
        String URL = name;
        String info="";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, URL,null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {




                        volleyResponseListener.onResponse(info);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {



                        volleyResponseListener.onError("No info");
                    }
        });

        MySingleton.getInstance(context).addToRequestQueue(request);

    }
}
