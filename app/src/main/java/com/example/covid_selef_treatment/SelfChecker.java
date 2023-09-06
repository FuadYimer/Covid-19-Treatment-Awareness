package com.example.covid_selef_treatment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.file.Files;

public class SelfChecker extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    RadioButton agreement1, agreement2, selfassesment, notselefassesment, gendermale, genderfemale, syptomyes, syptomno,
            sickyes, sickno, contactyes, contactno, contactnither, submitsyptomyes, shelteryes, shelterno, volunteeredYes, volunteeredNo, checkotherdiseaseyes;

    LinearLayout agreementlayout, firstquestionlayout, secondquestionlayout, thirdquestionlayout,
            fourthquestionlayout, fifthquestionlayout, recommendation1, sixquestionlayout, seventhquestionlayout,
            eightquestionlayout, ninequestionlayout, responce2yes, volunteeredquestion, volunteredResponceYes, OtherDiseaseSyptomLayout, volunteeredworkNoResponce,
            AgeRestrictionNotification;

    TextView notificatiomessage;

    Spinner regionspinner, agegroupspinner;

    public String yourRegion, yourAgeGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_checker);


        agreement1 = findViewById(R.id.btn_agree);
        agreement2 = findViewById(R.id.btn_disagree);

        // assessmenttype radiobuton
        selfassesment = findViewById(R.id.selefassesment);
        notselefassesment = findViewById(R.id.notselefassesment);

        // gender radio butto
        gendermale = findViewById(R.id.gender_male);
        genderfemale = findViewById(R.id.gender_female);

        //syptom responce
        syptomyes = findViewById(R.id.syptom_yes);
        syptomno = findViewById(R.id.syptom_no);

        //sick before responce
        sickyes = findViewById(R.id.sick_yes);
        sickno = findViewById(R.id.sick_no);

        // contact with patient
        contactyes = findViewById(R.id.contact_yes);
        contactno = findViewById(R.id.contact_no);
        contactnither = findViewById(R.id.contact_nither);

        // Submitsypto
        submitsyptomyes = findViewById(R.id.submit_syptom_yes);

        // shelter Responce
        shelteryes = findViewById(R.id.shelter_yes);
        shelterno = findViewById(R.id.shelter_no);

        //volunteered Responce
        volunteeredYes = findViewById(R.id.volunteered_yes);
        volunteeredNo = findViewById(R.id.volunteered_no);


        // check other disease yes
        checkotherdiseaseyes = findViewById(R.id.checkothersisease_yes);


        agreementlayout = findViewById(R.id.agreement);
        firstquestionlayout = findViewById(R.id.firstquestion);
        secondquestionlayout = findViewById(R.id.secondquestion);
        thirdquestionlayout = findViewById(R.id.thirdquestion);
        fourthquestionlayout = findViewById(R.id.fourthquestion);
        fifthquestionlayout = findViewById(R.id.fifthquestion);
        recommendation1 = findViewById(R.id.responcefirst);
        sixquestionlayout = findViewById(R.id.sixthquestion);
        seventhquestionlayout = findViewById(R.id.seventhquestion);
        eightquestionlayout = findViewById(R.id.eightquestion);
        ninequestionlayout = findViewById(R.id.ninthquestion);
        responce2yes = findViewById(R.id.secondfirst);
        volunteeredquestion = findViewById(R.id.volunteeredquestion);
        volunteredResponceYes = findViewById(R.id.volunteeredworkYesResponce);  // if voluntered work  responce yes
        OtherDiseaseSyptomLayout = findViewById(R.id.OtherDiseaseSyptom);   // if voluntered work responce no display this layout
        volunteeredworkNoResponce = findViewById(R.id.volunteeredworkNoResponce);

        AgeRestrictionNotification = findViewById(R.id.AgeRestrictionNotification);


        // Text view
        notificatiomessage = findViewById(R.id.notifactionmessage);


        regionspinner = findViewById(R.id.sp_region);
        regionspinner.setOnItemSelectedListener(this);

        agegroupspinner = findViewById(R.id.sp_agegroup);
        agegroupspinner.setOnItemSelectedListener(this);

        final RadioGroup radioGroupAgreement = (RadioGroup) findViewById(R.id.agreementgroup);
        radioGroupAgreement.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                RadioButton rb = (RadioButton) findViewById(checkedId);

                if (rb.getId() == R.id.btn_agree) {
                    agreement1.setTextColor(Color.WHITE);
                    agreement2.setTextColor(Color.RED);
                    agreementlayout.setVisibility(View.GONE);
                    firstquestionlayout.setVisibility(View.VISIBLE);
                } else if (rb.getId() == R.id.btn_disagree) {
                    agreement1.setTextColor(Color.RED);
                    agreement2.setTextColor(Color.WHITE);
                }
            }
        });

        // Assesment Type
        final RadioGroup radioGroupAssesmentType = (RadioGroup) findViewById(R.id.assesmenttype);
        radioGroupAssesmentType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                RadioButton rb = (RadioButton) findViewById(checkedId);

                if (rb.getId() == R.id.selefassesment) {
                    selfassesment.setTextColor(Color.WHITE);
                    notselefassesment.setTextColor(Color.RED);
                    notselefassesment.setEnabled(false);  // disable for not to select again
                    thirdquestionlayout.setVisibility(View.VISIBLE);
                } else if (rb.getId() == R.id.notselefassesment) {
                    selfassesment.setTextColor(Color.RED);
                    notselefassesment.setTextColor(Color.WHITE);
                    selfassesment.setEnabled(false);
                    thirdquestionlayout.setVisibility(View.VISIBLE);
                }
            }
        });


        final RadioGroup radioGroupGender = (RadioGroup) findViewById(R.id.gender);
        radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                RadioButton rb = (RadioButton) findViewById(checkedId);

                if (rb.getId() == R.id.gender_male) {
                    gendermale.setTextColor(Color.WHITE);
                    genderfemale.setTextColor(Color.RED);
                    genderfemale.setEnabled(false);
                    fifthquestionlayout.setVisibility(View.VISIBLE);
                } else if (rb.getId() == R.id.gender_female) {
                    gendermale.setTextColor(Color.RED);
                    genderfemale.setTextColor(Color.WHITE);
                    gendermale.setEnabled(false);
                    fifthquestionlayout.setVisibility(View.VISIBLE);
                }
            }
        });


        final RadioGroup radioGroupResponce1 = (RadioGroup) findViewById(R.id.generalsyptom);
        radioGroupResponce1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                RadioButton rb = (RadioButton) findViewById(checkedId);

                if (rb.getId() == R.id.syptom_yes) {
                    syptomyes.setTextColor(Color.WHITE);
                    syptomno.setTextColor(Color.RED);
                    recommendation1.setVisibility(View.VISIBLE);
                    syptomno.setEnabled(false);
                } else if (rb.getId() == R.id.syptom_no) {
                    syptomyes.setTextColor(Color.RED);
                    syptomno.setTextColor(Color.WHITE);
                    syptomyes.setEnabled(false);
                    sixquestionlayout.setVisibility(View.VISIBLE);
                }
            }
        });


        final RadioGroup radioGroupFillinegSick = (RadioGroup) findViewById(R.id.sick);
        radioGroupFillinegSick.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                RadioButton rb = (RadioButton) findViewById(checkedId);

                if (rb.getId() == R.id.sick_yes) {
                    sickyes.setTextColor(Color.WHITE);
                    sickno.setTextColor(Color.RED);
                    seventhquestionlayout.setVisibility(View.VISIBLE);
                } else if (rb.getId() == R.id.sick_no) {
                    sickyes.setTextColor(Color.RED);
                    sickno.setTextColor(Color.WHITE);
                    Toast.makeText(SelfChecker.this, "Filling Sick Responce No: to be added soon ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // close contact
        final RadioGroup radioGroupCloseContact = (RadioGroup) findViewById(R.id.contact);
        radioGroupCloseContact.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                RadioButton rb = (RadioButton) findViewById(checkedId);

                if (rb.getId() == R.id.contact_yes) {
                    contactyes.setTextColor(Color.WHITE);
                    contactno.setTextColor(Color.RED);
                    contactnither.setTextColor(Color.RED);
                    eightquestionlayout.setVisibility(View.VISIBLE);
                    contactno.setEnabled(false);
                    contactnither.setEnabled(false);
                } else if (rb.getId() == R.id.contact_no) {
                    contactyes.setTextColor(Color.RED);
                    contactno.setTextColor(Color.WHITE);
                    contactnither.setTextColor(Color.RED);
                    eightquestionlayout.setVisibility(View.VISIBLE);  // get syptom layout
                    contactyes.setEnabled(false);
                    contactnither.setEnabled(false);
                    //Toast.makeText(SelfChecker.this, "Close contact No Responce: to be added soon ", Toast.LENGTH_SHORT).show();
                } else if (rb.getId() == R.id.contact_nither) {
                    contactyes.setTextColor(Color.RED);
                    contactno.setTextColor(Color.RED);
                    contactnither.setTextColor(Color.WHITE);
                    eightquestionlayout.setVisibility(View.VISIBLE);  // get syptom layout
                    contactyes.setEnabled(false);
                    contactno.setEnabled(false);
                    //Toast.makeText(SelfChecker.this, "Close contact I don't know Responce: to be added soon ", Toast.LENGTH_SHORT).show();
                }
            }
        });


        // Submit syptom

        final RadioGroup radioGroupSubmitSyptom = (RadioGroup) findViewById(R.id.submit_syptom);
        radioGroupSubmitSyptom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                RadioButton rb = (RadioButton) findViewById(checkedId);

                if (rb.getId() == R.id.submit_syptom_yes) {
                    submitsyptomyes.setTextColor(Color.WHITE);
                    ninequestionlayout.setVisibility(View.VISIBLE);
                }
            }
        });


        // shelter Responce
        final RadioGroup radioGroupShelterResponce = (RadioGroup) findViewById(R.id.shelter);
        radioGroupShelterResponce.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                RadioButton rb = (RadioButton) findViewById(checkedId);

                if (rb.getId() == R.id.shelter_yes) {
                    shelteryes.setTextColor(Color.WHITE);
                    shelterno.setTextColor(Color.RED);
                    responce2yes.setVisibility(View.VISIBLE);
                    shelterno.setEnabled(false);
                } else if (rb.getId() == R.id.shelter_no) {
                    shelteryes.setTextColor(Color.RED);
                    shelterno.setTextColor(Color.WHITE);
                    volunteeredquestion.setVisibility(View.VISIBLE);
                    shelteryes.setEnabled(false);
                }
            }
        });


        // Voluntered work yes no
        // shelter Responce
        final RadioGroup radioGroupVolunteryWorkResponce = (RadioGroup) findViewById(R.id.volunteered);
        radioGroupVolunteryWorkResponce.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                RadioButton rb = (RadioButton) findViewById(checkedId);

                if (rb.getId() == R.id.volunteered_yes) {
                    volunteeredYes.setTextColor(Color.WHITE);
                    volunteeredNo.setTextColor(Color.RED);
                    volunteredResponceYes.setVisibility(View.VISIBLE);
                    volunteeredNo.setEnabled(false);
                } else if (rb.getId() == R.id.volunteered_no) {
                    volunteeredYes.setTextColor(Color.RED);
                    volunteeredNo.setTextColor(Color.WHITE);
                    OtherDiseaseSyptomLayout.setVisibility(View.VISIBLE);
                    volunteeredYes.setEnabled(false);

                }
            }
        });


        // disease syptom check box submit button
        final RadioGroup radioGroupcheckOtherDisease = (RadioGroup) findViewById(R.id.checkothersisease);
        radioGroupcheckOtherDisease.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                RadioButton rb = (RadioButton) findViewById(checkedId);

                if (rb.getId() == R.id.checkothersisease_yes) {
                    checkotherdiseaseyes.setTextColor(Color.WHITE);
                    volunteeredworkNoResponce.setVisibility(View.VISIBLE);

                }
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        switch (adapterView.getId()) {
            case R.id.sp_region:
                yourRegion = (String) adapterView.getItemAtPosition(i);
                if (!yourRegion.equals("Please Select Region")) {
                    secondquestionlayout.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.sp_agegroup:
                yourAgeGroup = (String) adapterView.getItemAtPosition(i);
                String message;
                if (!yourAgeGroup.equals("Please select an age")) {
                    if (i == 1) {
                        notificatiomessage.setText(R.string.contact_a_medical_provider);
                        AgeRestrictionNotification.setVisibility(View.VISIBLE);
                    } else if (i == 2 || i == 3) {
                        if (selfassesment.isChecked() == true) {
                            notificatiomessage.setText(R.string.ask_parental_gidance);
                            AgeRestrictionNotification.setVisibility(View.VISIBLE);
                        }
                    } else if (i == 4 || i == 5) {
                        if (selfassesment.isChecked() == true) {
                            notificatiomessage.setText(R.string.ask_a_parent_or_guardian_to_assist_you_or_if_taking_by_yourself_share_these_results_with_your_parent_guardian);
                            AgeRestrictionNotification.setVisibility(View.VISIBLE);
                            fourthquestionlayout.setVisibility(View.VISIBLE);
                        }
                    } else {
                        fourthquestionlayout.setVisibility(View.VISIBLE);
                    }

                }

                break;
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.selfcheckermenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh:
                startActivity(getIntent());
                break;

        }
        return super.onOptionsItemSelected(item);
    }

}