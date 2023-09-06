package com.example.covid_selef_treatment.riskassesment;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covid_selef_treatment.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SyptomCaseFirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SyptomCaseFirstFragment extends Fragment implements View.OnClickListener {
    ImageButton immunesystemdetail, obesitydetail;
    Button btn_next, btn_prev;
    CheckBox syptom1,syptom2, syptom3, syptom4;
    private AlertDialog.Builder dialogbuilder;
    private AlertDialog dialog;

    ArrayList<String> syptomcasefirst = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SyptomCaseFirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SyptomCaseFirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SyptomCaseFirstFragment newInstance(String param1, String param2) {
        SyptomCaseFirstFragment fragment = new SyptomCaseFirstFragment();
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
        View view =  inflater.inflate(R.layout.fragment_syptom_case_first, container, false);
        immunesystemdetail = view.findViewById(R.id.immunesystemdetail);
        obesitydetail  = view.findViewById(R.id.obesitydetail);

        btn_next  = view.findViewById(R.id.next);
        btn_prev  = view.findViewById(R.id.previous);
        btn_next.setOnClickListener(this);
        btn_prev.setOnClickListener(this);

        immunesystemdetail.setOnClickListener(this);
        obesitydetail.setOnClickListener(this);

        // check list,
        syptom1  = view.findViewById(R.id.syptom_1);
        syptom2  = view.findViewById(R.id.syptom_2);
        syptom3  = view.findViewById(R.id.syptom_3);
        syptom4  = view.findViewById(R.id.syptom_4);

        return  view;
    }

    @Override
    public void onClick(View view) {
        Bundle bundle = this.getArguments();
        switch (view.getId()){
            case R.id.immunesystemdetail:
                CreateContactDialog("immunesystem");
                break;
            case R.id.obesitydetail:
                CreateContactDialog("obesity");
                break;
            case R.id.next:
                if (syptom1.isChecked()){
                    syptomcasefirst.add("Active Cancer");
                }
                if (syptom2.isChecked()){
                    syptomcasefirst.add("Weaken Immune System");
                }
                if (syptom3.isChecked()){
                    syptomcasefirst.add("Obesity");
                }
                if (syptom4.isChecked()){
                    syptomcasefirst.add("Long term stay");
                }
                // Add
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putSerializable("firstcases", syptomcasefirst);
                SyptomCaseSecondFragment syptomcase2  = new SyptomCaseSecondFragment();
                syptomcase2.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.assesment_container, syptomcase2).commit();
                break;
            case R.id.previous:
                PatientStatusAgeFragment fragmentprevious  = new PatientStatusAgeFragment();
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

        if (name.equals("immunesystem")){
            dialogTitle.setText(R.string.diseases_or_drugs_that_weaken_immune_system);
            dialogDetail.setText(R.string.diseases_or_drugs_that_weaken_immune_system_detail);
            dialogbuilder.setView(view);
            dialog = dialogbuilder.create();
            dialog.show();
        }
        if(name.equals("obesity")){
            dialogTitle.setText(R.string.obesity);
            dialogDetail.setText(R.string.obesity_detail_java);
            dialogbuilder.setView(view);
            dialogbuilder.setView(view);
            dialog = dialogbuilder.create();
            dialog.show();
        }

    }
}