package com.example.covid_selef_treatment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SignUp extends AppCompatActivity {
    TextView gotoLogin ;
    EditText birthday , fuallname, username, password1, password2 , phonenumber;
    Button signup_btn;
    final Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date;
    MyDatabaseHelper myDatabaseHelper;
    RadioGroup radioGroup;
    RadioButton radioButton;
    String fname, uname, pass1, pass2, phone, gender, bdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fuallname = (EditText) findViewById(R.id.fullname);
        username = (EditText) findViewById(R.id.username);
        password1 = (EditText) findViewById(R.id.password1);
        password2 = (EditText) findViewById(R.id.password2);
        phonenumber = (EditText) findViewById(R.id.phonenumber);
        birthday= (EditText) findViewById(R.id.birthday);
        radioGroup = (RadioGroup) findViewById(R.id.radioGrp);
        signup_btn = (Button) findViewById(R.id.btn_signup);

        myDatabaseHelper = new MyDatabaseHelper(this);


        date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        birthday.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(SignUp.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        gotoLogin = (TextView) findViewById(R.id.gotoLoginActivity);
        gotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();// Distroy this activity ---> disable back meanu
            }
        });




        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);
                fname = fuallname.getText().toString();
                uname = username.getText().toString();
                phone = phonenumber.getText().toString();
                gender = radioButton.getText().toString();
               pass1 = password1.getText().toString();
               pass2 = password2.getText().toString();
               bdate = birthday.getText().toString();
               if (fname.equals("") && uname.equals("") && phone.equals("") && bdate.equals("") && pass1.equals("") && pass2.equals("") ){
                  Toast.makeText(getApplicationContext(), R.string.all_fields_are_required, Toast.LENGTH_SHORT).show();
               }
               else{
                   if (pass1.equals(pass2)){
                       boolean status  = myDatabaseHelper.addUser(fname,uname,pass1,phone,bdate,gender);
                       if(status){
                           Toast.makeText(getApplicationContext(), R.string.registration_successfully, Toast.LENGTH_SHORT).show();
                           Intent intent  = new Intent(getApplicationContext(), Login.class);
                           startActivity(intent);
                           finish();
                       }
                       else {
                           Toast.makeText(getApplicationContext(), R.string.you_are_not_registred, Toast.LENGTH_SHORT).show();
                       }
                   }
                   else {
                       Toast.makeText(getApplicationContext(), R.string.password_doesnt_match, Toast.LENGTH_SHORT).show();
                   }
               }
            }
        });
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        birthday.setText(sdf.format(myCalendar.getTime()));
    }
}