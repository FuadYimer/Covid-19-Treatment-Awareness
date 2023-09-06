package com.example.covid_selef_treatment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class CovidCaseETRegional extends Fragment {

    // Regional covid case variable
    private String url = "http://192.168.1.8/CovidTreatmentAndAwareness/getcovid.php";
    private RecyclerView regionList;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<RegionalCaseModel> regionalData;
    private RecyclerView.Adapter adapter;


    // shared preference variable
    public static final String mypreference = "ETRegionalCase";
    SharedPreferences sharedpreferences_ETregionalcase;
    public static final String Region = "region";
    public static final String TotalCase = "case";
    public static final String Death = "death";


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CovidCaseETRegional() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CovidCaseETRegional.
     */
    // TODO: Rename and change types and number of parameters
    public static CovidCaseETRegional newInstance(String param1, String param2) {
        CovidCaseETRegional fragment = new CovidCaseETRegional();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_covid_case_e_t_regional, container, false);
        // Regional covid case call
        regionList = view.findViewById(R.id.main_list);

        regionalData = new ArrayList<>();
        adapter = new RegionalCovidCaseAdapter(getActivity().getApplicationContext(),regionalData);

        linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(regionList.getContext(), linearLayoutManager.getOrientation());

        regionList.setHasFixedSize(true);
        regionList.setLayoutManager(linearLayoutManager);
        regionList.addItemDecoration(dividerItemDecoration);
        regionList.setAdapter(adapter);


        getRegionalData();
        return  view;
    }

    private void getRegionalData() {
        
        // get regional case via webserver
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        RegionalCaseModel region = new RegionalCaseModel();
                        region.setRegion(jsonObject.getString("region"));
                        region.setActivecase(jsonObject.getInt("case"));
                        region.setDeath(jsonObject.getInt("death"));
                        regionalData.add(region);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(getContext(), "Json error ", Toast.LENGTH_SHORT).show();
                    }
                }
                // Save data to shared preference
                saveDataTosharedPrefetence();
                adapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loadDataFromSharedPreference();
                Toast.makeText(getContext(), R.string.last_sysnced_reginonal_data_loaded_no_internet, Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(jsonArrayRequest);



       // Get Regional Covid Data from Json file
       /* try {

            String jsonDataString = readJSONDataFromFile();
            JSONArray jsonArray = new JSONArray(jsonDataString);

            for (int i=0; i<jsonArray.length(); ++i) {

                JSONObject itemObj = jsonArray.getJSONObject(i);

                RegionalCaseModel region = new RegionalCaseModel();
                region.setRegion(itemObj.getString("region"));
                region.setActivecase(itemObj.getInt("case"));
                region.setDeath(itemObj.getInt("death"));

                regionalData.add(region);

            }
            adapter.notifyDataSetChanged();

        } catch (JSONException | IOException e) {
            Log.d("RegionalCovidClass", "Json Error  ", e);
        }*/
    }



    private String readJSONDataFromFile() throws IOException {

        InputStream inputStream = null;
        StringBuilder builder = new StringBuilder();

        try {

            String jsonString = null;
            inputStream = getResources().openRawResource(R.raw.regoional);
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


    private void saveDataTosharedPrefetence() {
        sharedpreferences_ETregionalcase = this.getActivity().getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences_ETregionalcase.edit();
        Gson gson = new Gson();
        String json = gson.toJson(regionalData);
        editor.putString("RegionalCase", json);
        editor.apply();
    }
    private void loadDataFromSharedPreference() {
        sharedpreferences_ETregionalcase = this.getActivity().getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        Gson gson = new Gson();
        String json = sharedpreferences_ETregionalcase.getString("RegionalCase", null);
        Type type = new TypeToken<List<RegionalCaseModel>>() {}.getType();
        regionalData = gson.fromJson(json, type);
        if (regionalData == null) {
           // getRegionalData();
            regionalData = new ArrayList<>();
        }

        adapter = new RegionalCovidCaseAdapter(getActivity().getApplicationContext(),regionalData);
       /* linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList.getContext(), linearLayoutManager.getOrientation());

        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);*/
        regionList.setAdapter(adapter);

        //adapter.notifyDataSetChanged();


    }
}