package com.example.covid_selef_treatment.factsaboutcovid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.covid_selef_treatment.R;

public class FactsDetailActivity extends AppCompatActivity {
    TextView fact_title  , fact_detail;
    ImageView fact_picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facts_detail);

        fact_title = findViewById(R.id.facts_title);
        fact_detail  = findViewById(R.id.facts_detail);
        fact_picture = findViewById(R.id.facts_photo);

        // when title not set
        String title  =getString(R.string.title_not_set);
        String detail = getString(R.string.detail_not_set);
        int picctureid = R.drawable.weremask;

        Bundle bundle  = getIntent().getExtras();
        if (bundle != null){
            title = bundle.getString("facttitle");
            detail = bundle.getString("factdetail");
            picctureid = bundle.getInt("factpicture");
        }
        fact_title.setText(title);
        fact_detail.setText(detail);
        fact_picture.setImageResource(picctureid);
    }
}