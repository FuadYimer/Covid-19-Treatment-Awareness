package com.example.covid_selef_treatment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BMIFragment extends Fragment {
   Button button;
    EditText txt_weight , txt_height;
    TextView result;
    float weight , height , value;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bmi, container, false);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        button = (Button) getActivity().findViewById(R.id.btn);
        txt_weight = getActivity().findViewById(R.id.weight);
        txt_height = getActivity().findViewById(R.id.height);
        result  = getActivity().findViewById(R.id.result);
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
