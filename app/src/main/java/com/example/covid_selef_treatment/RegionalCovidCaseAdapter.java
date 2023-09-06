package com.example.covid_selef_treatment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RegionalCovidCaseAdapter extends RecyclerView.Adapter<RegionalCovidCaseAdapter.ViewHolder> {


    private Context context;
    private List<RegionalCaseModel> list;

    public RegionalCovidCaseAdapter(Context context, List<RegionalCaseModel> list) {
        this.context = context;
        this.list = list;
    }



    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_item_regional, parent, false);
        return new ViewHolder(v);
    
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RegionalCaseModel regionalCaseModel = list.get(position);

        holder.textRegion.setText(regionalCaseModel.getRegion());
        holder.textTotoalCase.setText(String.valueOf(regionalCaseModel.getActivecase()));
        holder.textDeath.setText(String.valueOf(regionalCaseModel.getDeath()));

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textRegion, textTotoalCase, textDeath;

        public ViewHolder(View itemView) {
            super(itemView);

            textRegion = itemView.findViewById(R.id.txt_region);
            textTotoalCase = itemView.findViewById(R.id.txt_totalcase);
            textDeath = itemView.findViewById(R.id.txt_death);
        }
    }
}
