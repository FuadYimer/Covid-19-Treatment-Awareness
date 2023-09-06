package com.example.covid_selef_treatment.syptoms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.covid_selef_treatment.R;
import com.example.covid_selef_treatment.SymptomFragment;

public class SyptomDetailHolderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syptom_detail_holder);
        Bundle bundle  = getIntent().getExtras();
        int fragid = R.id.cardview_fever;
        if (bundle != null){
            fragid = bundle.getInt("selectedview");
        }

        if (fragid== R.id.cardview_fever){
            getSupportFragmentManager().beginTransaction().add(R.id.syptom_detail_container, new FeverDetailFragment()).commit();
        }
        else if (fragid== R.id.cardview_cough){
            getSupportFragmentManager().beginTransaction().add(R.id.syptom_detail_container, new CoughDetailFragment()).commit();
        }
        else if (fragid== R.id.cardview_tirdness){
            getSupportFragmentManager().beginTransaction().add(R.id.syptom_detail_container, new FatigueDetailFragment()).commit();
        }
        else if (fragid== R.id.cardview_sorethroat){
            getSupportFragmentManager().beginTransaction().add(R.id.syptom_detail_container, new SoreThroadDetailFragment()).commit();
        }
        else if (fragid== R.id.cardview_shortbreath){
            getSupportFragmentManager().beginTransaction().add(R.id.syptom_detail_container, new ShortnessOfBreathFragment()).commit();
        }
    }
}