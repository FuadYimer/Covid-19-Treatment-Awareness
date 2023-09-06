package com.example.covid_selef_treatment.riskassesment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.covid_selef_treatment.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AgreementFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AgreementFragment extends Fragment implements View.OnClickListener {
    Button btn_next;
    CheckBox checkBox_agreement;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AgreementFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AgreementFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AgreementFragment newInstance(String param1, String param2) {
        AgreementFragment fragment = new AgreementFragment();
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
        View view = inflater.inflate(R.layout.fragment_agreement, container, false);
        btn_next = view.findViewById(R.id.next);
        checkBox_agreement = view.findViewById(R.id.agreement_checkbox);


        checkBox_agreement.setOnClickListener(this);
        btn_next.setOnClickListener(this);

        return view;


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.agreement_checkbox:
                if (checkBox_agreement.isChecked()) {
                    btn_next.setEnabled(true);
                } else {
                    btn_next.setEnabled(false);
                }

                break;
            case R.id.next:
                PatientStatusSexFragment fragment = new PatientStatusSexFragment();
                getFragmentManager().beginTransaction().replace(R.id.assesment_container, fragment).commit();
        }

    }
}