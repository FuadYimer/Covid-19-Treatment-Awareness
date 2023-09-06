package com.example.covid_selef_treatment.riskassesment;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codesgood.views.JustifiedTextView;
import com.example.covid_selef_treatment.GetQnAData;
import com.example.covid_selef_treatment.GetQnADataAdapter;
import com.example.covid_selef_treatment.R;

import java.util.List;

public class RecommendationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE = 1;
    private final Context context;
    private final List<Object> listRecyclerItem;

    public RecommendationAdapter(Context context, List<Object> listRecyclerItem) {
        this.context = context;
        this.listRecyclerItem = listRecyclerItem;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE:

            default:

                View layoutView = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.fragment_getdetail, parent, false);

                return new ItemViewHolder((layoutView));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        int viewType = getItemViewType(position);

        switch (viewType) {
            case TYPE:
            default:
                final ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
                GetQnAData data = (GetQnAData) listRecyclerItem.get(position);

                itemViewHolder.title.setText(data.getTitle());
                itemViewHolder.detail.setText(Html.fromHtml(data.getTitledetail()));


                // When Text view clicked
                itemViewHolder.title.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if( itemViewHolder.detail.getVisibility() == v.GONE){
                            itemViewHolder.detail.setVisibility(View.VISIBLE);
                            itemViewHolder.detailstatus.setImageResource(R.drawable.hide_block);

                        }
                        else {
                            itemViewHolder.detail.setVisibility(View.GONE);
                            itemViewHolder.detailstatus.setImageResource(R.drawable.display_block);
                        }

                    }
                });

                // When Image clicked
                itemViewHolder.detailstatus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if( itemViewHolder.detail.getVisibility() == v.GONE){
                            itemViewHolder.detail.setVisibility(View.VISIBLE);
                            itemViewHolder.detailstatus.setImageResource(R.drawable.hide_block);

                        }
                        else {
                            itemViewHolder.detail.setVisibility(View.GONE);
                            itemViewHolder.detailstatus.setImageResource(R.drawable.display_block);
                        }

                    }
                });
        }
    }

    @Override
    public int getItemCount() {
        return listRecyclerItem.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private JustifiedTextView detail;
        private ImageView detailstatus;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            detail = (JustifiedTextView) itemView.findViewById(R.id.detail);
            detailstatus = (ImageView) itemView.findViewById(R.id.detail_status);
        }
    }
}
