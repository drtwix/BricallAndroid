package com.bricall.bricallandroid.activities;


import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bricall.bricallandroid.R;
import com.bricall.bricallandroid.adapters.RecyclerViewAdapter;
import com.bricall.bricallandroid.model.Service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

    public class ServiceActivity extends AppCompatActivity {

    private final String JSON_URL = "https://bricall-prod-backend.eu-de.mybluemix.net/api/services" ;
    private JsonArrayRequest request ;
    private RequestQueue requestQueue ;
    private List<Service> lstService ;
    private RecyclerView recyclerView ;
    private final String bricallurl = "https://www.bricall.ma" ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstService = new ArrayList<>() ;
        recyclerView = findViewById(R.id.recyclerviewid);
        jsonrequest();



    }

    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject  = null ;

                for (int i = 0 ; i < response.length(); i++ ) {


                    try {
                        jsonObject = response.getJSONObject(i) ;
                        Service service = new Service() ;
                        service.setService_id(jsonObject.getString("id"));
                        service.setSlug(jsonObject.getString("slug"));
                        service.setService_name(jsonObject.getString("name"));
                        service.setService_img_url(bricallurl+jsonObject.getString("picture"));
                        service.setService_status(jsonObject.getBoolean("activated"));
                        lstService.add(service);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                setuprecyclerview(lstService);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue = Volley.newRequestQueue(ServiceActivity.this);
        requestQueue.add(request) ;


    }

    private void setuprecyclerview(List<Service> lstService) {


        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this,lstService) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);

    }
}

