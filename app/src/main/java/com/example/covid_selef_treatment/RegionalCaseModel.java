package com.example.covid_selef_treatment;

public class RegionalCaseModel {
    public String region;
    public int activecase;
    public  int death;

    public String getRegion() {
        return region;
    }

    public int getActivecase() {
        return activecase;
    }

    public int getDeath() {
        return death;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setActivecase(int activecase) {
        this.activecase = activecase;
    }

    public void setDeath(int death) {
        this.death = death;
    }
}
