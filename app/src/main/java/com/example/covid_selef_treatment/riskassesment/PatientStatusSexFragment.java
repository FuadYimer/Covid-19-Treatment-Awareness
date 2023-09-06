package com.example.covid_selef_treatment.riskassesment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.covid_selef_treatment.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PatientStatusSexFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PatientStatusSexFragment extends Fragment implements View.OnClickListener {
    ImageButton btn_male , btn_female;
    Button btn_back;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PatientStatusSexFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PatientStatusFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PatientStatusSexFragment newInstance(String param1, String param2) {
        PatientStatusSexFragment fragment = new PatientStatusSexFragment();
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
        View view =  inflater.inflate(R.layout.fragment_patient_status_sex, container, false);
        btn_back = view.findViewById(R.id.previous);
        btn_male  = view.findViewById(R.id.male);
        btn_female = view.findViewById(R.id.female);

        btn_back.setOnClickListener(this);
        btn_male.setOnClickListener(this);
        btn_female.setOnClickListener(this);
        return  view;

    }

    @Override
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        PatientStatusAgeFragment patientStatusAgeFragment  = new PatientStatusAgeFragment();
        switch (view.getId()){
            case R.id.previous:
                AgreementFragment fragment  = new AgreementFragment();
                getFragmentManager().beginTransaction().replace(R.id.assesment_container, fragment).commit();
                break;
            case  R.id.male:
                bundle.putString("Sex", "Male");
                patientStatusAgeFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.assesment_container, patientStatusAgeFragment).commit();
                break;
            case R.id.female:
                bundle.putString("Sex", "Female");
                patientStatusAgeFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.assesment_container, patientStatusAgeFragment).commit();
                break;
        }

    }
}