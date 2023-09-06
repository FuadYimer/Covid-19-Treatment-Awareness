package com.example.covid_selef_treatment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CovidCasesET#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CovidCasesET extends Fragment {

    TextView todaycases, totalcases, recovered, countryname, deaths , critical, activecase;




    // shared Prefetence settings
    public static final String mypreference = "ETCase";
    SharedPreferences sharedpreferences_ETcase;
    public static final String TodayCase = "TodayCase";
    public static final String TotalCase = "TotalCase";
    public static final String Recovered = "Recovered";
    public static final String CountryName = "CountryName";
    public static final String Death = "Death";
    public static final String Critical = "Critical";
    public static final String ActiveCase = "ActiveCase";




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CovidCasesET() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CovidCases.
     */
    // TODO: Rename and change types and number of parameters
    public static CovidCasesET newInstance(String param1, String param2) {
        CovidCasesET fragment = new CovidCasesET();
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

        // check shared preference if there is no internt connection to load previous value
        // ?????????????????


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_covid_cases_et, container, false);



        todaycases = view.findViewById(R.id.caseNumber);
        totalcases = view.findViewById(R.id.totalcaseNumber);
        recovered = view.findViewById(R.id.totalrecovered);
        countryname =view.findViewById(R.id.countryName);
        deaths = view.findViewById(R.id.deathNumber);
        critical = view.findViewById(R.id.totalcritical);
        activecase = view.findViewById(R.id.totalactivecase);
        // check sharedpreference


        // Fetch all ethiopia case
        fetchdata();




        return  view;
    }

    private void fetchdata()
    {

        // Create a String request
        // using Volley Library
        String url = "https://corona.lmao.ninja/v2/countries/Ethiopia";

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {

                        // Handle the JSON object and
                        // handle it inside try and catch
                        try {

                            // Creating object of JSONObject
                            JSONObject jsonObject= new JSONObject( response.toString());

                            // Set the data in text view
                            // which are available in JSON format
                            todaycases.setText(jsonObject.getString("todayCases"));
                            totalcases.setText(jsonObject.getString( "cases"));
                            recovered.setText(jsonObject.getString("recovered"));
                            countryname.setText(jsonObject.getString("country"));
                            deaths.setText(jsonObject.getString("deaths"));
                            critical.setText(jsonObject.getString("critical"));
                            activecase.setText(jsonObject.getString("active"));


                            // store this value in sharedpreference for another time
                            sharedpreferences_ETcase = getActivity().getSharedPreferences(mypreference,
                                    Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedpreferences_ETcase.edit();
                            editor.putString(TodayCase, todaycases.getText().toString());
                            editor.putString(TotalCase, totalcases.getText().toString());
                            editor.putString(Recovered, recovered.getText().toString());
                            editor.putString(CountryName, countryname.getText().toString());
                            editor.putString(Death, deaths.getText().toString());
                            editor.putString(Critical, critical.getText().toString());
                            editor.putString(ActiveCase, activecase.getText().toString());
                            editor.apply();

                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(getContext(), R.string.no_internet_last_data_loaded, Toast.LENGTH_SHORT).show();
                        LoadFromSharedPreference();
                    }
                });

        RequestQueue requestQueue  = Volley.newRequestQueue(getContext());
        requestQueue.add(request);
    }


    private  void LoadFromSharedPreference(){
        sharedpreferences_ETcase = this.getActivity().getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        if (sharedpreferences_ETcase.contains(TodayCase)) {
            todaycases.setText(sharedpreferences_ETcase.getString(TodayCase, ""));
        }
        if (sharedpreferences_ETcase.contains(TotalCase)) {
            totalcases.setText(sharedpreferences_ETcase.getString(TotalCase, ""));
        }
        if (sharedpreferences_ETcase.contains(Recovered)) {
            recovered.setText(sharedpreferences_ETcase.getString(Recovered, ""));
        }
        if (sharedpreferences_ETcase.contains(CountryName)) {
            countryname.setText(sharedpreferences_ETcase.getString(CountryName, ""));
        }
        if (sharedpreferences_ETcase.contains(Death)) {
            deaths.setText(sharedpreferences_ETcase.getString(Death, ""));
        }

        if (sharedpreferences_ETcase.contains(Critical)) {
            critical.setText(sharedpreferences_ETcase.getString(Critical, ""));
        }

        if (sharedpreferences_ETcase.contains(ActiveCase)) {
            activecase.setText(sharedpreferences_ETcase.getString(ActiveCase, ""));
        }

    }
}