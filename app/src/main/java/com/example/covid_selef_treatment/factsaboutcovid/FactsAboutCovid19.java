package com.example.covid_selef_treatment.factsaboutcovid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.covid_selef_treatment.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class FactsAboutCovid19 extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Object> viewItems = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;
    private FactsAdapter.RecyclerViewClickListner listner;

    private RecyclerView.LayoutManager layoutManager;
    public int[] imageid = new int[] {R.drawable.factsaboutcovid_1, R.drawable.factsaboutcovid_2, R.drawable.factsaboutcovid_3,
            R.drawable.factsaboutcovid_4,  R.drawable.factsaboutcovid_5, R.drawable.factsaboutcovid_6 ,R.drawable.factsaboutcovid_7,
            R.drawable.factsaboutcovid_8, R.drawable.factsaboutcovid_9, R.drawable.factsaboutcovid_10,R.drawable.factsaboutcovid_11,
            R.drawable.factsaboutcovid_12, R.drawable.factsaboutcovid_13, R.drawable.factsaboutcovid_14 , R.drawable.factsaboutcovid_15,
            R.drawable.factsaboutcovid_16,R.drawable.factsaboutcovid_17,R.drawable.factsaboutcovid_18,R.drawable.factsaboutcovid_19,
            R.drawable.factsaboutcovid_20,R.drawable.factsaboutcovid_21,R.drawable.factsaboutcovid_22, R.drawable.factsaboutcovid_23,
            R.drawable.factsaboutcovid_24,R.drawable.factsaboutcovid_25, R.drawable.factsaboutcovid_26,R.drawable.factsaboutcovid_27};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facts_about_covid19);


        setadapter();
        addFactsFromJSON();
    }


    private void setadapter(){
        setonclicklistnet();
        mRecyclerView = findViewById(R.id.factsrecyclerview);
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new FactsAdapter(this, viewItems , listner);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void setonclicklistnet() {

        listner = new FactsAdapter.RecyclerViewClickListner() {
            @Override
            public void onClick(View v, int position) {

                FactsData data = (FactsData) viewItems.get(position);
                Intent intent  = new Intent(getApplicationContext() , FactsDetailActivity.class);
                intent.putExtra("facttitle" , data.getTitle());
                intent.putExtra("factdetail" , data.getTitledetail());
                intent.putExtra("factpicture" , data.getFactphotoid());
                startActivity(intent);
            }
        };
    }

    private void addFactsFromJSON() {
        try {


            String jsonDataString = readJSONDataFromFile();
            JSONArray jsonArray = new JSONArray(jsonDataString);

            for (int i=0; i<jsonArray.length(); ++i) {
                JSONObject itemObj = jsonArray.getJSONObject(i);
                String title = itemObj.getString("fact");
                String detail = itemObj.getString("detail");
               // String imageName = itemObj.getString("image");

                // get resource id by image name
               // final int resourceId = resources.getIdentifier(imageName, "drawable", context.getPackageName());
                FactsData getfactsdata = new FactsData(title, detail,imageid[i]);
                viewItems.add(getfactsdata);
            }

        }
        catch (JSONException | IOException e) {
            Log.d("FactsAbout.class", "addItemsFromJSON: ", e);
        }
    }

    private String readJSONDataFromFile() throws IOException{

        InputStream inputStream = null;
        StringBuilder builder = new StringBuilder();
        try {
            String jsonString = null;
            inputStream = getResources().openRawResource(R.raw.factsaboutcovid);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream, "UTF-8"));

            while ((jsonString = bufferedReader.readLine()) != null) {
                builder.append(jsonString);
            }

        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return new String(builder);
    }
}