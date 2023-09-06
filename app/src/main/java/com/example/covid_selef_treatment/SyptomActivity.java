package com.example.covid_selef_treatment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.covid_selef_treatment.riskassesment.AgreementFragment;

public class SyptomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syptom);
        getSupportFragmentManager().beginTransaction().add(R.id.syptom_container, new SymptomFragment()).commit();
    }
}