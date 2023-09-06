package com.example.covid_selef_treatment.riskassesment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covid_selef_treatment.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PatientStatusAgeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PatientStatusAgeFragment extends Fragment implements View.OnClickListener{

    Button btn_previous , btn_next;
    TextView textView_age;
    SeekBar seekBar_age;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PatientStatusAgeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PatientStatusAgeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PatientStatusAgeFragment newInstance(String param1, String param2) {
        PatientStatusAgeFragment fragment = new PatientStatusAgeFragment();
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
        View view  = inflater.inflate(R.layout.fragment_patient_status_age, container, false);

        textView_age = view.findViewById(R.id.age_status);
        btn_previous = view.findViewById(R.id.previous);
        btn_next = view.findViewById(R.id.next);
        seekBar_age = view.findViewById(R.id.age_snackbar);
        btn_previous.setOnClickListener(this);
        btn_next.setOnClickListener(this);

        seekBar_age.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView_age.setText(i+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return view;
    }
    @Override
    public void onClick(View view) {
        PatientStatusSexFragment fragmentprevious  = new PatientStatusSexFragment();
        SyptomCaseFirstFragment syptomcase1 = new SyptomCaseFirstFragment();
        Bundle bundle = this.getArguments();
        switch (view.getId()){
            case R.id.previous:
                getFragmentManager().beginTransaction().replace(R.id.assesment_container, fragmentprevious).commit();
                break;
            case R.id.next:
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putString("Age", textView_age.getText().toString());
                syptomcase1.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.assesment_container, syptomcase1).commit();
                break;
        }
    }
}