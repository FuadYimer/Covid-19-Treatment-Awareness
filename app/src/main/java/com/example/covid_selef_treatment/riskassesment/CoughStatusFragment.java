package com.example.covid_selef_treatment.riskassesment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.covid_selef_treatment.LoadingDialog;
import com.example.covid_selef_treatment.R;
import com.example.covid_selef_treatment.TreatmentActivity;
import com.example.covid_selef_treatment.activity_main;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CoughStatusFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CoughStatusFragment extends Fragment implements View.OnClickListener {
    Button btn_previous, btn_next;
    ImageButton imgbtn_yes, imgbtn_no;

    public Bundle bundle;
    ProgressDialog progressDoalog;

    LoadingDialog loadingDialog ;
    private AlertDialog dialog;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CoughStatusFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CoughStatusFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CoughStatusFragment newInstance(String param1, String param2) {
        CoughStatusFragment fragment = new CoughStatusFragment();
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
        View view = inflater.inflate(R.layout.fragment_cough_status, container, false);

        // initialize load dialog class
        loadingDialog = new LoadingDialog(getActivity());

        btn_previous = view.findViewById(R.id.previous);
        btn_next = view.findViewById(R.id.next);
        imgbtn_yes = view.findViewById(R.id.coughYes);
        imgbtn_no = view.findViewById(R.id.CoughNo);


        btn_previous.setOnClickListener(this);
        imgbtn_yes.setOnClickListener(this);
        imgbtn_no.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {

         bundle = this.getArguments();
        switch (view.getId()) {

            case R.id.previous:
                BreathingStatusFragment fragment = new BreathingStatusFragment();
                getFragmentManager().beginTransaction().replace(R.id.assesment_container, fragment).commit();
                break;
            case R.id.coughYes:
                //showprogressbar();
                bundle.putString("coughing_up_blood", "Yes");
                showprogressbarAndOpenFragment();
                break;
            case R.id.CoughNo:
                bundle.putString("coughing_up_blood", "No");
                String symptoms_rapidly_worsening = bundle.getString("symptoms_rapidly_worsening");
                String breathing_very_fast = bundle.getString("breathing_very_fast");
                if (symptoms_rapidly_worsening.equals("No") && breathing_very_fast.equals("No")) {
                    CheckSyptomFragment checkSyptomFragment = new CheckSyptomFragment();
                    checkSyptomFragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.assesment_container, checkSyptomFragment).commit();
                } else {
                    //showprogressbar();
                    showprogressbarAndOpenFragment();
                }

                break;
        }
    }

    private void showprogressbarAndOpenFragment() {
        /*progressDoalog = new ProgressDialog(getActivity());
        progressDoalog.setMessage(getString(R.string.wait_while_loading));
        progressDoalog.setTitle(getString(R.string.analyzing_your_symptoms));
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDoalog.setIndeterminate(true);
        progressDoalog.show();*/

        loadingDialog.setLoadingDialog();
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                RecommendationFragment recommendationFragment = new RecommendationFragment();
                recommendationFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.assesment_container, recommendationFragment).commit();
                loadingDialog.dismissDialog();
            }

        }.start();

    }
}