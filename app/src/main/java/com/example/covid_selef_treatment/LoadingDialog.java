package com.example.covid_selef_treatment;

import android.app.Activity;
import android.view.LayoutInflater;

import androidx.appcompat.app.AlertDialog;

public class LoadingDialog {
    private  Activity activity;
    private  AlertDialog dialog;

    public LoadingDialog(Activity myActivity){
        activity = myActivity;
    }


    public void  setLoadingDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.progress_dialog,null));
        builder.setCancelable(false);
        dialog = builder.create();
        dialog.show();
    }
    public void  dismissDialog(){
        dialog.dismiss();
    }
}
