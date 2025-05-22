package com.example.pas_genap_02_10;

import com.google.gson.annotations.SerializedName;

public class JadwalPertandinganModel {
    @SerializedName("strEvent")
    private String strEvent;

    @SerializedName("strPoster")
    private String strPoster;

    @SerializedName("strHomeTeam")
    private String strHomeTeam;

    @SerializedName("strAwayTeam")
    private String strAwayTeam;

    @SerializedName("strHomeTeamBadge")
    private String strHomeTeamBadge;

    @SerializedName("strAwayTeamBadge")
    private String strAwayTeamBadge;

    @SerializedName("dateEventLocal")
    private String dateEventLocal;

    @SerializedName("strTimeLocal")
    private String strTimeLocal;

    JadwalPertandinganModel(String strEvent, String strPoster,String strHomeTeam,String strAwayTeam,String strHomeTeamBadge,String strAwayTeamBadge,String dateEventLocal, String strTimeLocal){
        this.strEvent = strEvent;
        this.strPoster = strPoster;
        this.strHomeTeam = strHomeTeam;
        this.strAwayTeam = strAwayTeam;
        this.strHomeTeamBadge = strHomeTeamBadge;
        this.strAwayTeamBadge = strAwayTeamBadge;
        this.dateEventLocal = dateEventLocal;
        this.strTimeLocal = strTimeLocal;
    }

    public String getStrEvent() {
        return strEvent;
    }

    public String getStrPoster() {
        return strPoster;
    }

    public String getStrHomeTeam() {
        return strHomeTeam;
    }

    public String getStrAwayTeam() {
        return strAwayTeam;
    }

    public String getStrHomeTeamBadge() {
        return strHomeTeamBadge;
    }

    public String getStrAwayTeamBadge() {
        return strAwayTeamBadge;
    }

    public String getDateEventLocal() {
        return dateEventLocal;
    }

    public String getStrTimeLocal() {
        return strTimeLocal;
    }
}
