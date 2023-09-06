package com.example.covid_selef_treatment.factsaboutcovid;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_selef_treatment.R;

import java.util.List;

public class FactsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private static final int TYPE = 1;
    private final Context context;
    private final List<Object> listRecyclerItem;
    private  RecyclerViewClickListner listner;

    public FactsAdapter(Context context, List<Object> listRecyclerItem , RecyclerViewClickListner listner) {
        this.context = context;
        this.listRecyclerItem = listRecyclerItem;
        this.listner = listner;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE:

            default:

                View layoutView = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.factstaboutcovid_row, parent, false);

                return new ItemViewHolder((layoutView));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        int viewType = getItemViewType(position);

        switch (viewType) {
            case TYPE:
            default:
                final FactsAdapter.ItemViewHolder itemViewHolder = (FactsAdapter.ItemViewHolder) holder;
                FactsData data = (FactsData) listRecyclerItem.get(position);

                itemViewHolder.facttitle.setText(data.getTitle());
                itemViewHolder.factdetail.setText(data.getTitle());
               // itemViewHolder.factphoto.setImageResource(data.getFactphotoid());
                itemViewHolder.factphoto.setImageBitmap(decodeSampledBitmapFromResource(context.getResources(), data.getFactphotoid(), 200, 200));


        }
    }

    @Override
    public int getItemCount() {
        return listRecyclerItem.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView facttitle;
        private TextView factdetail;
        private ImageView factphoto;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            facttitle = itemView.findViewById(R.id.facttitle);
            factdetail = itemView.findViewById(R.id.factdetail);
            factphoto = itemView.findViewById(R.id.factphoto);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listner.onClick(view , getAdapterPosition());
        }
    }

    public interface  RecyclerViewClickListner{
        void onClick(View v , int position);
    }



    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
}
