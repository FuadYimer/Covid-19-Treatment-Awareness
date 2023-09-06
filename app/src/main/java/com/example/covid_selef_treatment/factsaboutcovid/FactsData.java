package com.example.covid_selef_treatment.factsaboutcovid;

public class FactsData {
    private final String title;
    private final String titledetail;
    private final int factphotoid;

    public FactsData(String title, String titledetail, int factphotoid) {
        this.title = title;
        this.titledetail = titledetail;
        this.factphotoid = factphotoid;
    }

    public String getTitle() {
        return title;
    }

    public int getFactphotoid() {
        return factphotoid;
    }

    public String getTitledetail() {
        return titledetail;
    }
}
