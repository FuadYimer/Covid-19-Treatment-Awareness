package com.example.covid_selef_treatment.riskassesment;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.covid_selef_treatment.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BreathingStatusFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BreathingStatusFragment extends Fragment implements View.OnClickListener{
    Button btn_previous , btn_next;
    ImageButton imgbtn_yes, imgbtn_no , fastBreathDetail;

    private AlertDialog.Builder dialogbuilder;
    private AlertDialog dialog;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BreathingStatusFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BreathingStatusFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BreathingStatusFragment newInstance(String param1, String param2) {
        BreathingStatusFragment fragment = new BreathingStatusFragment();
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
        View view = inflater.inflate(R.layout.fragment_breathing_status, container, false);
        btn_previous = view.findViewById(R.id.previous);
        btn_next = view.findViewById(R.id.next);
        imgbtn_yes  = view.findViewById(R.id.breath_yes);
        imgbtn_no = view.findViewById(R.id.breath_no);

        fastBreathDetail = view.findViewById(R.id.breathveryfastdetail);
        fastBreathDetail.setOnClickListener(this);

        btn_previous.setOnClickListener(this);
        imgbtn_yes.setOnClickListener(this);
        imgbtn_no.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        CoughStatusFragment coughStatusFragment  = new CoughStatusFragment();
        Bundle bundle = this.getArguments();
        switch (view.getId()){

            case R.id.previous:
                SyptomRapidlyWorseningFragment fragment  = new SyptomRapidlyWorseningFragment();
                getFragmentManager().beginTransaction().replace(R.id.assesment_container, fragment).commit();
                break;
            case  R.id.breath_yes:
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putString("breathing_very_fast", "Yes");
                coughStatusFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.assesment_container, coughStatusFragment).commit();
                break;
            case R.id.breath_no:
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putString("breathing_very_fast", "No");
                coughStatusFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.assesment_container, coughStatusFragment).commit();
                break;
            case R.id.breathveryfastdetail:
                CreateContactDialog("breathveryfastdetail");
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

        if (name.equals("breathveryfastdetail")){
            dialogTitle.setText(R.string.rapid_breathing);
            dialogDetail.setText(R.string.rapid_breathing_detail);
            dialogbuilder.setView(view);
            dialog = dialogbuilder.create();
            dialog.show();
        }


    }

}