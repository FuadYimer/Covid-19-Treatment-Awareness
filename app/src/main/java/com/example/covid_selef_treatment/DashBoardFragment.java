package com.example.covid_selef_treatment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.covid_selef_treatment.factsaboutcovid.FactsAboutCovid19;
import com.example.covid_selef_treatment.riskassesment.Risk_Assesment;
import com.example.covid_selef_treatment.riskassesment.SyptomCaseThirdFragment;
import com.google.android.material.navigation.NavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashBoardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashBoardFragment extends Fragment implements View.OnClickListener{
    CardView cardView1, preventionaCV, treatmentCV, casesCV, riskassesmetCV, selfcheckerCV, survivalrateCV, factsCV;
    NavigationView navigationView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DashBoardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashBoardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashBoardFragment newInstance(String param1, String param2) {
        DashBoardFragment fragment = new DashBoardFragment();
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
        View view = inflater.inflate(R.layout.fragment_dash_board, container, false);
         navigationView = view.findViewById(R.id.nav_view);

        cardView1 = view.findViewById(R.id.cardview_syptom);
        preventionaCV = view.findViewById(R.id.cardview_prevention);
        treatmentCV = view.findViewById(R.id.cardview_treatment);
        casesCV = view.findViewById(R.id.cardview_cases);
        riskassesmetCV = view.findViewById(R.id.cardview_riskassesment);
        selfcheckerCV = view.findViewById(R.id.cardview_selfchacker);
        survivalrateCV = view.findViewById(R.id.cardview_rurvival);
        factsCV = view.findViewById(R.id.cardview_facts);


        cardView1.setOnClickListener(this);
        preventionaCV.setOnClickListener(this);
        treatmentCV.setOnClickListener(this);
        casesCV.setOnClickListener(this);
        riskassesmetCV.setOnClickListener(this);
        selfcheckerCV.setOnClickListener(this);
        survivalrateCV.setOnClickListener(this);
        factsCV.setOnClickListener(this);
        return  view;
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.cardview_syptom:

               /* getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SymptomFragment()).commit();*/
                Intent intent = new Intent(getActivity(), SyptomActivity.class);
                startActivity(intent);
                break;
            case R.id.cardview_prevention:
                /*getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new PreventionFragment2()).commit();*/
                intent = new Intent(getActivity(), PreventionActivity.class);
                startActivity(intent);
                break;
            case R.id.cardview_treatment:
                 intent = new Intent(getActivity(), TreatmentActivity.class);
                startActivity(intent);
                break;
            case R.id.cardview_cases:
                intent = new Intent(getActivity(), CovidCases.class);
                startActivity(intent);
                break;
            case R.id.cardview_riskassesment:
                intent = new Intent(getActivity(), Risk_Assesment.class);
                startActivity(intent);
                break;
            case R.id.cardview_selfchacker:
                intent = new Intent(getActivity() , SelfChecker.class);
                startActivity(intent);
                break;
            case R.id.cardview_rurvival:
                intent = new Intent(getActivity(), SurvivalRateActivity.class);
                startActivity(intent);
                break;
            case R.id.cardview_facts:
                intent = new Intent(getActivity(), FactsAboutCovid19.class);
                startActivity(intent);
                break;
        }
    }
}