package com.example.covid_selef_treatment.riskassesment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.covid_selef_treatment.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HowHighIsYourFeverFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HowHighIsYourFeverFragment extends Fragment implements View.OnClickListener {
    ArrayList<String> syptomcasefourth = new ArrayList<>();
    RadioButton fever1, fever2, fever3, fever4;
    Button btn_prev, btn_next;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HowHighIsYourFeverFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HowHighIsYourFeverFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HowHighIsYourFeverFragment newInstance(String param1, String param2) {
        HowHighIsYourFeverFragment fragment = new HowHighIsYourFeverFragment();
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
        View view = inflater.inflate(R.layout.fragment_how_high_is_your_fever, container, false);
        fever1 = view.findViewById(R.id.fever_1);
        fever2 = view.findViewById(R.id.fever_2);
        fever3 = view.findViewById(R.id.fever_3);
        fever4 = view.findViewById(R.id.fever_4);

        btn_next  = view.findViewById(R.id.next);
        btn_prev = view.findViewById(R.id.previous);

        btn_next.setOnClickListener(this);
        btn_prev.setOnClickListener(this);
        return  view;
    }

    @Override
    public void onClick(View view) {
        String fiver = null;
        switch (view.getId()){
            case R.id.next:
                if (fever1.isChecked()){
                    fiver ="between 37.5°C and 38°C (99.5°F and 100.4°F)";
                }
               else if (fever2.isChecked()){
                    fiver ="between 38°C and 40°C (100.4°F and 104°F)";

                }
                else if (fever3.isChecked()){
                    fiver ="over 40°C (104°F)";
                }
                else if (fever4.isChecked()){
                    fiver ="I haven’t taken my temperature";

                }
                // Add
                Bundle bundle = this.getArguments();
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putString("How_high_your_fever", fiver);
                SyptomRapidlyWorseningFragment syptomRapidlyWorseningFragment  = new SyptomRapidlyWorseningFragment();
                syptomRapidlyWorseningFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.assesment_container, syptomRapidlyWorseningFragment).commit();
                break;
            case R.id.previous:
                SyptomCaseThirdFragment fragmentprevious  = new SyptomCaseThirdFragment();
                getFragmentManager().beginTransaction().replace(R.id.assesment_container, fragmentprevious).commit();
                break;
        }

    }
}