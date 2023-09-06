package com.example.covid_selef_treatment.riskassesment;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covid_selef_treatment.R;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SyptomCaseThirdFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SyptomCaseThirdFragment extends Fragment implements View.OnClickListener {

    TextView textView;
    ArrayList<String> syptomcaseThird = new ArrayList<>();
    RadioButton fever, cough, breathing;
    Button btn_previous, btn_next;

    ImageButton fiverDetail, ShrotnessofBreathDetail;

    private AlertDialog.Builder dialogbuilder;
    private AlertDialog dialog;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SyptomCaseThirdFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SyptomCaseThirdFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SyptomCaseThirdFragment newInstance(String param1, String param2) {
        SyptomCaseThirdFragment fragment = new SyptomCaseThirdFragment();
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
        View view = inflater.inflate(R.layout.fragment_syptom_case_third, container, false);
        // check all fragment parameters are here

        /*if(!syptomcaseThird.isEmpty()){
            syptomcaseThird.clear();
        }*/

        btn_next = view.findViewById(R.id.next);
        btn_previous = view.findViewById(R.id.previous);

        btn_previous.setOnClickListener(this);
        btn_next.setOnClickListener(this);

        fever = view.findViewById(R.id.fever_yes);
        cough = view.findViewById(R.id.cough_yes);
        breathing = view.findViewById(R.id.breath_yes);

        // detail image
        fiverDetail = view.findViewById(R.id.feverdetail);
        ShrotnessofBreathDetail = view.findViewById(R.id.breathdetail);

        fiverDetail.setOnClickListener(this);
        ShrotnessofBreathDetail.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
       Boolean feveryes = false;

        Bundle bundle = this.getArguments();
        switch (view.getId()) {
            case R.id.feverdetail:
                CreateContactDialog("feverdetail");
                break;
            case R.id.breathdetail:
                CreateContactDialog("breathdetail");
                break;
            case R.id.next:

                // remove previous when navigate back


                if (fever.isChecked() || cough.isChecked() || breathing.isChecked()) {
                    if (fever.isChecked()) {
                        syptomcaseThird.add("Fever_Yes");
                        feveryes = true;
                    }else{
                        syptomcaseThird.add("Fever_No");
                    }
                    if (cough.isChecked()) {
                        syptomcaseThird.add("Cough_Yes");
                    }else {
                        syptomcaseThird.add("Cough_No");
                    }
                    if (breathing.isChecked()) {
                        syptomcaseThird.add("Shortness_of_breath_Yes");
                    }else{
                        syptomcaseThird.add("Shortness_of_breath_No");
                    }


                    if (bundle == null) {
                        bundle = new Bundle();
                    }
                    bundle.putSerializable("symptoms", syptomcaseThird);

                    if (feveryes){
                        HowHighIsYourFeverFragment howHighIsYourFeverFragment = new HowHighIsYourFeverFragment();
                        howHighIsYourFeverFragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.assesment_container, howHighIsYourFeverFragment).commit();
                    }
                    else{
                        SyptomRapidlyWorseningFragment syptomRapidlyWorseningFragment  = new SyptomRapidlyWorseningFragment();
                        syptomRapidlyWorseningFragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.assesment_container, syptomRapidlyWorseningFragment).commit();
                    }

                } else {
                    syptomcaseThird.add("Fever_No");
                    syptomcaseThird.add("Cough_No");
                    syptomcaseThird.add("Shortness_of_breath_No");

                    if (bundle == null) {
                        bundle = new Bundle();
                    }
                    bundle.putSerializable("symptoms", syptomcaseThird);

                    CheckSyptomFragment checkSyptomFragment = new CheckSyptomFragment();
                    checkSyptomFragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.assesment_container, checkSyptomFragment).commit();
                }

                break;
            case R.id.previous:
                SyptomCaseSecondFragment fragmentprevious = new SyptomCaseSecondFragment();
                getFragmentManager().beginTransaction().replace(R.id.assesment_container, fragmentprevious).commit();
                break;
        }
    }


    public void CreateContactDialog(String name) {
        dialogbuilder = new AlertDialog.Builder(getContext());
        TextView dialogTitle, dialogDetail;

        dialogbuilder = new AlertDialog.Builder(getContext());
        final View view = getLayoutInflater().inflate(R.layout.show_detail_dialog, null);
        dialogTitle = view.findViewById(R.id.dialog_title);
        dialogDetail = view.findViewById(R.id.dialog_detail);

        if (name.equals("feverdetail")){
            dialogTitle.setText(R.string.fever);
            dialogDetail.setText(R.string.fever_detail);
            dialogbuilder.setView(view);
            dialog = dialogbuilder.create();
            dialog.show();
        }
        if(name.equals("breathdetail")){
            dialogTitle.setText(R.string.shortness_of_breath);
            dialogDetail.setText(R.string.shortness_of_breath_detail);
            dialogbuilder.setView(view);
            dialogbuilder.setView(view);
            dialog = dialogbuilder.create();
            dialog.show();
        }

    }
}