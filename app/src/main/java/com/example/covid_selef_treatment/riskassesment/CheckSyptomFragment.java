package com.example.covid_selef_treatment.riskassesment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

import com.example.covid_selef_treatment.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CheckSyptomFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CheckSyptomFragment extends Fragment implements View.OnClickListener{
    ArrayList<String> othersyptom = new ArrayList<>();
    CheckBox syptom_1, syptom_2, syptom_3, syptom_4, syptom_5, syptom_6, syptom_7, syptom_8;
    Button btn_previous, btn_next;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CheckSyptomFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CheckSyptomFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CheckSyptomFragment newInstance(String param1, String param2) {
        CheckSyptomFragment fragment = new CheckSyptomFragment();
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
        View view =  inflater.inflate(R.layout.fragment_check_syptom, container, false);
        syptom_1 = view.findViewById(R.id.fatigue);
        syptom_2 = view.findViewById(R.id.musclepain);
        syptom_3 = view.findViewById(R.id.chills);
        syptom_4 = view.findViewById(R.id.headache);
        syptom_5 = view.findViewById(R.id.diarrhea);
        syptom_6 = view.findViewById(R.id.nauseas);
        syptom_7 = view.findViewById(R.id.sorethroat);
        syptom_8 = view.findViewById(R.id.impairedtest);

        btn_next = view.findViewById(R.id.next);
        btn_previous = view.findViewById(R.id.previous);


        btn_next.setOnClickListener(this);
        btn_previous.setOnClickListener(this);
        return  view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.next:
                if (syptom_1.isChecked()){
                    othersyptom.add("Fatigue");
                }
                if (syptom_4.isChecked()){
                    othersyptom.add("Muscle pain");
                }
                if (syptom_3.isChecked()){
                    othersyptom.add("Chills");
                }
                if (syptom_4.isChecked()){
                    othersyptom.add("Headache");
                }
                if (syptom_5.isChecked()){
                    othersyptom.add("Diarrhea");
                }
                if (syptom_6.isChecked()){
                    othersyptom.add("Nausea");
                }
                if (syptom_7.isChecked()){
                    othersyptom.add("Sore throat");
                }
                if (syptom_8.isChecked()){
                    othersyptom.add("Impaired taste or smell");
                }

                // Add
                Bundle bundle = this.getArguments();
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putSerializable("OtherSyptom", othersyptom);
                CloseContactWithCOVIDFragment closeContactWithCOVIDFragment  = new CloseContactWithCOVIDFragment();
                closeContactWithCOVIDFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.assesment_container, closeContactWithCOVIDFragment).commit();
                break;
            case R.id.previous:
                SyptomCaseThirdFragment fragmentprevious  = new SyptomCaseThirdFragment();
                getFragmentManager().beginTransaction().replace(R.id.assesment_container, fragmentprevious).commit();
                break;
        }


    }
}