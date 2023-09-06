package com.example.covid_selef_treatment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PreventionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PreventionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView textView, textView2 , textView3 , textView4, textView5  , textView6 , textView7;
    String htmlString;

    ImageButton imageButton;
    LinearLayout linearLayout;

    ImageButton imageButton2;
    LinearLayout linearLayout2;


    ImageButton imageButton3;
    LinearLayout linearLayout3;

    ImageButton imageButton4;
    LinearLayout linearLayout4;

    ImageButton imageButton5;
    LinearLayout linearLayout5;

    ImageButton imageButton6;
    LinearLayout linearLayout6;

    ImageButton imageButton7;
    LinearLayout linearLayout7;

    public PreventionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PreventionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PreventionFragment newInstance(String param1, String param2) {
        PreventionFragment fragment = new PreventionFragment();
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
        View view = inflater.inflate(R.layout.fragment_prevention, container, false);

        // Dear fuad optimize the code here
        imageButton = view.findViewById(R.id.btn_showhide);
        linearLayout  = view.findViewById(R.id.layout_detail);
        linearLayout.setVisibility(View.GONE);
        imageButton.setBackgroundResource(R.drawable.display_block);
        textView = view.findViewById(R.id.detail_1);


        imageButton2 = view.findViewById(R.id.btn_showhide2);
        linearLayout2  = view.findViewById(R.id.layout_detail2);
        linearLayout2.setVisibility(View.GONE);
        imageButton2.setBackgroundResource(R.drawable.display_block);
        textView2 = view.findViewById(R.id.detail_2);


        imageButton3 = view.findViewById(R.id.btn_showhide3);
        linearLayout3  = view.findViewById(R.id.layout_detail3);
        linearLayout3.setVisibility(View.GONE);
        imageButton3.setBackgroundResource(R.drawable.display_block);
        textView3 = view.findViewById(R.id.detail_3);

        imageButton4 = view.findViewById(R.id.btn_showhide4);
        linearLayout4  = view.findViewById(R.id.layout_detail4);
        linearLayout4.setVisibility(View.GONE);
        imageButton4.setBackgroundResource(R.drawable.display_block);
        textView4 = view.findViewById(R.id.detail_4);


        imageButton5 = view.findViewById(R.id.btn_showhide5);
        linearLayout5  = view.findViewById(R.id.layout_detail5);
        linearLayout5.setVisibility(View.GONE);
        imageButton5.setBackgroundResource(R.drawable.display_block);
        textView5 = view.findViewById(R.id.detail_5);

        imageButton6 = view.findViewById(R.id.btn_showhide6);
        linearLayout6  = view.findViewById(R.id.layout_detail6);
        linearLayout6.setVisibility(View.GONE);
        imageButton6.setBackgroundResource(R.drawable.display_block);
        textView6 = view.findViewById(R.id.detail_6);

        imageButton7 = view.findViewById(R.id.btn_showhide7);
        linearLayout7  = view.findViewById(R.id.layout_detail7);
        linearLayout7.setVisibility(View.GONE);
        imageButton7.setBackgroundResource(R.drawable.display_block);
        textView7 = view.findViewById(R.id.detail_7);


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 htmlString  =  "<ul>\n" +
                        "    ♦ The virus is thought to spread mainly from person-to-person. <br/>" +
                        "    ♦ Between people who are in close contact with one another (within about 6 feet). <br/>" +
                        "    ♦ Through respiratory droplets produced when an infected person coughs, sneezes or talks. <br/>" +
                        "    ♦ These droplets can land in the mouths or noses of people who are nearby or possibly be inhaled into the lungs.<br/>" +
                        "    ♦ Some recent studies have suggested that COVID-19 may be spread by people who are not showing symptoms.<br/>" +
                        "</ul>" ;

                if(linearLayout.getVisibility()==View.GONE)
                {
                    textView.setText(Html.fromHtml(htmlString));
                    linearLayout.setVisibility(View.VISIBLE);
                    imageButton.setBackgroundResource(R.drawable.hide_block);

                }
                else {
                    linearLayout.setVisibility(View.GONE);
                    imageButton.setBackgroundResource(R.drawable.display_block);
                }
                //show.setVisibility(View.INVISIBLE);

            }
        });

        // New card view
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                htmlString  =  "<ul>\n" +
                        "    ♦ The virus is thought to spread mainly from person-to-person.<br/>" +
                        "    ♦ Between people who are in close contact with one another (within about 6 feet).<br/>"+
                        "    ♦ Through respiratory droplets produced when an infected person coughs, sneezes or talks.<br/>"+
                        "    ♦ These droplets can land in the mouths or noses of people who are nearby or possibly be inhaled into the lungs.<br/>"+
                        "    ♦ Some recent studies have suggested that COVID-19 may be spread by people who are not showing symptoms.<br/>"+
                        "</ul>" ;
                if(linearLayout2.getVisibility()==View.GONE)
                {
                    textView2.setText(Html.fromHtml(htmlString));
                    linearLayout2.setVisibility(View.VISIBLE);
                    imageButton2.setBackgroundResource(R.drawable.hide_block);

                }
                else {
                    linearLayout2.setVisibility(View.GONE);
                    imageButton2.setBackgroundResource(R.drawable.display_block);
                }
                //show.setVisibility(View.INVISIBLE);

            }
        });


        // New Card View
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                htmlString  =  "<ul>\n" +
                        "    ♦ Inside your home: Avoid close contact with people who are sick. <br/>  \t √ If possible, maintain 6 feet between the person who is sick and other household members.<br/>" +
                        "    ♦ Outsid your home: Put 6 feet of distance between yourself and people who don’t live in your household.<br/> \t √ Remember that some people without symptoms may be able to spread virus. <br/> " +
                        "Stay at least 6 feet (about 2 ars’ length) from other people. <br/> \t √ Keeping distance from others is especially important for people who are at higher risk of getting very sick<br/>"+
                        "</ul>" ;

                if(linearLayout3.getVisibility()==View.GONE)
                {
                    textView3.setText(Html.fromHtml(htmlString));
                    linearLayout3.setVisibility(View.VISIBLE);
                    imageButton3.setBackgroundResource(R.drawable.hide_block);

                }
                else {
                    linearLayout3.setVisibility(View.GONE);
                    imageButton3.setBackgroundResource(R.drawable.display_block);
                }
                //show.setVisibility(View.INVISIBLE);

            }
        });


    // New Card View
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                htmlString  =  "<ul>\n" +
                        "    ♦ You could spread COVID-19 to others even if you do not feel sick.<br/> \t √ The mask is meant to protect other people in case you are infected.<br/>" +
                        "    ♦ Everyone should wear a mask in public settings and when around people who don’t live in your household, especially when other social distancing measures are difficult to maintain.<br/>"+
                        "    ♦ Continue to keep about 6 feet between yourself and others. The mask is not a substitute for social distancing.<br/>"+
                        "</ul>" ;

                if(linearLayout4.getVisibility()==View.GONE)
                {
                    textView4.setText(Html.fromHtml(htmlString));
                    linearLayout4.setVisibility(View.VISIBLE);
                    imageButton4.setBackgroundResource(R.drawable.hide_block);

                }
                else {
                    linearLayout4.setVisibility(View.GONE);
                    imageButton4.setBackgroundResource(R.drawable.display_block);
                }
                //show.setVisibility(View.INVISIBLE);

            }
        });


        // New Card View
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                htmlString  =  "<ul>\n" +
                        "    ♦ Always cover your mouth and nose with a tissue when you cough or sneeze or use the inside of your elbow and do not spit.<br/>" +
                        "    ♦ Throw used tissues in the trash.<br/>"+
                        "    ♦ Immediately wash your hands with soap and water for at least 20 seconds. If soap and water are not readily available, clean your hands with a hand sanitizer that contains at least 60% alcohol.<br/>"+
                        "</ul>" ;

                if(linearLayout5.getVisibility()==View.GONE)
                {
                    textView5.setText(Html.fromHtml(htmlString));
                    linearLayout5.setVisibility(View.VISIBLE);
                    imageButton5.setBackgroundResource(R.drawable.hide_block);

                }
                else {
                    linearLayout5.setVisibility(View.GONE);
                    imageButton5.setBackgroundResource(R.drawable.display_block);
                }
                //show.setVisibility(View.INVISIBLE);

            }
        });


        // New Card View
        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                htmlString  =  "<ul>\n" +
                        "    ♦ Clean AND disinfect frequently touched surfaces daily. This includes tables, doorknobs, light switches, countertops, handles, desks, phones, keyboards, toilets, faucets, and sinks.<br/>" +
                        "    ♦ If surfaces are dirty, clean them. Use detergent or soap and water prior to disinfection.<br/>"+
                        "    ♦ Then, use a household disinfectant.<br/>"+
                        "</ul>" ;

                if(linearLayout6.getVisibility()==View.GONE)
                {
                    textView6.setText(Html.fromHtml(htmlString));
                    linearLayout6.setVisibility(View.VISIBLE);
                    imageButton6.setBackgroundResource(R.drawable.hide_block);

                }
                else {
                    linearLayout6.setVisibility(View.GONE);
                    imageButton6.setBackgroundResource(R.drawable.display_block);
                }
                //show.setVisibility(View.INVISIBLE);

            }
        });

        // New Card View
        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                htmlString  =  "<ul>\n" +
                        "    ♦ Be alert for symptoms. Watch for fever, cough, shortness of breath, or other symptoms of COVID-19.<br/> \t √ Especially important if you are running essential errands, going into the office or workplace, and in settings where it may be difficult to keep a physical distance of 6 feet.<br/>" +
                        "    ♦ Take your temperature if symptoms develop. <br/> \t √ Don’t take your temperature within 30 minutes of exercising or after taking medications that could lower your temperature, like acetaminophen.<br/>"+
                        "    ♦ Follow CDC guidance if symptoms develop.<br/>"+
                        "</ul>" ;

                if(linearLayout7.getVisibility()==View.GONE)
                {
                    textView7.setText(Html.fromHtml(htmlString));
                    linearLayout7.setVisibility(View.VISIBLE);
                    imageButton7.setBackgroundResource(R.drawable.hide_block);

                }
                else {
                    linearLayout7.setVisibility(View.GONE);
                    imageButton7.setBackgroundResource(R.drawable.display_block);
                }
                //show.setVisibility(View.INVISIBLE);

            }
        });


        return view;
}

}