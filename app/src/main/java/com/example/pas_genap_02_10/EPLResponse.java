package com.example.pas_genap_02_10;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EPLResponse {
    @SerializedName("teams")
    private List<EPLModel> teams;

    public List<EPLModel> getTeams() {
        return teams;
    }
}