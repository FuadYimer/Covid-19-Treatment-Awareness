package com.example.covid_selef_treatment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class CovidCases extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private  CovicCasesWorld covicCasesWorld;
    private  CovidCasesET covidCasesET;
    private  CovidCaseETRegional covidCaseETRegional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_cases);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);


        // Change fragment here later
        covidCasesET = new CovidCasesET();
        covicCasesWorld = new CovicCasesWorld();
        covidCaseETRegional = new CovidCaseETRegional();


        tabLayout.setupWithViewPager(viewPager);

     ViewPagerAdapter viewPagerAdapter  = new ViewPagerAdapter(getSupportFragmentManager(),0);

        viewPagerAdapter.addFragment(covidCasesET, getString(R.string.covid_cases_et));
        viewPagerAdapter.addFragment(covidCaseETRegional, getString(R.string.covid_et_regional));
        viewPagerAdapter.addFragment(covicCasesWorld, getString(R.string.covid_19_world));



        viewPager.setAdapter(viewPagerAdapter);

       tabLayout.getTabAt(0).setIcon(R.drawable.et);
        tabLayout.getTabAt(1).setIcon(R.drawable.world);
        tabLayout.getTabAt(2).setIcon(R.drawable.world);
    }


    private class ViewPagerAdapter  extends FragmentPagerAdapter {

        private List<Fragment> fragments = new ArrayList<>();
        private List<String> fragmentTitle = new ArrayList<>();

        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }
        public  void addFragment(Fragment fragment , String title){
            fragments.add(fragment);
            fragmentTitle.add(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitle.get(position);
        }
    }

}