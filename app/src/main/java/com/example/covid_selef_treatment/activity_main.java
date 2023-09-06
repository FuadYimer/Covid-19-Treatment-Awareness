package com.example.covid_selef_treatment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.example.covid_selef_treatment.factsaboutcovid.FactsAboutCovid19;
import com.example.covid_selef_treatment.riskassesment.Risk_Assesment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.Locale;


public class activity_main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private BottomNavigationView mMainNav;
    private FrameLayout mManiFrame;
    private SymptomFragment symptomFragment;
    private TreatmentFragment treatmentFragment;
    private PreventionFragment preventionFragment;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private AlertDialog.Builder dialogbuilder;
    private AlertDialog dialog;


    // Language parameter
    Locale myLocale;
    String currentLanguage = "en", currentLang;
    int current_selectedfragment;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        symptomFragment = new SymptomFragment();
        preventionFragment = new PreventionFragment();
        treatmentFragment = new TreatmentFragment();
        //Language setting
        currentLanguage = getIntent().getStringExtra(currentLang);


        // get selected fragment
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new DashBoardFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_dashboard);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.language_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.language_english:
                setLocale("en");
                break;
            case R.id.language_Amharic:
                setLocale("am");
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void setLocale(String localeName) {
        if (!localeName.equals(currentLanguage)) {
            myLocale = new Locale(localeName);
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = myLocale;
            res.updateConfiguration(conf, dm);
            Intent refresh = new Intent(this, activity_main.class);
            refresh.putExtra(currentLang, localeName);
            startActivity(refresh);
        } else {
            Toast.makeText(activity_main.this, R.string.languate_already_selected, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_dashboard:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DashBoardFragment()).commit();
                break;
            case R.id.nav_symptom:
               /* getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SymptomFragment()).commit();*/
                Intent intent = new Intent(activity_main.this, SyptomActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_prevention:
               /* getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new PreventionFragment2()).commit();*/
                intent = new Intent(activity_main.this, PreventionActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_treatment:
               /* getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CovicCasesWorld()).commit();*/
                 intent = new Intent(activity_main.this, TreatmentActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_survival:
                intent = new Intent(activity_main.this , SurvivalRateActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_qna:
                /*getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new QuestionAnswerFragment()).commit();*/
                intent = new Intent(activity_main.this, GetQuestionandAnswer.class);
                startActivity(intent);
                break;
            case R.id.nav_factsabtcovid:
                intent = new Intent(activity_main.this, FactsAboutCovid19.class);
                startActivity(intent);
                break;
            case  R.id.nav_selfchecker:
                intent = new Intent(activity_main.this , SelfChecker.class);
                startActivity(intent);
                break;
            case R.id.nav_riskassesment:
                intent = new Intent(activity_main.this, Risk_Assesment.class);
                startActivity(intent);
                break;
            case R.id.nav_bmi:
                intent = new Intent(activity_main.this, BMIActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_cases:
                /*getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CovidCasesET()).commit();*/
                intent = new Intent(activity_main.this, CovidCases.class);
                startActivity(intent);
                break;
            case R.id.nav_callcenter:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CallCenterFragment()).commit();
                break;
            case R.id.nav_share:
                Toast.makeText(this, R.string.share, Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_aboutus:
                CreateContactDialog();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    public void CreateContactDialog() {
        dialogbuilder = new AlertDialog.Builder(this);
        final View contactpopupview = getLayoutInflater().inflate(R.layout.contact_us, null);
        dialogbuilder.setView(contactpopupview);
        dialog = dialogbuilder.create();
        dialog.show();
    }

}
