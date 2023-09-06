package com.example.covid_selef_treatment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SurvivalRateActivity extends AppCompatActivity {
    ProgressDialog progressDoalog;
    Button button_calculate;
    RadioButton agegroup1, agegroup2, agegroup3, agegroup4, agegroup5, gender1, gender2;
    public double ageval = 0, sexval = 0, risk, cache;
    LinearLayout showmessage;
    TextView message_result , risk_result , message_warning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survival_rate);


        showmessage = findViewById(R.id.show_result);
        message_result  = findViewById(R.id.messge_result);
        risk_result = findViewById(R.id.risk_result);
        message_warning = findViewById(R.id.message_warning);


        agegroup1 = findViewById(R.id.age_group_1_19);
        agegroup2 = findViewById(R.id.age_group_20_39);
        agegroup3 = findViewById(R.id.age_group_40_59);
        agegroup4 = findViewById(R.id.age_group_60_79);
        agegroup5 = findViewById(R.id.age_group_80_100);

        gender1 = findViewById(R.id.gender_male);
        gender2 = findViewById(R.id.gender_female);

        final RadioGroup radioGroupAge = (RadioGroup) findViewById(R.id.age_group);
        radioGroupAge.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                RadioButton rb = (RadioButton) findViewById(checkedId);
                rb.setTextColor(Color.WHITE);
                if (rb.getId() == R.id.age_group_1_19) {
                    agegroup1.setTextColor(Color.WHITE);
                    agegroup2.setTextColor(Color.RED);
                    agegroup3.setTextColor(Color.RED);
                    agegroup4.setTextColor(Color.RED);
                    agegroup5.setTextColor(Color.RED);
                } else if (rb.getId() == R.id.age_group_20_39) {

                    agegroup1.setTextColor(Color.RED);
                    agegroup2.setTextColor(Color.WHITE);
                    agegroup3.setTextColor(Color.RED);
                    agegroup4.setTextColor(Color.RED);
                    agegroup5.setTextColor(Color.RED);
                } else if (rb.getId() == R.id.age_group_40_59) {
                    agegroup1.setTextColor(Color.RED);
                    agegroup2.setTextColor(Color.RED);
                    agegroup3.setTextColor(Color.WHITE);
                    agegroup4.setTextColor(Color.RED);
                    agegroup5.setTextColor(Color.RED);
                } else if (rb.getId() == R.id.age_group_60_79) {
                    agegroup1.setTextColor(Color.RED);
                    agegroup2.setTextColor(Color.RED);
                    agegroup3.setTextColor(Color.RED);
                    agegroup4.setTextColor(Color.WHITE);
                    agegroup5.setTextColor(Color.RED);
                } else if (rb.getId() == R.id.age_group_80_100) {
                    agegroup1.setTextColor(Color.RED);
                    agegroup2.setTextColor(Color.RED);
                    agegroup3.setTextColor(Color.RED);
                    agegroup4.setTextColor(Color.RED);
                    agegroup5.setTextColor(Color.WHITE);
                }
                // Toast.makeText(CheckActivity.this, checkedId+ "", Toast.LENGTH_SHORT).show();
            }
        });


        final RadioGroup radioGroupGender = (RadioGroup) findViewById(R.id.gender);
        radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                RadioButton rb = (RadioButton) findViewById(checkedId);
                rb.setTextColor(Color.WHITE);
                if (rb.getId() == R.id.gender_male) {
                    gender1.setTextColor(Color.WHITE);
                    gender2.setTextColor(Color.RED);
                } else if (rb.getId() == R.id.gender_female) {
                    gender1.setTextColor(Color.RED);
                    gender2.setTextColor(Color.WHITE);
                }
            }
        });


        button_calculate = findViewById(R.id.btn_calculate);
        button_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                RadioButton agegroup1 = findViewById(R.id.age_group_1_19);
                RadioButton agegroup2 = findViewById(R.id.age_group_20_39);
                RadioButton agegroup3 = findViewById(R.id.age_group_40_59);
                RadioButton agegroup4 = findViewById(R.id.age_group_60_79);
                RadioButton agegroup5 = findViewById(R.id.age_group_80_100);

                if (agegroup1.isChecked() == true) {
                    ageval = 0.2;
                } else if (agegroup2.isChecked() == true) {
                    ageval = 0.3;
                } else if (agegroup3.isChecked() == true) {
                    ageval = 2.5;
                } else if (agegroup4.isChecked() == true) {
                    ageval = 5.0;
                } else if (agegroup5.isChecked() == true) {
                    ageval = 14.8;
                }


                RadioButton sexgroup1 = findViewById(R.id.gender_male);
                RadioButton sexgroup2 = findViewById(R.id.gender_female);
                if (sexgroup1.isChecked() == true) {
                    sexval = 0.15;
                }
                if (sexgroup2.isChecked() == true) {
                    sexval = 0.03;
                }

                risk = ageval + sexval;
                cache = risk;

                RadioButton condition1 = findViewById(R.id.condtion1yes);
                RadioButton condition2 = findViewById(R.id.condtion2yes);
                RadioButton condition3 = findViewById(R.id.condtion3yes);
                RadioButton condition4 = findViewById(R.id.condtion4yes);
                RadioButton condition5 = findViewById(R.id.condtion5yes);
                if (condition1.isChecked() == true) {
                    risk += (cache * 10.5) - cache;
                }
                if (condition2.isChecked() == true) {
                    risk += (cache * 7.3) - cache;
                }
                if (condition3.isChecked() == true) {
                    risk += (cache * 6.3) - cache;
                }
                if (condition4.isChecked() == true) {
                    risk += (cache * 6.8) - cache;
                }
                if (condition5.isChecked() == true) {
                    risk += (cache * 5.6) - cache;
                }

                String message = null;

                if (risk < 0) {
                    risk = 0;
                }
                if (risk > 92) {
                    risk = 92;
                }

                if (risk > 0) {
                    message = getString(R.string.you_should_be_fine);
                    message_result.setTextColor(Color.parseColor("#03DAC5"));
                    risk_result.setTextColor(Color.parseColor("#03DAC5"));
                    message_warning.setTextColor(Color.parseColor("#03DAC5"));

                }
                if (risk > 5) {
                    message_result.setTextColor(Color.parseColor("#FFCE54"));
                    risk_result.setTextColor(Color.parseColor("#FFCE54"));
                    message_warning.setTextColor(Color.parseColor("#FFCE54"));
                    message = getString(R.string.tale_extra_precaution);
                }
                if (risk > 30) {
                    message_result.setTextColor(Color.parseColor("#ED5565"));
                    risk_result.setTextColor(Color.parseColor("#ED5565"));
                    message_warning.setTextColor(Color.parseColor("#ED5565"));
                    message = getString(R.string.you_are_at_risk);
                }


                showmessage.setVisibility(View.VISIBLE);
                message_result.setText(message +"");
                risk_result.setText(getString(R.string.you_have_an_estimated) + String.format("%.2f", risk) + getString(R.string.change_of_dying_from_covid_19_if_infected));



            }
        });


    }



}