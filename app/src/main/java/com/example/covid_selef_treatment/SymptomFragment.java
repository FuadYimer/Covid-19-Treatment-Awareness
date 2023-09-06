package com.example.covid_selef_treatment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.covid_selef_treatment.factsaboutcovid.FactsDetailActivity;
import com.example.covid_selef_treatment.syptoms.CoughDetailFragment;
import com.example.covid_selef_treatment.syptoms.FatigueDetailFragment;
import com.example.covid_selef_treatment.syptoms.FeverDetailFragment;
import com.example.covid_selef_treatment.syptoms.ShortnessOfBreathFragment;
import com.example.covid_selef_treatment.syptoms.SoreThroadDetailFragment;
import com.example.covid_selef_treatment.syptoms.SyptomDetailHolderActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SymptomFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SymptomFragment extends Fragment implements View.OnClickListener{
    ImageView syptomFever;
    CardView cardview_fever , cardview_cough , cardview_tirdness , cardview_sorethroat, cardview_shortbreath , cardview_vomit, cardview_diharia, cardview_notest;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SymptomFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SymptomFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SymptomFragment newInstance(String param1, String param2) {
        SymptomFragment fragment = new SymptomFragment();
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
        View view = inflater.inflate(R.layout.fragment_symptom, container, false);

        cardview_fever = view.findViewById(R.id.cardview_fever);
        cardview_cough = view.findViewById(R.id.cardview_cough);
        cardview_tirdness = view.findViewById(R.id.cardview_tirdness);
        cardview_sorethroat = view.findViewById(R.id.cardview_sorethroat);
        cardview_shortbreath  = view.findViewById(R.id.cardview_shortbreath);
        cardview_vomit = view.findViewById(R.id.cardview_vomit);
        cardview_diharia = view.findViewById(R.id.cardview_diharia);
        cardview_notest  = view.findViewById(R.id.cardview_notest);


        cardview_fever.setOnClickListener(this);
        cardview_cough.setOnClickListener(this);
        cardview_tirdness.setOnClickListener(this);
        cardview_sorethroat.setOnClickListener(this);
        cardview_shortbreath.setOnClickListener(this);
        cardview_vomit.setOnClickListener(this);
        cardview_diharia.setOnClickListener(this);
        cardview_notest.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cardview_fever:
                Intent intent  = new Intent(getContext() , SyptomDetailHolderActivity.class);
                intent.putExtra("selectedview" ,R.id.cardview_fever);
                startActivity(intent);
              /*  getFragmentManager().beginTransaction().replace(R.id.syptom_detail_container,
                        new FeverDetailFragment()).commit();*/
                break;
            case R.id.cardview_cough:
               intent  = new Intent(getContext() , SyptomDetailHolderActivity.class);
                intent.putExtra("selectedview" ,R.id.cardview_cough);
                startActivity(intent);
                /*getFragmentManager().beginTransaction().replace(R.id.syptom_detail_container,
                        new CoughDetailFragment()).commit();*/
                break;
            case R.id.cardview_tirdness:
                intent  = new Intent(getContext() , SyptomDetailHolderActivity.class);
                intent.putExtra("selectedview" ,R.id.cardview_tirdness);
                startActivity(intent);
                /*getFragmentManager().beginTransaction().replace(R.id.syptom_detail_container,
                        new FatigueDetailFragment()).commit();*/
                break;
            case R.id.cardview_sorethroat:
                intent  = new Intent(getContext() , SyptomDetailHolderActivity.class);
                intent.putExtra("selectedview" ,R.id.cardview_sorethroat);
                startActivity(intent);
                /*getFragmentManager().beginTransaction().replace(R.id.syptom_detail_container,
                        new SoreThroadDetailFragment()).commit();*/
                break;
            case R.id.cardview_shortbreath:
                intent  = new Intent(getContext() , SyptomDetailHolderActivity.class);
                intent.putExtra("selectedview" ,R.id.cardview_shortbreath);
                startActivity(intent);
                /*getFragmentManager().beginTransaction().replace(R.id.syptom_detail_container,
                        new ShortnessOfBreathFragment()).commit();*/
                break;
            case R.id.cardview_vomit:
            case R.id.cardview_diharia:
                Toast.makeText(getContext(), getString(R.string.less_common_symptoms_such_as_rash_nausea_vomiting_and_diarrhea), Toast.LENGTH_LONG).show();
            break;
            case R.id.cardview_notest:
                Toast.makeText(getContext(), R.string.partial_or_complete_loss_of_the_sense_of_smell_sense_of_taste_is_not_functioning_properly, Toast.LENGTH_LONG).show();

        }
    }
}