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

import com.example.covid_selef_treatment.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SyptomCaseSecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SyptomCaseSecondFragment extends Fragment implements View.OnClickListener {
    Button btn_next, btn_prev;
    CheckBox syptom1,syptom2, syptom3, syptom4, syptom5;
    TextView textView;
    ImageButton cardiodetail , lungdiseasedetail, liverdiseasedetail, kidneydetail;

    ArrayList<String> syptomcasesecond = new ArrayList<>();

    private AlertDialog.Builder dialogbuilder;
    private AlertDialog dialog;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SyptomCaseSecondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SyptomCaseSecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SyptomCaseSecondFragment newInstance(String param1, String param2) {
        SyptomCaseSecondFragment fragment = new SyptomCaseSecondFragment();
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
        View view = inflater.inflate(R.layout.fragment_syptom_case_second, container, false);
        btn_next = view.findViewById(R.id.next);
        btn_prev = view.findViewById(R.id.previous);

        // check list,
        syptom1  = view.findViewById(R.id.syptom_1);
        syptom2  = view.findViewById(R.id.syptom_2);
        syptom3  = view.findViewById(R.id.syptom_3);
        syptom4  = view.findViewById(R.id.syptom_4);
        syptom5  = view.findViewById(R.id.syptom_5);

        // checklist
        cardiodetail = view.findViewById(R.id.cardiodetail);
        lungdiseasedetail = view.findViewById(R.id.lungdiseasedetail);
        liverdiseasedetail = view.findViewById(R.id.chronicliverdetail);
        kidneydetail = view.findViewById(R.id.chronickidneydetail);


        btn_prev.setOnClickListener(this);
        btn_next.setOnClickListener(this);
        //textView = view.findViewById(R.id.check);


        cardiodetail.setOnClickListener(this);
        lungdiseasedetail.setOnClickListener(this);
        liverdiseasedetail.setOnClickListener(this);
        kidneydetail.setOnClickListener(this);

        //ArrayList<String> syptomlist = (ArrayList<String>) bundle.getSerializable("firstcases");

        //textView.setText(String.valueOf(syptomlist) +"\n" + bundle.getString("Sex") + "\n" + bundle.getString("Age"));
        return  view;
    }

    @Override
    public void onClick(View view) {
        Bundle bundle = this.getArguments();
        switch (view.getId()){
            case R.id.cardiodetail:
                CreateContactDialog("cardiodetail");
                break;
            case R.id.lungdiseasedetail:
                CreateContactDialog("lungdiseasedetail");
                break;
            case R.id.chronicliverdetail:
                CreateContactDialog("chronicliverdetail");
                break;
            case R.id.chronickidneydetail:
                CreateContactDialog("chronickidneydetail");
                break;
            case R.id.next:
                if (syptom1.isChecked()){
                    syptomcasesecond.add("Diabetes");
                }
                if (syptom2.isChecked()){
                    syptomcasesecond.add("Cardiovascular disease");
                }
                if (syptom3.isChecked()){
                    syptomcasesecond.add("lung disease");
                }
                if (syptom4.isChecked()){
                    syptomcasesecond.add("liver disease");
                }
                if (syptom5.isChecked()){
                    syptomcasesecond.add("kidney disease");
                }
                // Add
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putSerializable("secondcases", syptomcasesecond);
                SyptomCaseThirdFragment syptomcase3  = new SyptomCaseThirdFragment();
                syptomcase3.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.assesment_container, syptomcase3).commit();
                break;
            case R.id.previous:
                SyptomCaseFirstFragment fragmentprevious  = new SyptomCaseFirstFragment();
                getFragmentManager().beginTransaction().replace(R.id.assesment_container, fragmentprevious).commit();
                break;
        }

    }

    public void CreateContactDialog(String name) {
        TextView dialogTitle, dialogDetail;

        dialogbuilder = new AlertDialog.Builder(getContext());
        final View view = getLayoutInflater().inflate(R.layout.show_detail_dialog, null);
        dialogTitle = view.findViewById(R.id.dialog_title);
        dialogDetail = view.findViewById(R.id.dialog_detail);

        switch (name) {
            case "cardiodetail":
                dialogTitle.setText(R.string.cardiovascular_disease);
                dialogDetail.setText(R.string.cardiovascular_disease_detail);
                dialogbuilder.setView(view);
                dialog = dialogbuilder.create();
                dialog.show();
                break;
            case "lungdiseasedetail": {
                dialogTitle.setText(R.string.history_of_chronic_lung_disease);
                dialogDetail.setText(R.string.history_of_chronic_lung_disease_detail);
                dialogbuilder.setView(view);
                dialog = dialogbuilder.create();
                dialog.show();
                break;
            }
            case "chronicliverdetail": {
                dialogTitle.setText(R.string.history_of_chronic_liver_disease);
                dialogDetail.setText(R.string.history_of_chronic_liver_disease_detail);
                dialogbuilder.setView(view);
                dialog = dialogbuilder.create();
                dialog.show();
                break;
            }
            case "chronickidneydetail": {
                dialogTitle.setText(R.string.history_of_chronic_kidney_disease);
                dialogDetail.setText(R.string.history_of_chronic_kidney_disease_detail);
                dialogbuilder.setView(view);
                dialog = dialogbuilder.create();
                dialog.show();
                break;
            }
        }


    }
}