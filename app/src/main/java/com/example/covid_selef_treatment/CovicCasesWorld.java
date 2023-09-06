package com.example.covid_selef_treatment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CovicCasesWorld extends Fragment {
   /* private TextView mTextViewResult;
    private RequestQueue mQueue;*/
    RecyclerView recyclerView;
    CoronaAdapter mAdapter;
    List<Model> coronaList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.covicd_cases_world, container , false);

      /*  mTextViewResult = view.findViewById(R.id.text_view_result);
        Button buttonParse = view.findViewById(R.id.button_parse);
        mQueue = Volley.newRequestQueue(view.getContext());
        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });
        */

        recyclerView = view.findViewById(R.id.recylerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        coronaList = new ArrayList<>();
        recyclerView.setAdapter(mAdapter);


        apiCall();
        return view;
    }

    private void apiCall() {

        /*final ProgressDialog progressDialog  = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading ....");
        progressDialog.show();
*/
        String URL = "https://corona.lmao.ninja/v2/countries";

        StringRequest request = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONArray jsonObject = new JSONArray(response);

                    for (int i = 0; i< jsonObject.length(); i++) {
                        JSONObject getdata = jsonObject.getJSONObject(i);
                        JSONObject forflag = getdata.getJSONObject("countryInfo");
                        String todaycases = getdata.getString("todayCases");
                        String flag = forflag.getString("flag");
                        String recovered = getdata.getString("recovered");
                        String countryname = getdata.getString("country");
                        String deaths = getdata.getString("deaths");
                        String totalcases = getdata.getString("cases");


                        Model model = new Model(todaycases, totalcases, countryname, flag, recovered, deaths);
                        coronaList.add(model);

                    }
                    mAdapter  = new CoronaAdapter(getContext().getApplicationContext(), coronaList);
                    recyclerView.setAdapter(mAdapter);
                   // progressDialog.dismiss();

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               // progressDialog.dismiss();
                Toast.makeText(getContext(), R.string.error_occured, Toast.LENGTH_SHORT).show();
            }
        });


        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(request);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);//Make sure you have this line of code.
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu, menu);

        MenuItem searchitem = menu.findItem(R.id.search_bar);

        SearchView searchView = (SearchView) searchitem.getActionView();


        searchView.setQueryHint(getString(R.string.search_by_country));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                mAdapter.getFilter().filter(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                mAdapter.getFilter().filter(s);
                return true;
            }
        });


    }




}
