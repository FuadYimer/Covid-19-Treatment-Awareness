package com.example.covid_selef_treatment.riskassesment;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covid_selef_treatment.LoadingDialog;
import com.example.covid_selef_treatment.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CloseContactWithCOVIDFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CloseContactWithCOVIDFragment extends Fragment implements View.OnClickListener {
    Button btn_previous, btn_next;

    ArrayList<String> Closecontactwithcovid = new ArrayList<>();
    RadioButton contacttype1, contacttype2, contacttype3, contacttype4, contacttype5;
    ProgressDialog progressDoalog;
    RadioGroup contacttype;

    ImageButton contacttypedetail;
    private AlertDialog.Builder dialogbuilder;
    private AlertDialog dialog;

    public Bundle bundle;

    LoadingDialog loadingDialog ;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CloseContactWithCOVIDFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CloseContactWithCOVIDFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CloseContactWithCOVIDFragment newInstance(String param1, String param2) {
        CloseContactWithCOVIDFragment fragment = new CloseContactWithCOVIDFragment();
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
        bundle = this.getArguments();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_close_contact_with_c_o_v_i_d, container, false);

        // initialize load dialog class
        loadingDialog = new LoadingDialog(getActivity());


        btn_next = view.findViewById(R.id.next);
        btn_previous = view.findViewById(R.id.previous);

        btn_next.setOnClickListener(this);
        btn_previous.setOnClickListener(this);

        contacttypedetail = view.findViewById(R.id.contacttypedetail);
        contacttypedetail.setOnClickListener(this);

        contacttype = view.findViewById(R.id.contacttype);

        contacttype.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                btn_next.setEnabled(true);
            }
        });

        contacttype1 = view.findViewById(R.id.contactresponce_1);
        contacttype2 = view.findViewById(R.id.contactresponce_2);
        contacttype3 = view.findViewById(R.id.contactresponce_3);
        contacttype4 = view.findViewById(R.id.contactresponce_4);
        contacttype5 = view.findViewById(R.id.contactresponce_5);
        return view;
    }

    @Override
    public void onClick(View view) {
        String contacttype = null;
        switch (view.getId()) {

            case R.id.next:
                if (contacttype1.isChecked()) {
                    contacttype = "ContactType_1";
                } else if (contacttype2.isChecked()) {
                    contacttype = "ContactType_2";
                }
                if (contacttype3.isChecked()) {
                    contacttype = "ContactType_3";
                }
                if (contacttype4.isChecked()) {
                    contacttype = "ContactType_4";
                }
                if (contacttype5.isChecked()) {
                    contacttype = "ContactType_5";
                }
                bundle.putString("CloseContactWithCovid", contacttype);
                showprogressbarAndOpenFragment();


                break;
            case R.id.previous:
                CheckSyptomFragment fragmentprevious = new CheckSyptomFragment();
                getFragmentManager().beginTransaction().replace(R.id.assesment_container, fragmentprevious).commit();
                break;
            /*case R.id.contacttype:
                Toast.makeText(getContext(), "RadioButton clicked", Toast.LENGTH_SHORT).show();
                if (contacttype1.isChecked() || contacttype2.isChecked() || contacttype3.isChecked()|| contacttype4.isChecked() || contacttype5.isChecked()){
                    btn_next.setEnabled(true);
                }
                break;*/
            case R.id.contacttypedetail:
                CreateContactDialog("contacttypedetail");
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

        if (name.equals("contacttypedetail")) {
            dialogTitle.setText(R.string.person_with_confirmed_or_probable_covid_19);
            dialogDetail.setText(R.string.person_with_confirmed_or_probable_covid_19_detail);
            dialogbuilder.setView(view);
            dialog = dialogbuilder.create();
            dialog.show();
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
                    Thread.sleep(3000);
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