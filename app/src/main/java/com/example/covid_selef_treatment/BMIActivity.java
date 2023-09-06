package com.example.covid_selef_treatment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMIActivity extends AppCompatActivity {
    Button button;
    EditText txt_weight , txt_height;
    TextView result;
    float weight , height , value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i);
        button =findViewById(R.id.btn);
        txt_weight = findViewById(R.id.weight);
        txt_height =findViewById(R.id.height);
        result  = findViewById(R.id.result);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                weight = Float.parseFloat(txt_weight.getText().toString());
                height  = Float.parseFloat(txt_height.getText().toString());
                value = weight/(height * height);
                result.setText(value +"");

            }
        });
    }
}