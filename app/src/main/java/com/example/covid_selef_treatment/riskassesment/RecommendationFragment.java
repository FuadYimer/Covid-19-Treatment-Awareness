package com.example.covid_selef_treatment.riskassesment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.covid_selef_treatment.GetQnAData;
import com.example.covid_selef_treatment.GetQnADataAdapter;
import com.example.covid_selef_treatment.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecommendationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecommendationFragment extends Fragment {
    TextView alarmingsyptom, recommendationType, recommendationDetail;
    LinearLayout alermingsyptomLayout;
    ImageView recommendationimage;


    private RecyclerView mRecyclerView;
    private List<Object> viewItems = new ArrayList<>();

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RecommendationFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static RecommendationFragment newInstance(String param1, String param2) {
        RecommendationFragment fragment = new RecommendationFragment();
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

        // Load progress dialog
      // showprogressbar();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recommendation, container, false);
        Bundle bundle = this.getArguments();
        alarmingsyptom = view.findViewById(R.id.alarmingsyptom);
        recommendationType = view.findViewById(R.id.recommendationType);
        recommendationDetail = view.findViewById(R.id.recommendationDetail);
        alermingsyptomLayout = view.findViewById(R.id.alarmingsyptom_layout);
        recommendationimage = view.findViewById(R.id.recommendationimage);
        alarmingsyptom.setText("");
        ArrayList<String> syptomlist = (ArrayList<String>) bundle.getSerializable("firstcases");
        ArrayList<String> syptomlistsecond = (ArrayList<String>) bundle.getSerializable("secondcases");
        ArrayList<String> syptomlistThird = (ArrayList<String>) bundle.getSerializable("symptoms");
        ArrayList<String> OtherSyptoms = (ArrayList<String>) bundle.getSerializable("OtherSyptom");

        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new GetQnADataAdapter(getContext(), viewItems);
        mRecyclerView.setAdapter(mAdapter);


        //  String fever = bundle.getSerializable("How_high_your_fever").toString();
        //String breathing = bundle.getString("breathing_very_fast");


        String alearmingsyptom1, alearmingsyptom2, alearmingsyptom3;

        if (syptomlistThird.get(0).equals("Fever_No") && syptomlistThird.get(1).equals("Cough_No") && syptomlistThird.get(2).equals("Shortness_of_breath_No")) {
            String CloseContactWithCovid = bundle.getString("CloseContactWithCovid");
            if (CloseContactWithCovid.equals("ContactType_5") || CloseContactWithCovid.equals("ContactType_4")) {
                alermingsyptomLayout.setVisibility(View.GONE);
                recommendationType.setText(R.string.stay_home_and_monitor_your_symptoms);
                recommendationimage.setImageResource(R.drawable.home);
                recommendationDetail.setText(R.string.your_symptoms_do_not_suggest_that_you_have_the_covid_19_still);

                // Recommendation Type :  Stay home and monitor your symptoms.
                ArrayList<String> RecommendationList = new ArrayList<>();
                RecommendationList.add("Stay at home and rest");
                RecommendationList.add("Wash your hands often");
                RecommendationList.add("Maintain social distancing");
                RecommendationList.add("Monitor your symptoms");
                addRecommendationFromJSON(RecommendationList);
            }
            if (CloseContactWithCovid.equals("ContactType_3")) {
                alermingsyptomLayout.setVisibility(View.VISIBLE);
                alarmingsyptom.append("\n► " + getString(R.string.prolonged_direct_contact_with_a_person_suspected_of_having_covid_19));
                recommendationType.setText(R.string.quarantine);
                recommendationType.setTextColor(getResources().getColor(R.color.colorFlower));
                recommendationimage.setImageResource(R.drawable.quarantine);
                recommendationDetail.setText(R.string.your_symptoms_currently_do_not_suggest_that_you_have_covid_19_however_according_to_the_who_and_cdc_guidelines);
                ArrayList<String> RecommendationList = new ArrayList<>();
                RecommendationList.add("Quarantine");
                RecommendationList.add("Cough and sneeze properly");
                RecommendationList.add("Wash your hands often");
                RecommendationList.add("Monitor your symptoms");
                // get recommendation from json file
                addRecommendationFromJSON(RecommendationList);
            }
            if (CloseContactWithCovid.equals("ContactType_2")) {
                alermingsyptomLayout.setVisibility(View.VISIBLE);
                alarmingsyptom.append("\n►" + getString(R.string.direct_physical_contact_with_a_person_suspected_of_having_covid_19));
                recommendationType.setText(R.string.quarantine);
                recommendationType.setTextColor(getResources().getColor(R.color.colorFlower));
                recommendationimage.setImageResource(R.drawable.quarantine);
                recommendationDetail.setText(R.string.your_symptoms_currently_do_not_suggest_that_you_have_covid_19_however_according_to_the_who_and_cdc_guidelines);
                ArrayList<String> RecommendationList = new ArrayList<>();
                RecommendationList.add("Quarantine");
                RecommendationList.add("Cough and sneeze properly");
                RecommendationList.add("Wash your hands often");
                RecommendationList.add("Monitor your symptoms");
                addRecommendationFromJSON(RecommendationList);
            }
            if (CloseContactWithCovid.equals("ContactType_1")) {
                alermingsyptomLayout.setVisibility(View.VISIBLE);
                alarmingsyptom.append("\n► " + getString(R.string.caring_for_covid_19_suspected_person_without_protection));
                recommendationType.setText(R.string.quarantine);
                recommendationType.setTextColor(getResources().getColor(R.color.colorFlower));
                recommendationimage.setImageResource(R.drawable.quarantine);
                recommendationDetail.setText(R.string.your_symptoms_currently_do_not_suggest_that_you_have_covid_19_however_according_to_the_who_and_cdc_guidelines);
                ArrayList<String> RecommendationList = new ArrayList<>();
                RecommendationList.add("Quarantine");
                RecommendationList.add("Cough and sneeze properly");
                RecommendationList.add("Wash your hands often");
                RecommendationList.add("Monitor your symptoms");
                addRecommendationFromJSON(RecommendationList);
            }


        } else {

            String symptoms_rapidly_worsening = bundle.getString("symptoms_rapidly_worsening");
            String breathing_very_fast = bundle.getString("breathing_very_fast");
            String coughing_up_blood = bundle.getString("coughing_up_blood");

            if (syptomlistThird.get(0).equals("Fever_Yes")) {
                String How_high_your_fever = bundle.getString("How_high_your_fever");
                if (!How_high_your_fever.equals("I haven’t taken my temperature")) {
                    alarmingsyptom.append("\n►" + getString(R.string.fever) +" " + How_high_your_fever);
                }
            }
            if (syptomlistThird.get(1).equals("Cough_Yes")) {
                alarmingsyptom.append("\n►" + getString(R.string.cough));
            }
            if (syptomlistThird.get(2).equals("Shortness_of_breath_Yes")) {
                alarmingsyptom.append("\n►" + getString(R.string.shortness_of_breath));
            }
            if (symptoms_rapidly_worsening.equals("Yes")) {
                alarmingsyptom.append("\n►" + getString(R.string.symptoms_quickly_worsening));
            }
            if (breathing_very_fast.equals("Yes")) {
                alarmingsyptom.append("\n►" + getString(R.string.rapid_breathing));
            }
            if (coughing_up_blood.equals("Yes")) {
                alarmingsyptom.append("\n►" + getString(R.string.coughing_up_blood));
            }
            // Addatiional path
            String CloseContactWithCovid = bundle.getString("CloseContactWithCovid");
            if ((syptomlistThird.get(0).equals("Fever_Yes") || syptomlistThird.get(1).equals("Cough_Yes")) &&
                    symptoms_rapidly_worsening.equals("No") && breathing_very_fast.equals("No") && coughing_up_blood.equals("No")) {
                // Add condition here if other system is found or not
                if (OtherSyptoms.isEmpty() == false) {
                    if (CloseContactWithCovid.equals("ContactType_1") || CloseContactWithCovid.equals("ContactType_2") || CloseContactWithCovid.equals("ContactType_3")) {
                        if (CloseContactWithCovid.equals("ContactType_1")) {
                            alarmingsyptom.append("\n► " + getString(R.string.caring_for_covid_19_suspected_person_without_protection));
                        } else if (CloseContactWithCovid.equals("ContactType_2")) {
                            alarmingsyptom.append("\n► " + getString(R.string.direct_physical_contact_with_a_person_suspected_of_having_covif_19));
                        } else if (CloseContactWithCovid.equals("ContactType_3")) {
                            alarmingsyptom.append("\n► " + getString(R.string.prolonged_direct_contact_with_a_person_suspected_of_having_covid_19));
                        }
                        recommendationType.setText(R.string.consult_your_health_care_provider_avoid_all_contacts);
                        recommendationType.setTextColor(getResources().getColor(R.color.colorFlower));
                        recommendationimage.setImageResource(R.drawable.consultation_doctor);
                        recommendationDetail.setText(R.string.your_symptoms_are_worrisome_and_may_be_related_to_covid_19);
                        // Recommendation Type :  Stay home and monitor your symptoms.
                        ArrayList<String> RecommendationList = new ArrayList<>();
                        RecommendationList.add("Immediately separate yourself from people and pets in your house");
                        RecommendationList.add("Call local health care facility");
                        RecommendationList.add("Monitor your symptoms");
                        RecommendationList.add("Wear a surgical face mask");
                        RecommendationList.add("Maintain strict hygiene");
                        RecommendationList.add("Regularly clean commonly touched surfaces in your house");
                        addRecommendationFromJSON(RecommendationList);
                    } else {
                        // Contact type 4 and contact type 5
                        recommendationType.setText(R.string.call_a_doctor);
                        recommendationType.setTextColor(getResources().getColor(R.color.colorFlower));
                        recommendationimage.setImageResource(R.drawable.call_doctor);
                        recommendationDetail.setText(R.string.your_answers_do_not_suggest_that_you_have_the_covid_19);
                        // Recommendation Type :  Stay home and monitor your symptoms.
                        ArrayList<String> RecommendationList = new ArrayList<>();
                        RecommendationList.add("Call a doctor or healthcare facility");
                        RecommendationList.add("Wash your hands often");
                        RecommendationList.add("Maintain social distancing");
                        addRecommendationFromJSON(RecommendationList);
                    }

                } else {
                    if (CloseContactWithCovid.equals("ContactType_1") || CloseContactWithCovid.equals("ContactType_2") || CloseContactWithCovid.equals("ContactType_3")) {
                        if (CloseContactWithCovid.equals("ContactType_1")) {
                            alarmingsyptom.append("\n►" + getString(R.string.caring_for_covid_19_suspected_person_without_protection));
                        } else if (CloseContactWithCovid.equals("ContactType_2")) {
                            alarmingsyptom.append("\n►" + getString(R.string.direct_physical_contact_with_a_person_suspected_of_having_covif_19));
                        } else if (CloseContactWithCovid.equals("ContactType_3")) {
                            alarmingsyptom.append("\n► " + getString(R.string.prolonged_direct_contact_with_a_person_suspected_of_having_covid_19));
                        }

                        recommendationType.setText(R.string.consult_your_health_care_provider_avoid_all_contacts);
                        recommendationType.setTextColor(getResources().getColor(R.color.colorFlower));
                        recommendationimage.setImageResource(R.drawable.consultation_doctor);
                        recommendationDetail.setText(R.string.your_symptoms_are_worrisome_and_may_be_related_to_covid_19);
                        // Recommendation Type :  Stay home and monitor your symptoms.
                        ArrayList<String> RecommendationList = new ArrayList<>();
                        RecommendationList.add("Immediately separate yourself from people and pets in your house");
                        RecommendationList.add("Call local health care facility");
                        RecommendationList.add("Monitor your symptoms");
                        RecommendationList.add("Wear a surgical face mask");
                        RecommendationList.add("Maintain strict hygiene");
                        RecommendationList.add("Regularly clean commonly touched surfaces in your house");
                        addRecommendationFromJSON(RecommendationList);
                    } else {
                        // Contact type 4 and contact type 5
                        recommendationType.setText(R.string.stay_home_and_monitor_your_symptoms);
                        recommendationType.setTextColor(getResources().getColor(R.color.colorPrimary));
                        recommendationimage.setImageResource(R.drawable.home);
                        recommendationDetail.setText(R.string.your_symptoms_do_not_suggest_that_you_have_the_covid_19_still);
                        // Recommendation Type :  Stay home and monitor your symptoms.
                        ArrayList<String> RecommendationList = new ArrayList<>();
                        RecommendationList.add("Stay at home and rest");
                        RecommendationList.add("Wash your hands often");
                        RecommendationList.add("Maintain social distancing");
                        RecommendationList.add("Monitor your symptoms");
                        addRecommendationFromJSON(RecommendationList);
                    }
                }


            } else if (syptomlistThird.get(2).equals("Shortness_of_breath_Yes") && symptoms_rapidly_worsening.equals("No")
                    && breathing_very_fast.equals("No") && coughing_up_blood.equals("No")) {
                // person does not have other disease

                if (OtherSyptoms.isEmpty() == false) {
                    // Syptom getting serious
                    if (CloseContactWithCovid.equals("ContactType_1") || CloseContactWithCovid.equals("ContactType_2") ||
                            CloseContactWithCovid.equals("ContactType_3")) {
                        if (CloseContactWithCovid.equals("ContactType_1")) {
                            alarmingsyptom.append("\n►" + getString(R.string.caring_for_covid_19_suspected_person_without_protection));
                        } else if (CloseContactWithCovid.equals("ContactType_2")) {
                            alarmingsyptom.append("\n►" + getString(R.string.direct_physical_contact_with_a_person_suspected_of_having_covif_19));
                        } else if (CloseContactWithCovid.equals("ContactType_3")) {
                            alarmingsyptom.append("\n► " + getString(R.string.prolonged_direct_contact_with_a_person_suspected_of_having_covid_19));
                        }
                        recommendationType.setText(R.string.call_the_emergency_number_avoid_all_contact);
                        recommendationDetail.setText(R.string.your_symptoms_are_very_serious_and_you_may_have_covid_19);
                        recommendationType.setTextColor(getResources().getColor(R.color.colorGrapeFruit));
                        recommendationimage.setImageResource(R.drawable.covidrisk);
                        // Recommendation Type :  Stay home and monitor your symptoms.
                        ArrayList<String> RecommendationList = new ArrayList<>();
                        RecommendationList.add("Immediately separate yourself from people and pets in your house");
                        RecommendationList.add("Call the emergency number");
                        RecommendationList.add("Wear a surgical face mask");
                        addRecommendationFromJSON(RecommendationList);
                    } else {
                        // Contact type 4 and contact type 5
                        recommendationType.setText(R.string.call_a_doctor);
                        recommendationType.setTextColor(getResources().getColor(R.color.colorFlower));
                        recommendationimage.setImageResource(R.drawable.call_doctor);
                        recommendationDetail.setText(R.string.your_answers_do_not_suggest_that_you_have_the_covid_19);
                        // Recommendation Type :  Stay home and monitor your symptoms.
                        ArrayList<String> RecommendationList = new ArrayList<>();
                        RecommendationList.add("Call a doctor or healthcare facility");
                        RecommendationList.add("Wash your hands often");
                        RecommendationList.add("Maintain social distancing");
                        addRecommendationFromJSON(RecommendationList);
                    }
                } else {
                    // other syptom is not available
                    if (CloseContactWithCovid.equals("ContactType_1") || CloseContactWithCovid.equals("ContactType_2") ||
                            CloseContactWithCovid.equals("ContactType_3")) {
                        if (CloseContactWithCovid.equals("ContactType_1")) {
                            alarmingsyptom.append("\n►" + getString(R.string.caring_for_covid_19_suspected_person_without_protection));
                        } else if (CloseContactWithCovid.equals("ContactType_2")) {
                            alarmingsyptom.append("\n►" + getString(R.string.direct_physical_contact_with_a_person_suspected_of_having_covif_19));
                        } else if (CloseContactWithCovid.equals("ContactType_3")) {
                            alarmingsyptom.append("\n► " + getString(R.string.prolonged_direct_contact_with_a_person_suspected_of_having_covid_19));
                        }
                        recommendationType.setText(R.string.consult_your_health_care_provider_avoid_all_contacts);
                        recommendationDetail.setText(R.string.your_symptoms_are_worrisome_and_may_be_related_to_covid_19);
                        recommendationType.setTextColor(getResources().getColor(R.color.colorFlower));
                        recommendationimage.setImageResource(R.drawable.consultation_doctor);
                        // Recommendation Type :
                        ArrayList<String> RecommendationList = new ArrayList<>();
                        RecommendationList.add("Immediately separate yourself from people and pets in your house");
                        RecommendationList.add("Call local health care facility");
                        RecommendationList.add("Monitor your symptoms");
                        RecommendationList.add("Wear a surgical face mask");
                        RecommendationList.add("Maintain strict hygiene");
                        RecommendationList.add("Regularly clean commonly touched surfaces in your house");
                        addRecommendationFromJSON(RecommendationList);
                    } else {
                        // Contact type 4 and contact type 5
                        recommendationType.setText(R.string.call_a_doctor);
                        recommendationType.setTextColor(getResources().getColor(R.color.colorFlower));
                        recommendationimage.setImageResource(R.drawable.call_doctor);
                        recommendationDetail.setText(R.string.your_answers_do_not_suggest_that_you_have_the_covid_19);

                        // Recommendation Type :  Stay home and monitor your symptoms.
                        ArrayList<String> RecommendationList = new ArrayList<>();
                        RecommendationList.add("Call a doctor or healthcare facility");
                        RecommendationList.add("Wash your hands often");
                        RecommendationList.add("Maintain social distancing");
                        addRecommendationFromJSON(RecommendationList);
                    }

                }

            } else {
                //Risk case decission
                recommendationType.setText(R.string.call_the_emergency_number_avoid_all_contact);
                recommendationDetail.setText(R.string.your_symptoms_are_very_serious_and_you_may_have_covid_19);
                recommendationType.setTextColor(getResources().getColor(R.color.colorGrapeFruit));
                recommendationimage.setImageResource(R.drawable.covidrisk);

                ArrayList<String> RecommendationList = new ArrayList<>();
                RecommendationList.add("Immediately separate yourself from people and pets in your house");
                RecommendationList.add("Call the emergency number");
                RecommendationList.add("Wear a surgical face mask");
                addRecommendationFromJSON(RecommendationList);


            }


        }


        return view;
    }


    private void addRecommendationFromJSON(ArrayList<String> RecommendationList) {
        try {
            String jsonDataString = readJSONDataFromFile();
            JSONArray jsonArray = new JSONArray(jsonDataString);

            for (int i = 0; i < jsonArray.length(); ++i) {

                JSONObject itemObj = jsonArray.getJSONObject(i);
                String title = null, detail = null;
                title = itemObj.getString("Recommendation");
                detail = itemObj.getString("detail");
                System.out.println(RecommendationList);

                for (String Recommendation : RecommendationList) {
                    if (title.equals(Recommendation)) {
                        TextUtils.StringSplitter splitter = new TextUtils.SimpleStringSplitter('~');
                        splitter.setString(detail);

                        StringBuilder stringBuilder = new StringBuilder();
                        for (String s_temp : splitter) {
                            stringBuilder.append(s_temp + "<br/>");
                        }
                        String detail2 = stringBuilder.toString().trim();
                        GetQnAData getPreventionData = new GetQnAData(title, detail2);
                        viewItems.add(getPreventionData);
                    }
                }


            }

        } catch (JSONException | IOException e) {
            Log.d("Recommendation.class", "addItemsFromJSON: ", e);
        }
    }

    private String readJSONDataFromFile() throws IOException {
        InputStream inputStream = null;
        StringBuilder builder = new StringBuilder();
        try {

            String jsonString = null;
            inputStream = getResources().openRawResource(R.raw.recommendation);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream, "UTF-8"));

            while ((jsonString = bufferedReader.readLine()) != null) {
                builder.append(jsonString);
            }

        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return new String(builder);
    }


    private void showprogressbar() {
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage(getString(R.string.wait_while_loading));
        progressDialog.setTitle(getString(R.string.analyzing_your_symptoms));
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        // progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.show(); // Display Progress Dialog
        progressDialog.setCancelable(false);
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();
            }
        }).start();

    }

}