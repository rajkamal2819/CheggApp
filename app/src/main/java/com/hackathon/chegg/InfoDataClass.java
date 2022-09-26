package com.hackathon.chegg;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        String URL = "https://en.wikipedia.org/w/api.php?action=query&exlimit=1&explaintext=1&exsentences=10&formatversion=2&prop=extracts&titles="+name+"&format=json";
        final String[] info = {""};

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {




                        try {

                           Log.d("response1",response.getString("title"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        volleyResponseListener.onResponse(response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.d("Response",error.getMessage());

                        volleyResponseListener.onError("No info");
                    }
        });

        MySingleton.getInstance(context).addToRequestQueue(request);
    }
}
